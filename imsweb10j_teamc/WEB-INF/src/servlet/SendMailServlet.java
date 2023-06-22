package servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.SendMail;
import bean.Inquiry;
import dao.InquiryDAO;

public class SendMailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		Inquiry inquiry_data = new Inquiry();
		// inquiryDAOオブジェクトの生成
		InquiryDAO inqDao = new InquiryDAO();

		try {

			// セッションからsubjectとreplyを取得する。
			HttpSession session = request.getSession();
			String subject_data = (String) session.getAttribute("subject_data");
			String reply_data = (String) session.getAttribute("reply_data");

			// 問い合わせ番号を取得する。
			inquiry_data = (Inquiry) session.getAttribute("inquiry_data");

			// 取得した問い合わせ情報を格納するInquiryオブジェクトの生成

			if (reply_data == null) {
				error = "セッション切れの為、メール送信が出来ません。";
				cmd = "menu";
				return;
			}

			// メール
			SendMail sendMail = new SendMail();
			// 文字コードの指定
			sendMail.setCodeType("iso-2022-jp");

			// 送信者のアドレスと送信者名の登録
			sendMail.setFromInfo("system.project.team41@kanda-it-school-system.com", "神田英会話スクール");
			// 送信先のメールアドレスの指定
			sendMail.setRecipients(inquiry_data.getEmail());
			// メールの件名の指定
			sendMail.setSubject(subject_data);
			// メールの本文の指定
			sendMail.setText(reply_data);
			sendMail.forwardMail();// 送信にかかわる設定のメソッド

			// 件名と本文のセッションを削除する。
			session.setAttribute("subject_data", null);
			session.setAttribute("reply_data", null);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、メール送信できませんでした。";
			cmd = "menu";

		} finally {

			if (error.equals("")) {
				// エラーがない場合、sendComplete.jspへフォワード
				inqDao.replyUpdate(inquiry_data);
				request.getRequestDispatcher("/view/sendComplete.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}

	}

}

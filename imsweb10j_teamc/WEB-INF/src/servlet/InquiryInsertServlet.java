//送信確認、メール送信

package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.Inquiry;
import dao.InquiryDAO;
import util.SendMail;

public class InquiryInsertServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		// セッション
		HttpSession session = request.getSession();

		try {

			// セッションからorderList取得
			Inquiry inquiry_data = (Inquiry) session.getAttribute("inquiryC_data");


			// 関連オブジェクト生成
			InquiryDAO objInqDao = new InquiryDAO();

			//取得した情報をDBに登録
			objInqDao.insert(inquiry_data);

			// セッションに登録
			session.setAttribute("inquiryC_data", inquiry_data);



			// メール
			SendMail sendMail = new SendMail();
			// 文字コードの指定
			sendMail.setCodeType("iso-2022-jp");

			// 送信者のアドレスと送信者名の登録
			sendMail.setFromInfo("system.project.team41@kanda-it-school-system.com", "神田英会話スクール");
			// 送信先のメールアドレスの指定
			sendMail.setRecipients(inquiry_data.getEmail());
			// メールの件名の指定
			sendMail.setSubject("お問い合わせありがとうございます。");
			// メールの本文の指定
			sendMail.setText(inquiry_data.getName() + "様\n\nお問い合わせありがとうございます。\n以下内容でお問い合わせを受け付けましたので、" + "ご連絡いたします。\n\n");
			// 問い合わせ内容を表示する
			sendMail.setText("名前："+ inquiry_data.getName() +"\n年齢："+ inquiry_data.getAge() +"\n住所："+ inquiry_data.getAddress() +"\n性別："+ inquiry_data.getGender() +"\nメールアドレス："+ inquiry_data.getEmail() +"\nお問い合わせ項目："+ inquiry_data.getCategory() +"\nお問い合わせ内容："+ inquiry_data.getContents());
			sendMail.setText("\n\n担当者からご登録のメールアドレス宛にご連絡いたします。今しばらくお待ちください。\nなお、このメールは自動送信です。");
			sendMail.setText("\n\n神田英会話スクール　代表　白石 大");
			sendMail.forwardMail();// 送信にかかわる設定のメソッド

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、送信できません。";
			cmd = "menu";

		} finally {
			// � エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はinquiryComplete.jspにフォワードする
				request.getRequestDispatcher("/view/inquiryComplete.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
		// セッションの情報を削除
		session.setAttribute("inquiryC_data", null);
		return;

	}

}

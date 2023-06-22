package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Inquiry;
import dao.InquiryDAO;

public class InquiryReplyFormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			// inquiry_idを取得
			String inquiry_id = (String) request.getParameter("inquiry_id");

			// 質問を検索する為のオブジェクトを生成
			InquiryDAO objDao = new InquiryDAO();
			Inquiry inquiry = new Inquiry();

			// selectByメソッドを呼び出し、オブジェクトに格納
			int inqid = Integer.parseInt(inquiry_id);
			inquiry = objDao.selectByInquiry_id(inqid);

			// セッションオブジェクトの生成
			HttpSession session = request.getSession();

			// セッションに格納
			session.setAttribute("inquiry_data", inquiry);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、質問を表示できません。";
			cmd = "menu";

		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はinsertIntoCart.jspにフォワード
				request.getRequestDispatcher("/view/inquiryReplyForm.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}

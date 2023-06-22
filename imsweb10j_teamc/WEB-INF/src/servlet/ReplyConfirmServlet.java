package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReplyConfirmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// セッションの生成
			HttpSession session = request.getSession();

			// subjectとreplyのパラメータを取得
			String subject_data = (String) request.getParameter("subject");
			String reply_data = (String) request.getParameter("reply");

			// セッションスコープに登録
			session.setAttribute("subject_data", subject_data);
			session.setAttribute("reply_data", reply_data);

		} catch (IllegalStateException e) {
			error = "エラーが発生しました。";
			cmd = "menu";
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はreplyConfirm.jspにフォワード
				request.getRequestDispatcher("/view/replyConfirm.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}

	}

}

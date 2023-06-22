package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// userIdとpass(フォワード先を区別するパラメータ)を取得
			String adminId = (String) request.getParameter("adminId");
			String password = (String) request.getParameter("password");

			// DAOオブジェクト宣言
			AdminDAO adminDao = new AdminDAO();
			// データベースのadminより引数のuserデータを取得する
			Admin admin = adminDao.selectByAdmin(adminId, password);

			// ユーザー情報のチェック
			if (admin.getAdminId() == null) {
				error = "入力データが間違っています。";
				cmd = "login";
				return;
			}

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新できませんでした。";
			cmd = "login";

		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// menu.jspにフォワードする
				request.getRequestDispatcher("/list").forward(request, response);
			} else {
				request.setAttribute("error", error);
				if (cmd.equals("login")) {
					// menu.jspにフォワードする
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/view/menu.jsp").forward(request, response);
				} else {
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}
			}
		}
	}

}
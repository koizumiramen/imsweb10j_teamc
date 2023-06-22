package servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;


import bean.Inquiry;
import dao.InquiryDAO;



public class InquiryFormServlet extends HttpServlet {

	// 引数で受け取った文字列が数値かどうか正規表現でチェックするメソッド
    public static boolean checkString(String text) {

        boolean res = true;

        Pattern pattern = Pattern.compile("^[0-9]+$|-[0-9]+$");
        res = pattern.matcher(text).matches();

        return res;
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String inputError = "";
		String cmd = "";

		try {
			// セッションオブジェクトの生成
			HttpSession session = request.getSession();

			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// 各データを取得
			String name = (String) request.getParameter("name");
			String age = (String) request.getParameter("age");
			String address = (String) request.getParameter("address");
			String gender = (String) request.getParameter("gender");
			String email = (String) request.getParameter("email");
			String category = (String) request.getParameter("category");
			String contents = (String) request.getParameter("contents");

			if (name == "" || age == "" || address == "" || gender == "" || email == "" || category == ""
					|| contents == "") {
				cmd = "yet";
				inputError = "※未入力の項目があります。※";
			}

			if (gender.equals("0")) {
				gender = "男性";
			} else {
				gender = "女性";
			}

			if (category.equals("1")) {
				category = "料金・お支払いについて";
			} else if (category.equals("2")) {
				category = "講座、コース、教材について";
			} else if (category.equals("3")) {
				category = "学習の進め方について";
			} else if (category.equals("4")) {
				category = "受講期限について";
			} else if (category.equals("5")) {
				category = "受講終了後のサポートについて";
			} else if (category.equals("6")) {
				category = "その他";
			}


			// DAOオブジェクト宣言
			Inquiry inq = new Inquiry();
			inq.setName(name);

			if(!checkString(age)){
				inq.setAge(0);
				if(cmd.equals("")) {
				cmd = "yet";
				inputError = "※年齢には半角数字を入力してください。※";
				}
			}else {
				inq.setAge(Integer.parseInt(age));
			}
			inq.setAddress(address);
			inq.setGender(gender);
			inq.setEmail(email);
			inq.setCategory(category);
			inq.setContents(contents);

			session.setAttribute("inquiryC_data", inq);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新できませんでした。";
			cmd = "login";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				request.setAttribute("cmd", cmd);
				request.setAttribute("inputError", inputError);
				if (cmd.equals("yet")) {
					request.getRequestDispatcher("/view/inquiryForm.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/view/inquiryInsert.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}
		}
	}

}

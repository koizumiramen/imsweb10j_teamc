<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Admin"%>

<%
	session.invalidate();
	String adminId = ""; //adminIdを格納する変数
	String password = ""; //passwordを格納する変数
	String error = (String) request.getAttribute("error");
	String cmd = (String) request.getAttribute("cmd");

	if (cmd == null) {
		cmd = "";
	}
%>

<html>
<head>
<title>ログイン画面</title>
</head>
<body>

	<!-- ヘッダー部分 -->
	<%@ include file="/common/header.jsp"%>


	<h2 style="text-align: center; font-size: 24px; margin-top: 50px">神田英会話スクール</h2>

	<div>
		<p style="text-align: center">
			<a href="<%=request.getContextPath()%>/view/inquiryForm.jsp">お問い合わせフォームご利用の方はこちら</a>
		</p>

		<form action="<%=request.getContextPath()%>/login" method="post">
			<table style="margin: auto; border: 0;">

				<tr>
					<td colspan="2">
						<p style="text-align: center; margin-top: 100px">管理者の方はログイン</p>
					</td>
				</tr>
			</table>

			<!-- エラーメッセージ表示 -->
			<%
				if (cmd.equals("login")) {
			%>
			<h3 style="text-align: center; color: red">※ログインIDもしくはパスワードが違います※</h3>
			<%
				}
			%>

			<table style="margin: auto; border: 0;">


				<tr>
					<td style="background-color: #6666FF;">ログインID</td>
					<td><input type=text size="30" name="adminId"
						value=<%=adminId%>></input></td>
				</tr>
				<tr>
					<td style="background-color: #6666FF;">パスワード</td>
					<td><input type=password size="30" name="password"
						value=<%=password%>></input></td>
				</tr>
				<tr>
					<td colspan="2">
						<p style="text-align: center;">
							<input type="submit" name="login" value="ログイン"></input>
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<!-- フッター部分 -->
	<%@ include file="/common/footer.jsp"%>

</body>
</html>
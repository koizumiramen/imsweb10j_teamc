<%@page contentType="text/html; charset=UTF-8"%>

<%
	String error = (String) request.getAttribute("error");
	if (error == null) {
		error = "";
	}
	String cmd = (String) request.getAttribute("cmd");
	if (cmd == null) {
		cmd = "menu";
	}
%>

<html>
<head>
<title>error（エラー）</title>
</head>
<body>
	<!-- ヘッダー部分 -->
	<div header>
		<%@include file="/common/header.jsp"%>
	</div>


	<!-- エラーメッセージ -->
	<div style="text-align: center; font-size: 20px;">
		<h2>■■エラー！■■</h2>
		<p class="error-msg"><%=error%></p>

		<p class="back-link">
			<%
				if (cmd.equals("menu")) {
			%>
			<a href="<%=request.getContextPath()%>/view/menu.jsp">[トップに戻る]</a>
			<%
				} else if (cmd.equals("inquiryForm")) {
			%>
			<a href="<%=request.getContextPath()%>/inquiryForm">[問い合わせフォームに戻る]</a>
			<%
				} else if (cmd.equals("list")) {
			%>
			<a href="<%=request.getContextPath()%>/list">[問い合わせ一覧に戻る]</a>
			<%
				}
			%>
		</p>
	</div>

	<!-- フッター部分 -->
	<div footer style="margin-top: 200px;">
		<%@include file="/common/footer.jsp"%>
	</div>

</body>
</html>
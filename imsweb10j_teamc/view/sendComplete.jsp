<!--<%@page contentType="text/html; charset=UTF-8"%>-->


<html>
<head>
<title>返信完了画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<div align="center";>
		<div style="margin-top: 200px;">
			<h2>送信しました。</h2>

			<form action="<%=request.getContextPath()%>/list" method="post">
				<input type="submit" name="listReturn" value="お問い合わせ一覧に戻る"></input>
			</form>

			<form action="<%=request.getContextPath()%>/view/menu.jsp">
				<input type="submit" name="topReturn" value="トップに戻る"></input>
			</form>
		</div>

	</div>

</body>
</html>
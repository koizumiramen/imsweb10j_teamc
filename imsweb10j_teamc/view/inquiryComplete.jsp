<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>inquiryComplete（問い合わせ完了）</title>
</head>
<body>
	<div class=container>

		<!-- ヘッダー部分 -->
		<div header>
			<%@include file="/common/header.jsp"%>
		</div>

		<!-- 問い合わせ完了メッセージ -->
		<div style="text-align: center; font-size: 20px;">
			<h2>お問い合わせを送信しました。</h2>
			<a href="<%=request.getContextPath()%>/view/menu.jsp">トップに戻る</a><br>
			<br> ＊ご登録のメールアドレス宛に、担当者からご連絡いたします。
		</div>

		<!-- フッター部分 -->
		<div footer style="margin-top: 200px;">
			<%@include file="/common/footer.jsp"%>
		</div>
	</div>

</body>
</html>
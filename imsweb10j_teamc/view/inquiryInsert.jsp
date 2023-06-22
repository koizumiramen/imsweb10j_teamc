<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Inquiry"%>

<%
	Inquiry inquiry_data = (Inquiry) session.getAttribute("inquiryC_data");
%>

<html>
<head>
<title>inquiryInsert（お問い合わせ内容確認）</title>
</head>
<body>
	<div class=container>
		<!-- ヘッダー -->
		<div header>
			<%@include file="/common/header.jsp"%>
		</div>

		<!-- 内容内容確認 -->
		<h3 style="text-align: center">問い合わせ内容確認</h3>
		<table style="margin: auto; border: 0; text-align: center">
			<tr>
				<td style="background-color: #6666FF; text-align: right">名前：</td>
				<td style="text-align: left"><%=inquiry_data.getName()%></td>
			</tr>
			<tr>
				<td style="background-color: #6666FF; text-align: right">年齢：</td>
				<td style="text-align: left"><%=inquiry_data.getAge()%></td>
			</tr>
			<tr>
				<td style="background-color: #6666FF; text-align: right">住所：</td>
				<td style="text-align: left"><%=inquiry_data.getAddress()%></td>
			</tr>
			<tr>
				<td style="background-color: #6666FF; text-align: right">性別：</td>
				<td style="text-align: left"><%=inquiry_data.getGender()%></td>
			</tr>
			<tr>
				<td style="background-color: #6666FF; text-align: right">メールアドレス：</td>
				<td style="text-align: left"><%=inquiry_data.getEmail()%></td>
			</tr>
			<tr>
				<td style="background-color: #6666FF; text-align: right">お問い合わせ項目：</td>
				<td style="text-align: left"><%=inquiry_data.getCategory()%></td>
			</tr>
			<tr>
				<td style="background-color: #6666FF; text-align: right">お問い合わせ内容：</td>
				<td style="text-align: left">
					<div contents
						style="padding: 30px; margin-bottom: 10px; border: 1px solid #333333;">
						<%=inquiry_data.getContents()%>
					</div>
				</td>
			</tr>
		</table>

		<!-- 送信・修正 -->
		<div style="text-align: center">
			<br>上記の内容で送信してもよろしいですか？<br> <br>
			<div style="display: inline-flex">
				<form action="<%=request.getContextPath()%>/view/inquiryForm.jsp"
					class="change-button">
					<input type="submit" value="修正"
						style="display: inline-block; outline: none; cursor: pointer; font-size: 14px; line-height: 1; border-radius: 500px; transition-property: background-color, border-color, color, box-shadow, filter; transition-duration: .3s; border: 1px solid transparent; letter-spacing: 2px; min-width: 160px; text-transform: uppercase; white-space: normal; font-weight: 700; text-align: center; padding: 16px 14px 18px; color: black; box-shadow: inset 0 0 0 2px black; background-color: #F98866; height: 48px; : hover { color : #fff; background-color: #80bd9e;">
				</form>

				<form action="<%=request.getContextPath()%>/inquiryInsert"
					class="send-button">
					<input type="submit" value="送信"
						style="display: inline-block; outline: none; cursor: pointer; font-size: 14px; line-height: 1; border-radius: 500px; transition-property: background-color, border-color, color, box-shadow, filter; transition-duration: .3s; border: 1px solid transparent; letter-spacing: 2px; min-width: 160px; text-transform: uppercase; white-space: normal; font-weight: 700; text-align: center; padding: 16px 14px 18px; color: black; box-shadow: inset 0 0 0 2px black; background-color: #6666FF; height: 48px; : hover { color : #fff; background-color: #80bd9e;">
				</form>
			</div>
		</div>
	</div>
	<!-- フッター -->
	<div footer>
		<%@include file="/common/footer.jsp"%>
	</div>
</body>
</html>
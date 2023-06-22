<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Inquiry"%>

<%
	Inquiry inquiry_data = (Inquiry) session.getAttribute("inquiry_data");
	String subject_data = (String) session.getAttribute("subject_data");
	String reply_data = (String) session.getAttribute("reply_data");
%>

<html>
<head>
<title>返信確認画面</title>
</head>
<body>
	<!-- ページタイトル -->
	<h2 style="text-align: center; margin-top:50px">お問い合わせ内容</h2>

	<hr style="text-align: center; height: 5px; background-color: #80bd9e; width: 950px">

	<!-- お問い合わせ内容部分 -->
	<table style="margin: auto; border: 0;">
			<tr>
				<td style="text-align: right; background-color: #80bd9e" colspan="2">日付：</td>
				<td><%=inquiry_data.getDate()%></td>
			</tr>
			<tr>
				<td style="text-align: right; background-color: #80bd9e" colspan="2">名前：</td>
				<td><%=inquiry_data.getName()%></td>
			</tr>
			<tr>
				<td style="text-align: right; background-color: #80bd9e" colspan="2">年齢：</td>
				<td><%=inquiry_data.getAge()%>歳</td>
			</tr>
			<tr>
				<td style="text-align: right; background-color: #80bd9e" colspan="2">性別：</td>
				<td><%=inquiry_data.getGender()%></td>
			</tr>
			<tr>
				<td style="text-align: right; background-color: #80bd9e" colspan="2">住所：</td>
				<td colspan="6"><%=inquiry_data.getAddress()%></td>
			</tr>
			<tr>
				<td style="text-align: center; background-color: #80bd9e" colspan="2">お問い合わせ項目：</td>
				<td colspan="6"><%=inquiry_data.getCategory()%></td>
			</tr>
			<tr>
				<td style="text-align: center; background-color: #80bd9e" colspan="2">お問い合わせ内容：</td>
				<td colspan="6"><%=inquiry_data.getContents()%></td>
			</tr>
		</table>
	<!--  入力内容確認 -->
	<h3 style="text-align: center; margin-top:100px">記入内容</h3>

	<div>
		<table style="margin: auto; border: 0;">
			<tr>
				<td>件名：</td>
				<td><%=subject_data%></td>
			</tr>
			<tr>
				<td>本文：</td>
				<td><%=reply_data%></td>
			</tr>
		</table>
	</div>

	<div align="middle">

		<p>上記の内容で送信してよろしいですか？</p>

		<div style="display: inline-flex">

		<form
				action="<%=request.getContextPath()%>/view/inquiryReplyForm.jsp"
				class="change-button">
				<input type="submit" value="修正" style="
				display: inline-block;
					outline: none;
					cursor: pointer;
					font-size: 14px;
					line-height: 1;
					border-radius: 500px;
					transition-property: background-color,border-color,color,box-shadow,filter;
					transition-duration: .3s;
					border: 1px solid transparent;
					letter-spacing: 2px;
					min-width: 160px;
					text-transform: uppercase;
					white-space: normal;
					font-weight: 700;
					text-align: center;
					padding: 16px 14px 18px;
					color: black;
					box-shadow: inset 0 0 0 2px black;
					background-color: #F98866;
					height: 48px;
					:hover{
						color: #fff;
						background-color: #80bd9e;
					}">
			</form>

			<form action="<%=request.getContextPath()%>/sendMail"
				class="send-button">

				<input type="submit" value="送信" style="
					display: inline-block;
					outline: none;
					cursor: pointer;
					font-size: 14px;
					line-height: 1;
					border-radius: 500px;
					transition-property: background-color,border-color,color,box-shadow,filter;
					transition-duration: .3s;
					border: 1px solid transparent;
					letter-spacing: 2px;
					min-width: 160px;
					text-transform: uppercase;
					white-space: normal;
					font-weight: 700;
					text-align: center;
					padding: 16px 14px 18px;
					color: black;
					box-shadow: inset 0 0 0 2px black;
					background-color: #80bd9e;
					height: 48px;
					:hover{
						color: #fff;
						background-color: #80bd9e;
					}">
			</form>

		</div>
	</div>

</body>
</html>
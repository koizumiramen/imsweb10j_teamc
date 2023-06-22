<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Inquiry"%>

<%
	Inquiry inquiry_data = (Inquiry) session.getAttribute("inquiry_data");
	String subject_data = (String) session.getAttribute("subject_data");
	String reply_data = (String) session.getAttribute("reply_data");

	if (inquiry_data == null) {
		inquiry_data = new Inquiry();
		inquiry_data.setName("");
		inquiry_data.setGender("");
		inquiry_data.setAddress("");
		inquiry_data.setCategory("");
		inquiry_data.setContents("");
		inquiry_data.setDate("");
	}

	if (subject_data == null) {
		subject_data = "";
	}

	if (reply_data == null) {
		reply_data = "";
	}
%>

<html>
<head>
<title>お問い合わせ管理システム</title>
</head>
<body>
	<!-- 内容確認 -->
	<h2 style="text-align: center; font-size: 24px; margin-top: 50px">お問い合わせ返信フォーム</h2>

	<hr
		style="text-align: center; height: 5px; background-color: #80bd9e; width: 950px">

	<div>
		<h3 style="text-align: center">お問い合わせ内容</h3>
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
				<td style="text-align: center; background-color: #80bd9e"
					colspan="2">お問い合わせ項目：</td>
				<td colspan="6"><%=inquiry_data.getCategory()%></td>
			</tr>
			<tr>
				<td style="text-align: center; background-color: #80bd9e"
					colspan="2">お問い合わせ内容：</td>
				<td colspan="6"><%=inquiry_data.getContents()%></td>
			</tr>
		</table>

		<form action="<%=request.getContextPath()%>/replyConfirm" method="get">
			<h3 style="text-align: center; margin-top: 50px">返信メッセージ</h3>
			<table style="margin: auto; border: 0;">
				<tr>
					<td style="text-align: center">件名</td>
				</tr>
				<tr>
					<td><input type=text size="75" name="subject"
						value=<%=subject_data%>></input></td>
				</tr>
				<tr>
					<td style="text-align: center">本文</td>
				</tr>
				<tr>
					<td><textarea rows="5" cols="75" name="reply"><%=reply_data%></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<p style="text-align: center;">
							<input type="submit" name="confirmation" value="確認する"
								style="background-color: #80bd9e;"></input>
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
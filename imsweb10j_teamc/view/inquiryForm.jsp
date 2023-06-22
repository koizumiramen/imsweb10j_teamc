<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Inquiry"%>

<%
	Inquiry inquiry_data = (Inquiry) session.getAttribute("inquiryC_data");

	if (inquiry_data == null) {
		inquiry_data = new Inquiry();
		inquiry_data.setName("");
		inquiry_data.setGender("");
		inquiry_data.setEmail("");
		inquiry_data.setAddress("");
		inquiry_data.setCategory("");
		inquiry_data.setContents("");
		inquiry_data.setDate("");
	}

	String cmd = (String) request.getAttribute("cmd");

	if (cmd == null) {
		cmd = "";
	}

	String inputError = (String) request.getAttribute("inputError");

	if (inputError == null) {
		inputError = "";
	}
%>

<html>
<head>
<title>お問い合わせ管理システム</title>
</head>
<body>

	<!-- ヘッダー部分 -->
	<%@ include file="/common/header.jsp"%>

	<!-- 内容確認 -->
	<h2 style="text-align: center; font-size: 24px">お問い合わせフォーム</h2>

	<%
		if (cmd.equals("yet")) {
	%>
	<h3 style="text-align: center; color: red"><%=inputError %></h3>
	<%
		}
	%>

	<div>
		<form action="<%=request.getContextPath()%>/inquiryForm" method="get">
			<table style="margin: auto; border: 0;">
				<tr>
					<td style="background-color: #6666FF; text-align: right">名前</td>
					<td><input type=text size="30" name="name"
						value=<%=inquiry_data.getName()%>></input></td>
				</tr>
				<tr>
					<td style="background-color: #6666FF; text-align: right">年齢</td>
					<%if(inquiry_data.getAge() != 0){ %>
					<td><input type=text size="30" name="age"
						value=<%=inquiry_data.getAge()%>></input></td>
						<%}else{ %>
						<td><input type=text size="30" name="age"
						></input></td>
						<%}%>
				</tr>
				<tr>
					<td style="background-color: #6666FF; text-align: right">住所</td>
					<td><input type=text size="30" name="address"
						value=<%=inquiry_data.getAddress()%>></input></td>
				</tr>
				<tr>
					<td style="background-color: #6666FF; text-align: right">性別</td>
					<% if(inquiry_data.getGender().equals("女性")) {%>
						<td>男性<input type="radio" name="gender" value="0">
							女性<input type="radio" name="gender" value="1" checked></td>
					<% }else{ %>
						<td>男性<input type="radio" name="gender" value="0" checked>
							女性<input type="radio" name="gender" value="1"></td>
					<% } %>
				</tr>
				<tr>
					<td style="background-color: #6666FF; text-align: right">メールアドレス</td>
					<td><input type=text size="30" name="email"
						value=<%=inquiry_data.getEmail()%>></input></td>
				</tr>
				<tr>
					<td style="background-color: #6666FF; text-align: right">お問い合わせ項目</td>
					<td><select name="category">
							<option selected><%=inquiry_data.getCategory() %></option>
							<option value="1">料金・お支払いについて</option>
							<option value="2">講座、コース、教材について</option>
							<option value="3">学習の進め方について</option>
							<option value="4">受講期限について</option>
							<option value="5">受講終了後のサポートについて</option>
							<option value="6">その他</option>
					</select></td>
				</tr>
				<tr>
					<td style="background-color: #6666FF; text-align: right">お問い合わせ内容</td>
					<td><textarea name="contents" rows="5" cols="32"><%=inquiry_data.getContents()%></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<p style="text-align: center;">
							<input type="submit" name="confirmation" value="確認する"
								style="background-color: #FFEE77;"></input>
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<!-- フッダー部分 -->
	<%@ include file="/common/footer.jsp"%>

</body>
</html>
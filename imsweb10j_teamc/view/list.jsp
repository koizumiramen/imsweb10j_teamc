<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Inquiry"%>

<%
	ArrayList<Inquiry> inquiry_list = (ArrayList<Inquiry>) request.getAttribute("inquiry_list");
%>

<html>
<head>
<title>お問い合わせ一覧</title>
</head>
<body>

	<table style="margin: auto; width: 850px">
		<tr>
			<td style="width: 80px">&nbsp;</td>
			<td style="width: 80px">&nbsp;</td>
			<td><h3 style="text-align: center; width: 508px; font-size: 24px; margin-top:50px">お問い合わせ一覧</h3></td>
			<td style="width: 80px">&nbsp;</td>
			<td style="text-align: center; width: 150px">[<a
				href="<%=request.getContextPath()%>/view/menu.jsp">トップへ戻る</a>]
			</td>
		</tr>
	</table>

	<hr
		style="text-align: center; height: 2px; background-color: #80bd9e; width: 950px">
	<div style="margin-bottom: 150px">

		<table style="margin: auto">
			<tr>
				<th style="background-color: #80bd9e; width: 100px">受信日時</th>
				<th style="background-color: #80bd9e; width: 200px">名前</th>
				<th style="background-color: #80bd9e; width: 220px">項目</th>
				<th style="background-color: #80bd9e; width: 350px">内容</th>
				<th style="background-color: #80bd9e; width: 100px">返信状況<br>(未/済)
				</th>
			</tr>
			<%
				if (inquiry_list != null) {
					for (Inquiry inquiries : inquiry_list) {
			%>
			<tr>
				<td style="text-align: center; width: 100px"><%=inquiries.getDate()%></td>
				<td style="text-align: center; width: 200px"><%=inquiries.getName()%></td>
				<td style="text-align: center; width: 100px"><%=inquiries.getCategory()%></td>
				<td style="text-align: center; width: 350px"><a
					href="<%=request.getContextPath()%>/inquiryReplyForm?inquiry_id=<%=inquiries.getInquiry_id()%>">
						&nbsp;&nbsp;<%=inquiries.getContents()%></a></td>

				<%
					if (inquiries.getStatus() == 0) {
				%>
				<td style="text-align: center; width: 100px; color:#ff420e">未</td>
				<%
					} else {
				%>
				<td style="text-align: center; width: 100px">済</td>
				<%
					}
				%>
			</tr>
			<%
				}
				} else {
			%>
			<tr>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 250px">&nbsp;</td>
				<td style="text-align: center; width: 250px">&nbsp;</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>
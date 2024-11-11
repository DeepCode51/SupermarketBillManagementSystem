<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1-100之间的数，数字放在表格中显示</title>
</head>
<body>
<h3>1-100之间的数字放在表格中显示</h3>
	<%
	int x = 1;
	%>
	<table border="1">
		<%
		for (int i = 0; i < 10; i++) {//控制行数
		%>
		<tr>
			<%
			for (int j = 0; j < 10; j++) {//控制列数
			%>
			<td><%=x%> 
			<%
 				x++;
 			%>
 </td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
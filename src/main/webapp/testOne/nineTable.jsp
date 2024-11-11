<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>九九乘法表</title>
</head>
<body>
<h3 align="center">正序字体颜色改变输出</h3>
	<table>
		<%
		for (int i = 1; i <= 9; i++) {
		%>
		<tr
			style="color: rgb(<%=(int) (Math.random() * 255 + 1)%>,<%=(int) (Math.random() * 255 + 1)%>,<%=(int) (Math.random() * 255 + 1)%>)">
			<%
			for (int j = 1; j <= i; j++) {
			%>
			<td><%=i + "*" + j + "=" + (i * j)%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
	<hr>
	<h3 align="center">正序每个元素随机改变输出</h3>
	<table>
		<%
		for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<%
			for (int j = 1; j <= i; j++) {
			%>
			<td
				style="color: rgb(<%=(int) (Math.random() * 255 + 1)%>,<%=(int) (Math.random() * 255 + 1)%>,<%=(int) (Math.random() * 255 + 1)%>)">
				<%=i + "*" + j + "=" + (i * j)%>
			</td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
	<hr>
	<h3 align="center">倒序每个元素背景颜色随机改变输出</h3>
	<table>
		<%
		for (int i = 9; i >= 1; i--) {
		%>
		<tr
			style="background: rgb(<%=(int) (Math.random() * 255 + 1)%>,<%=(int) (Math.random() * 255 + 1)%>,<%=(int) (Math.random() * 255 + 1)%>)">
			<%
			for (int j = 1; j <= i; j++) {
			%>
			<td><%=i + "*" + j + "=" + (i * j)%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
	<hr>
	<h3 align="center">正序背景颜色改变输出</h3>
	<table>
		<%
		for (int i = 1; i <= 9; i++) {
		%>
		<tr
			style="background: rgb(<%=(int) (Math.random() * 255 + 1)%>,<%=(int) (Math.random() * 255 + 1)%>,<%=(int) (Math.random() * 255 + 1)%>)">
			<%
			for (int j = 1; j <= i; j++) {
			%>
			<td><%=i + "*" + j + "=" + (i * j)%></td>
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
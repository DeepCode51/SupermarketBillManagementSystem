<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>求1-100的和</title>
</head>
<body>
	<%
		int sum =0;
		for(int i = 1; i<=100;i++){
			sum+=i;
		}
	%>
	<h3>1-100连续的和</h3>
	<div style="color: red">1+2+3+.......+100的和为：<%= sum %>。</div>
</body>
</html>
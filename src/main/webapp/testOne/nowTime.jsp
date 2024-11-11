<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 导入SimpleDateFormat与date包 -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示当前时间</title>
</head>
<body>
	<%
	Date date = new Date();//创建一个Date对象
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("现在是" + "yyyy年MM月dd日 E a hh点mm分ss秒");
	//创建一个SimpleDateFormat对象
	response.setHeader("Refresh", "1");//一秒更新一次
	%>
	<h1>系统时间</h1>
	当前时间：<%=date%>
	<br>
	<%=simpleDateFormat.format(date)%>
</body>
</html>
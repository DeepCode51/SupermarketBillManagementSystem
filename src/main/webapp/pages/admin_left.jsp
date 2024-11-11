<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body class="frame-bd">
<ul class="left-menu">

	<c:if test="${sessionScope.loginUserRole == '1'}">
	<li><a href="/supermarket/selectbill" target="mainFrame"><img src="../images/btn_bill.gif" /></a></li>
	<li><a href="/supermarket/selectprovider" target="mainFrame"><img src="../images/btn_suppliers.gif" /></a></li>
	<li><a href="/supermarket/selectUser" target="mainFrame"><img src="../images/btn_users.gif" /></a></li>

	</c:if>
	<c:if test="${sessionScope.loginUserRole != '1'}">
	<li><a href="/supermarket/selectbill" target="mainFrame"><img src="../images/btn_bill.gif" /></a></li>
	
	</c:if>
	
	<li><a href="/supermarket/login.jsp" target="_parent" onClick="javaScript:alert('账号已退出！')"><img src="../images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>

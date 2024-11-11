<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>超市账单管理系统</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>

<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="admin_top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
    <frameset cols="200,*" frameborder="no" border="0" framespacing="0">
        <frame src="admin_left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" />
        <frame src="/supermarket/selectbill" name="mainFrame" id="mainFrame" />
    </frameset>
</frameset>
<noframes>

    <body>
    </body>
</noframes>

</html>
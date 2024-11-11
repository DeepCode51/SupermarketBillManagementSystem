<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>


<body class="blue-style">
    <div id="login">
        <div class="icon"></div>
        <div class="login-box">
            <form  action="login" method="post">
                <dl>
                    <dt>用户名：</dt>
                    <dd><input type="text" name="userUser" class="input-text" value="${requestScope.userUser}"/></dd>
                    <dt>密　码：</dt>
                    <dd><input type="password" name="userpwd" class="input-text"/></dd>
                </dl>
                <div class="buttons">
                    <input type="submit" name="submit" value="登录系统" class="input-button" />
                    <input type="reset" name="reset" value="重　　填" class="input-button" />
                </div>
            </form>
            ${message}
            <%= application.getAttribute("message")==null? "": application.getAttribute("message") %>
        </div>
    </div>
    <c:remove var="message" scope="session"/>
</body>


</html>
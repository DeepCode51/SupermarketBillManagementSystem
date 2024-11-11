<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function checkit() {
		//判断是否是数字的正则表达式
		return true;
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>

		</div>
		<form id="form1" name="form1" method="post"
			action="/supermarket/userpassupdate" onsubmit="return checkit();">
			<input type="hidden" name="flag" value="doAdd">
			<input type="hidden" name="userId" value="${requestScope.userId}">
			<div class="content">
				<table class="box">
					<font color="red"></font>
					<tr>
						<td class="field">旧的密码：</td>
						<td><input type="password" name="pass" class="text"
							id="textfield2" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">新的密码：</td>
						<td><input type="password" name="password" class="text" /> <font
							color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input type="password" name="password1" class="text" /> <font
							color="red">*</font></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
					<input type="submit" name="button" id="button" value="修改密码"
					class="input-button" /> <input type="button" name="button"
					id="button" onclick="window.location='/useradd';" value="返回"
					class="input-button" />

			</div>
		</form>
		${message}
		<%=application.getAttribute("message") == null ? "" : application.getAttribute("message")%>

	</div>
</body>
</html>

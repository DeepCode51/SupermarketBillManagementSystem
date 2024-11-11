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
			action="/supermarket/useradd" onsubmit="return checkit();">
			<input type="hidden" name="flag" value="doAdd">
			<input type="hidden" name="userId" value="${requestScope.user.userId}">
			<div class="content">
				<table class="box">
					<font color="red"></font>
					<tr>
						<td class="field">用户编号：</td>
						<td><input type="text" name="userOn" id="textfield"
							class="text" value="${requestScope.user.userOn}" /> <font
							color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户名称：</td>
						<td><input type="text" name="username" class="text"
							id="textfield2" value="${requestScope.user.userName}" /> <font
							color="red">*</font></td>
					</tr>
					<c:if test="${empty requestScope.user.userId}">
					<tr>
						<td class="field">用户密码：</td>
						<td><input type="password" name="password" class="text"
							id="textfield2" /> <font color="red">*</font></td>
					</tr>
					
					<tr>
						<td class="field">确认密码：</td>
						<td><input type="password" name="password1" class="text" /> <font
							color="red">*</font></td>
					</tr>
					</c:if>
					

					<tr>
						<td class="field">用户性别：</td>
						<td><select name="sex" id="select">
								<option value="0"
									${requestScope.user.userSex =="0"?"selected='selected'":""}>女</option>
								<option value="1"
									${requestScope.user.userSex =="0"?"":"selected='selected'"}>男</option>
						</select></td>
					</tr>

					<tr>
						<td class="field">用户年龄：</td>
						<td><input type="text" name="age" class="text"
							id="textfield2" value="${requestScope.user.userAge}"/> <font
							color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td><input type="text" name="mobile" class="text"
							id="textfield2" value="${requestScope.user.userTel}"/> <font
							color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td><textarea name="address" id="textarea" class="text"
								cols="45" rows="5">${requestScope.user.userLoc}</textarea></td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td><input type="radio" name="auth" id="auth" value="1"
							${requestScope.user.userRole =="管理员"?"checked='checked'":""} />管理员
							<input type="radio" name="auth" id="auth" value="2"
							${requestScope.user.userRole =="管理员"?"":"checked='checked'"} />普通用户
						</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
			
			<c:if test="${empty requestScope.user.userId}">
					<input type="submit" name="button" id="button" value="数据提交"
					class="input-button" /> <input type="button" name="button"
					id="button" onclick="window.location='/useradd';" value="返回"
					class="input-button" />
			</c:if>
			<c:if test="${!empty requestScope.user.userId}">
					<input type="button" name="button"id="button" onclick="window.location='/useradd';" value="返回" class="input-button" />
					<input type="submit" name="button" id="button" value="修改" class="input-button" />
					<a class="input-button" onclick="return confirm('确定要删除当前用户吗？')" href="<c:url value='/userdel?userId=${requestScope.user.userId}'></c:url>">删除</a>
					<a class="input-button" href="<c:url value='/userpassupdate?userId=${requestScope.user.userId}'></c:url>">修改密码</a>
				
			</c:if>
				
			</div>
		</form>
		${message}
		<%=application.getAttribute("message") == null ? "" : application.getAttribute("message")%>

	</div>
</body>
</html>

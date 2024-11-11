<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
	}
</script>
</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="">
							<input name="flag" value="search" class="input-text"
								type="hidden"> 用户名称：<input name="userName"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='/supermarket/useradd'" type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">用户名称</div></td>
						<td width="100"><div class="STYLE1" align="center">性别</div></td>
						<td width="100"><div class="STYLE1" align="center">年龄</div></td>

						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">地址</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
					</tr>

					<c:if test="${!empty requestScope.userList}">
						<!-- 判断request中userlist的集合长度是否大于0 -->
						<c:if test="${fn:length(requestScope.userList) gt 0 }">
							<!-- 使用循环将数据显示在页面的表格中 -->
							<c:forEach items="${requestScope.userList}" var="user"
								varStatus="loop">
								<tr>
									<td height="23"><span class="STYLE1">${pageScope.user.userOn}</span></td>
									<td><span class="STYLE1"><a href="/supermarket/useradd?userId=${pageScope.user.userId}" onclick="doit('mod',1)">${pageScope.user.userName}</a></span></td>
									<td><span class="STYLE1">${pageScope.user.userSex}</span></td>
									<td><span class="STYLE1">${pageScope.user.userAge}</span></td>
									<td><span class="STYLE1">${pageScope.user.userTel}</span></td>
									<td><span class="STYLE1">${pageScope.user.userLoc}</span></td>
									<td><span class="STYLE1">${pageScope.user.userRole}</span></td>
								</tr>
							</c:forEach>
						</c:if>
					</c:if>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
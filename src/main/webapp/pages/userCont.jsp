<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
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
			<div class="content">
				<table class="box">
					<font color="red"></font>
					<tr>
						<td class="field">用户编号：</td>
						<td><input type="text" name="userId" id="textfield"
							class="text" /> <font color="red">*</font></td>

					</tr>
					<tr>
						<td class="field">用户名称：</td>
						<td><input type="text" name="username" class="text"
							id="textfield2" /> <font color="red">*</font></td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td><select name="sex" id="select">
								<option value="0">女</option>
								<option value="1">男</option>
						</select></td>
					</tr>
					<tr>
						<td class="field">用户年龄：</td>
						<td><input type="text" name="age" class="text"
							id="textfield2" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td><input type="text" name="mobile" class="text"
							id="textfield2" /> <font color="red">*</font></td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td><textarea name="address" id="textarea" class="text"
								cols="45" rows="5"></textarea></td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td><input type="radio" name="auth" id="auth" value="1"
							checked="checked" />管理员 <input type="radio" name="auth" id="auth"
							value="2" />普通用户</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="button" id="button" value="数据提交"
					class="input-button" /> <input type="button" name="button"
					id="button" onclick="window.location='/useradd';" value="返回"
					class="input-button" />
			</div>

		</form>
	</div>
</body>
</html>

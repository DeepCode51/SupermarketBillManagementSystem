<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
		window.location = "provider.do?id=" + id + "&flag=" + flag;
	}
</script>
</head>
<body>
	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="get" action="">
							<input name="flag" value="search" type="hidden"> 供应商名称：<input
								name="providerName" class="input-text" type="text">
							&nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input
								value="组 合 查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='/supermarket/provideradd'"
				type="button"></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
						<td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
						<td width="100"><div class="STYLE1" align="center">联系人</div></td>

						<td width="100"><div class="STYLE1" align="center">电话</div></td>
						<td width="100"><div class="STYLE1" align="center">地址</div></td>
					</tr>
					<tr>
						<c:if test="${!empty requestScope.providerList}">
							<!-- 判断request中userlist的集合长度是否大于0 -->
							<c:if test="${fn:length(requestScope.providerList) gt 0 }">
								<!-- 使用循环将数据显示在页面的表格中 -->
								<c:forEach items="${requestScope.providerList}" var="provider"
									varStatus="loop">
									<tr>
										<td>${pageScope.provider.providerNo}</td>
										<td><a href="/supermarket/provideradd?providerId=${pageScope.provider.providerId}">${pageScope.provider.providerName}</a></td>
										<td>${pageScope.provider.providerDescribe}</td>
										<td>${pageScope.provider.providerContacts}</td>
										<td>${pageScope.provider.providerTel}</td>
										<td>${pageScope.provider.providerLoc}</td>
									</tr>
								</c:forEach>
							</c:if>
						</c:if>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
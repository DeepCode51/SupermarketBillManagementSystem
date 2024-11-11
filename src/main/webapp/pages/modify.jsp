<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="menu">
		<form method="get" action="">
			商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			是否付款：<select name="payStatus">
				<option value="">请选择</option>
				<option value="1">已付款</option>
				<option value="0">未付款</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="组合查询" class="button" />
		</form>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" name="button" value="添加数据"
				class="input-button" onclick="location.href='modify'" /></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="/supermarket/modify">
		<input type="hidden" name="billId" value="${requestScope.bill.billId}"/>
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td><input type="text" name="billNum" class="text" value="${requestScope.bill.billNo}"/></td>
					</tr>
					<tr>
						<td class="field">交易金额：</td>
						<td><input type="text" name="money" class="text"  value="${requestScope.bill.billPrice}"/></td>
					</tr>
					<tr>
						<td class="field">交易数量：</td>
						<td><input type="text" name="sum" class="text"  value="${requestScope.bill.billPronum}"/></td>
					</tr>
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" name="title" class="text"  value="${requestScope.bill.billProname}"/></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><textarea name="discription">${requestScope.bill.billProdescribe}</textarea></td>
					</tr>
					<tr>
						<td class="field">所属供应商：</td>
						<td><select name="providerId">
								<c:if test="${fn:length(requestScope.providerList) gt 0 }">
									<!-- 使用循环将数据显示在页面的表格中 -->
									<c:forEach items="${requestScope.providerList}" var="provider"
										varStatus="loop">
										<option value="${pageScope.provider.providerId}" ${requestScope.bill.providerId == pageScope.provider.providerId ?"selected='selected'":""}>${pageScope.provider.providerName}</option>
									</c:forEach>
								</c:if>
						</select></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="isPay">
								<option value="1">是</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
				<c:if test="${empty requestScope.bill.billId}">
					<input type="submit" name="submit" value="确认" class="input-button" />
				</c:if>
				<c:if test="${!empty requestScope.bill.billId}">
					<input type="submit" name="submit" value="修改" class="input-button" />
				
					<a class="input-button" onclick="return confirm('确定要删除当前账单吗？')" href="<c:url value='/billdel?billId=${requestScope.bill.billId}'></c:url>">删除</a>
				</c:if>
			</div>
		</form>
		${message}
		<%=application.getAttribute("message") == null ? "" : application.getAttribute("message")%>
	</div>
</body>
</html>

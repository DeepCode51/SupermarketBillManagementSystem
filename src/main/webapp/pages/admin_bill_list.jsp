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
			商品名称：<input type="text" name="billProname" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			是否付款：<select name="billPayment">
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
				class="input-button" onclick="location.href='/supermarket/modify'" /></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tr>
					<td>账单编号</td>
					<td>商品名称</td>
					<td>商品数量</td>
					<td>交易金额</td>
					<td>是否付款</td>
					<td>供应商名称</td>
					<td>商品描述</td>
					<td>账单时间</td>
				</tr>
				<tr>
					<c:if test="${!empty requestScope.billList}">
						<!-- 判断request中userlist的集合长度是否大于0 -->
						<c:if test="${fn:length(requestScope.billList) gt 0 }">
							<!-- 使用循环将数据显示在页面的表格中 -->
							<c:forEach items="${requestScope.billList}" var="bill"
								varStatus="loop">
								<tr>
									<td>${pageScope.bill.billNo}</td>
									<td><a href="/supermarket/modify?billId=${pageScope.bill.billId}">${pageScope.bill.billProname}</a></td>
									<td>${pageScope.bill.billPronum}</td>
									<td>${pageScope.bill.billPrice}</td>
									<td>${pageScope.bill.billPayment?"已付款":"未付款"}</td>
									<td>${pageScope.bill.providerName}</td>
									<td>${pageScope.bill.billProdescribe}</td>
									<td>${pageScope.bill.billDate}</td>
								</tr>
							</c:forEach>
						</c:if>
					</c:if>
				</tr>
			</table>
		</div>
		${message}
		<%=application.getAttribute("message") == null ? "" : application.getAttribute("message")%>
	</div>
</body>
</html>

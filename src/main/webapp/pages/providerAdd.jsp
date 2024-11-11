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
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post"
			action="/supermarket/provideradd" onsubmit="return checkit();">
			<div class="content">
				<font color="red"></font> 
				<input type="hidden" name="providerId" value="${requestScope.provider.providerId}"/>
				<input name="flag" value="doAdd" type="hidden" />
					<table class="box">
						<tbody>
							<tr>
								<td class="field">供应商编号：</td>
								<td><input name="proId" id="textfield" class="text"
									type="text" value="${requestScope.provider.providerNo}" /> <font color="red">*</font></td>
							</tr>
							<tr>
								<td class="field">供应商名称：</td>
								<td><input name="proName" id="textfield2" value="${requestScope.provider.providerName}"
									class="text" type="text" /> <font color="red">*</font></td>
							</tr>
							<tr>
								<td class="field">供应商描述：</td>
								<td><textarea name="proDesc" id="textarea" cols="45"
										rows="5">${requestScope.provider.providerDescribe}</textarea></td>
							</tr>
							<tr>
								<td class="field">供应商联系：</td>

								<td><input name="contact" id="textfield2" value="${requestScope.provider.providerContacts}"
									class="text" type="text" /></td>
							</tr>
							<tr>
								<td class="field">供应商电话：</td>
								<td><input name="phone" id="textfield2" value="${requestScope.provider.providerTel}"
									class="text" type="text" /></td>
							</tr>
							<tr>
								<td class="field">供应商地址：</td>
								<td><input name="address" id="textfield2" value="${requestScope.provider.providerLoc}"
									class="text" type="text" /></td>
							</tr>
						</tbody>
					</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
				<c:if test="${empty requestScope.provider.providerId}">
					<input id="button" value="提交" class="input-button" type="submit" /> 
				</c:if>
				<c:if test="${!empty requestScope.provider.providerId}">
					<input id="button" value="修改" class="input-button" type="submit" /> 
					<a class="input-button" onclick="return confirm('确定要删除当前供应商吗？')" href="<c:url value='/providerdel?providerId=${requestScope.provider.providerId}'></c:url>">删除</a>
				</c:if>
			</div>
		</form>
		${message}
		<%=application.getAttribute("message") == null ? "" : application.getAttribute("message")%>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Account</title>
<link href="${pageContext.request.contextPath}/resources/css/table.css"
    rel="stylesheet">
</head>
<body>
<h2>Update account</h2>
<form:form action="addaccount" method="post" modelAttribute="addAccountBean">
	<table>
			<tr>
				<td><form:hidden path = "accountId" value="${addAccountBean.accountId}" /></td>
			</tr>
			<tr>
				<td>Enter Account Name:</td>
				<td><form:input path="name" /><form:errors path="name" class="error"></form:errors> </td>
			</tr>


			<tr>
				<td>Enter address:</td>
				<td><form:input path="address"  /><form:errors path="address" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Enter phone:</td>
				<td><form:input path="phone" /><form:errors path="phone" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Enter email:</td>
				<td><form:input path="email" /><form:errors path="email" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td>Enter Account Type:</td>
				<td><form:select path="accountType" items="${accounttype}"></form:select><form:errors path="accountType" class="error"></form:errors></td>
			</tr>
			<tr>
				<td>Enter balance</td>
				<td><form:input path="balance"/></td>
		   </tr>
			<tr>
				<td>Enter AadharCard Number:</td>
				<td><form:input path="aadharCard" /><form:errors path="aadharCard" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td>Enter Pan Card Number:</td>
				<td><form:input path="panNumber" /><form:errors path="panNumber" class="error"></form:errors></td>
			</tr>
			

			<tr>
				<td><input type="submit" value="Update Account" /></td>
			</tr>
		</table>
</form:form>
</body>
</html>
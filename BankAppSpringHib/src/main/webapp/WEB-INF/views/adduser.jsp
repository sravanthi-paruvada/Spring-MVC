<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
<link href="${pageContext.request.contextPath}/css/form.css"
    rel="stylesheet">
</head>
<body>
<form:form action="adduser" method="post" modelAttribute="userbean">
	
	<table>
			<tr>
				<td><form:hidden path = "uid" value = "0" /></td>
			</tr>
			<tr>
				<td>Enter username:</td>
				<td><form:input path="username" /><form:errors path="username" class="error"></form:errors> </td>
			</tr>

			<tr>
				<td>Enter password:</td>
				<td><form:input type="password" path="password" /><form:errors path="password" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td>Enter userType:</td>
				<td><form:select path="userType" items="${usertype}"></form:select><form:errors path="userType" class="error"></form:errors></td>
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
				<td><input type="submit" value="Add User" /></td>
			</tr>
		</table>
	
</form:form>
</body>
</html>
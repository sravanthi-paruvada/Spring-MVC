<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>HCL Bank Application</title>
<link href="${pageContext.request.contextPath}/css/form.css"
    rel="stylesheet">

</head>
<body>
 <form:form action="deposite" method="post" modelAttribute="depositebean">
		<table>
			<tr>
				<td>Enter To Account</td>
				<td><form:input path="toAccountId" /><form:errors path="toAccountId" class="error"/></td>
			</tr>
			<tr>
				<td>Enter Amount</td>
				<td><form:input path="amount" /><form:errors path="amount" class="error"/></td>
			</tr>
			<tr>
			<td><input type="submit"></td>
		</tr>
		</table>
	</form:form>

</body>
</html>
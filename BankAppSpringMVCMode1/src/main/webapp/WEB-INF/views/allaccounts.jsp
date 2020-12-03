<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Accounts</title>
<link href="${pageContext.request.contextPath}/resources/css/table.css"
    rel="stylesheet">
</head>
<body>
<h2>All the accounts</h2>
	<table>
		<thead>
			<tr>
			 <th>accountId</th>
            <th>name</th>
            <th>address</th>
            <th>phone</th>
            <th>email</th>
            <th>accountType</th>
            <th>balance</th>
            <th>updateaccount</th>
            <th>deleteaccount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.accountId}</td>
					<td>${account.name}</td>
                    <td>${account.address}</td> 
					<td>${account.phone}</td>
					<td>${account.email}</td>
					<td>${account.accountType}</td>
					<td>${account.balance}</td>
					<td><a href="updateaccount?id=${account.accountId}">Update Account</a></td>
					<td><a href="deleteaccount?id=${account.accountId}">Delete	Account</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="addaccount">Add Account</a>
</body>
</html>
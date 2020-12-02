<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<br>
 <h2>Hi, ${sessionScope.user.userType}</h2>  <br>
<c:if test="${sessionScope.user.userType == 'Admin'}">
	<a href="addaccount"> Create New Bank Account </a> <br>
	<a href="adduser"> Create New Adminstrative User </a> <br>
	<a href="logout"> Logout </a>
	
</c:if>

<c:if test="${sessionScope.user.userType == 'Manager'}">
	<a href="transfer"> Transfer Money</a> <br>
	<a href="withdraw"> Withdraw Money</a> <br>
	<a href="deposite"> Deposit Money </a> <br>
	<a href="logout"> Logout </a>
</c:if>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
<link href="${pageContext.request.contextPath}/resources/css/table.css"
    rel="stylesheet">
</head>
<body>
<h2>All the transactions</h2>
	<table>
		<thead>
			<tr>
			 <th>txId</th>
            <th>txInfo</th>
            <th>timestamp</th>
            <th>amount</th>
            <th>txType</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${logs}" var="log">
				<tr>
					<td>${log.txId}</td>
					<td>${log.txInfo}</td>
                    <td>${log.timestamp}</td> 
					<td>${log.amount}</td>
					<td>${log.txType}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="logout"> Logout </a>
</body>
</html>
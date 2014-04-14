<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Lista de empresas</title>
</head>
<body>
	<h2>Lista de empresas</h2>
	<table>
		<tr>
			<th>Empresa</th>
		</tr>
		<c:forEach items="${empresas}" var="empresa">
		<tr>
			<td>${empresa}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
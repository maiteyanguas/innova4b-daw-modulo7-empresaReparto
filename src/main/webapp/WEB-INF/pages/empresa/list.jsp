<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<title>Lista de empresas</title>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />		
			<div id="content">
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
			</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
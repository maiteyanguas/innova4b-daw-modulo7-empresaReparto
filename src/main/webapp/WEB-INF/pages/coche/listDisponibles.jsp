<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<title><spring:message code="lista.cochesDisponibles" text="Lista de coches Disponibles"/></title>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />		
			<div id="content">
			<c:if test="${error!=null}">
				<div class="errorblock">${error}</div>
			</c:if>
			<jsp:include page="filtro.jsp" />
			<p><spring:message code="lista.cochesDisponibles" text="Lista de coches Disponibles"/></p>
			<table>
				<tr>
					<th><spring:message code="coche.modelo" text="Modelo"/></th>
					<th><spring:message code="coche.marca" text="Marca"/></th>
					<th><spring:message code="coche.matricula" text="Matrícula"/></th>
					<th><spring:message code="coche.kms" text="Kms"/></th>
					<th><spring:message code="coche.combustible" text="Combustible"/></th>
					<th/>
					<th/>
				</tr>
				<c:forEach items="${coches}" var="coche">
					<tr>
						<td>${coche.modelo}</td>
						<td>${coche.marca}</td>
						<td>${coche.matricula}</td>
						<td>${coche.kms}</td>
						<td>${coche.combustible}</td>
						<td><a href="/empresaReparto/reserva/new/${coche.id}"><img alt="seleccionar" src="/images/select.png" width="32" height="32"></a></td>
					</tr>
				</c:forEach>
			</table>
			</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
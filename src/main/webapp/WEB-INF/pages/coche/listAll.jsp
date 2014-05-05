<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<title><spring:message code="lista.coches" text="Lista de coches"/></title>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />		
			<div id="content">
			<p><a class="link" href="/empresaReparto/coche/new"><spring:message code="nuevo.coche" text="Nuevo coche"/></a></p>
			<c:if test="${error!=null}">
				<div class="errorblock">${error}</div>
			</c:if>
			<table>
				<tr>
					<th><spring:message code="coche.empresa" text="Empresa"/></th>
					<th><spring:message code="coche.matricula" text="Matrícula"/></th>
					<th><spring:message code="coche.marca" text="Marca"/></th>
					<th><spring:message code="coche.modelo" text="Modelo"/></th>
					<th><spring:message code="coche.incidencias" text="Incidencias Sin Resolver"/></th>
					<th/>
					<th/>
				</tr>
				<c:forEach items="${coches}" var="coche">
					<tr>
						<td>${coche.empresa.nombre}</td>
						<td>${coche.matricula}</td>
						<td>${coche.marca}</td>
						<td>${coche.modelo}</td>
						<c:choose>
							<c:when test="${coche.incidenciasPendientes==true}">
								<td align="center"><spring:message code="si" text="Sí"/></td>
							</c:when>
							<c:otherwise>
								<td align="center"><spring:message code="no" text="No"/></td>
							</c:otherwise>
						</c:choose>						
						<td><a href="/empresaReparto/incidencia/list/${coche.id}"><spring:message code="ver.incidencias" text="Ver incidencias" /></a></td>
					</tr>
				</c:forEach>
			</table>
			</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
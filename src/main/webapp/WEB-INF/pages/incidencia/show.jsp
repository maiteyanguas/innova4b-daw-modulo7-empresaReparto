<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="innova4b.empresaReparto.incidencia.domain.Incidencia" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="ver.incidencia"
		text="Ver incidencia" /></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p>
				<spring:message code="ver.incidencia" text="Ver incidencia" />
			</p>

			<table>
				<tr>
					<td><spring:message code="incidencia.id" text="Id. incidencia" />:</td>
					<td>${incidencia.id}</td>
				</tr>
				<tr>
					<td><spring:message code="incidencia.fechaCreacion" text="Fecha de creación" />:</td>
			  		<td>${incidencia.fechaCreacionAsString}</td>					
				</tr>
				<tr>
					<td><spring:message code="incidencia.usuarioCreacion" text="Usuario de creación" />:</td>
					<td>${incidencia.empleadoCreacion.nombre}</td>
				</tr>
				<tr>
					<td><spring:message code="incidencia.descripcion" text="Descripción" />:</td>
					<td>${incidencia.descripcion}</td>
				</tr>
				<c:if test="${incidencia.resuelta != false}">
				<tr>
					<td><spring:message code="incidencia.fechaResolucion" text="Fecha de resolución" />:</td>
					<td>${incidencia.fechaResolucionAsString}</td>
				</tr>
				<tr>
					<td><spring:message code="incidencia.resolucion" text="Descripción de resolución" />:</td>
					<td>${incidencia.resolucion}</td>
				</tr>
				<tr>
					<td><spring:message code="incidencia.usuarioResolucion" text="Usuario de resolución" />:</td>
					<td>${incidencia.empleadoResolucion.nombre}</td>
				</tr>
				</c:if>
				
			</table>
			<a class="button" href="/empresaReparto/incidencia/list/${incidencia.coche.id}"><spring:message code="volver" text="Volver"/></a>	
			
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
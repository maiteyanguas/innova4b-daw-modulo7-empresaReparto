<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="editar.incidencia" text="Editar incidencia"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p><spring:message code="editar.incidencia" text="Editar incidencia"/></p>			
			<form:form method="post" modelAttribute="incidencia" action="/empresaReparto/incidencia/update">
			<form:hidden path="id"/>
			
			<table>
				<tr>
					<td><spring:message code="incidencia.id" text="Id. incidencia" />:</td>
					<td>${incidencia.id}</td>
				</tr>
				<tr>
					<form:hidden path="fechaCreacion"/>
					<td><spring:message code="incidencia.fechaCreacion" text="Fecha de creación" />:</td>
			  		<td>${incidencia.fechaCreacionAsString}</td>					
				</tr>
				<tr>
					
					<td><spring:message code="incidencia.empleadoCreacion" text="Usuario de creación" />:</td>
					<td>${incidencia.empleadoCreacion.nombre}</td>
				</tr>
				<tr>
					<form:hidden path="descripcion"/>	
					<td><spring:message code="incidencia.descripcion" text="Descripción" />:</td>
					<td>${incidencia.descripcion}</td>
				</tr>
										
				<tr>
					<td><form:label path="resolucion"><spring:message code="incidencia.resolucion" text="Descripción de la resolución"/>:</form:label></td>
					<td><form:input path="resolucion"></form:input>
						<form:errors path="resolucion" cssClass="error"/>
					</td>
				</tr>
			
				<tr>
					<td><form:label path="fechaResolucion"><spring:message code="incidencia.fechaResolucion" text="Fecha de resolución"/>:</form:label></td>
					<td><form:input path="fechaResolucion"></form:input>
						<form:errors path="fechaResolucion" cssClass="error"/>
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
				<a class="button" href="/empresaReparto/incidencia/list/${incidencia.coche.id}"><spring:message code="volver" text="Volver"/></a>	
			</p>
			</form:form>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
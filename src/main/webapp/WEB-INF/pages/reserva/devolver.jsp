<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="nueva.empresa" text="Nueva empresa"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css" href="/css/jquery/jquery-ui-1.10.4.custom.min.css">
<script src="/js/jquery/jquery-1.10.2.js"></script>
<script src="/js/jquery/jquery-ui-1.10.4.custom.min.js"></script>
<script src="/js/jquery/jquery.i18n.properties-min-1.0.9.js"></script>
<script src="/js/jquery/jquery.cookie.js"></script>
<script src="/js/i18n.js"></script>
<script src="/js/reserva/devolver.js"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p><spring:message code="devolver.coche" text="Devolver coche"/></p>
			
			<form:form id="devolverForm" method="POST" modelAttribute="reserva" action="/empresaReparto/reserva/finalizar">
			<table>
				<tr>
					<td><form:label path="fechaDevolucion"><spring:message code="reserva.fechaDevolucion" text="Fecha Devolucion"/>:</form:label></td>
					<td><form:input path="fechaDevolucion"></form:input>
						<form:errors path="fechaDevolucion" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="kmIniciales"><spring:message code="reserva.kmIniciales" text="Kil\u00F3metros Iniciales"/>:</form:label></td>
					<td><form:input path="kmIniciales"></form:input>
						<form:errors path="kmIniciales" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="kmFinales"><spring:message code="reserva.kmFinales" text="Kil\u00F3metros Finales"/>:</form:label></td>
					<td><form:input path="kmFinales"></form:input>
						<form:errors path="kmFinales" cssClass="error"/>
					</td>
				</tr>
				
				<tr>
					<td><label><spring:message code="reserva.incidencias" text="Incidencias"/>:</label></td>
					<td>
						<input type="hidden" id="incidenciasJSON" name="incidenciasJSON"/>
						<div id="addedIncidencias"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<spring:message code="incidencia.nueva" text="Nueva Incidencia" var="nuevaDireccion"/>
						<input id="newIncidencia" type="button" value="${nuevaIncidencia}">
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
				<a class="button" href="/empresaReparto/coche/listDisponibles"><spring:message code="volver" text="Volver"/></a>	
			</p>
			</form:form>	
			<div id="incidenciaDialog">
			<!--<form:form id="incidenciaForm" method="POST" modelAttribute="incidencia"  action="/empresaReparto/incidencia/add">-->
			<table>
				<tr>
					<td><form:label path="fecha"><spring:message code="incidencia.fecha" text="Fecha de la Incidencia"/>:</form:label></td>
					<td><form:input path="fecha"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="usuario"><spring:message code="incidencia.usuario" text="Usuario"/>:</form:label></td>
					<td><form:input path="usuario"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="descripcion"><spring:message code="incidencia.descripcion" text="Descripcion"/>:</form:label></td>
					<td><form:input path="piso"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="resuelta"><spring:message code="incidencia.resuelta" text="¿Está resuelta?"/>:</form:label></td>
					<td><form:input path="resuelta"></form:input></td>
				</tr>
			</table>
			</form:form>		
			</div>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
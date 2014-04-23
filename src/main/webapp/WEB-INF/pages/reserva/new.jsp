<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="nueva.reserva" text="Nueva reserva"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p><spring:message code="nueva.reserva" text="Nueva reserva"/></p>
			
			<form:form method="post" modelAttribute="reserva" action="/empresaReparto/reserva/add">
			<table>
				<tr>
					<td><form:label path="fechaPrevistaInicio"><spring:message code="reserva.fechaPrevistaInicio" text="Fecha Prevista Inicio"/>:</form:label></td>
					<td><form:input path="fechaPrevistaInicio"></form:input>
						<form:errors path="fechaPrevistaInicio" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="fechaPrevistaDevolucion"><spring:message code="reserva.fechaPrevistaDevolucion" text="Fecha Prevista Devolución"/>:</form:label></td>
					<td><form:input path="fechaPrevistaDevolucion"></form:input>
						<form:errors path="fechaPrevistaDevolucion" cssClass="error"/>
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
				<a class="button" href="/empresaReparto/coche/list"><spring:message code="volver" text="Volver"/></a>	
			</p>
			</form:form>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
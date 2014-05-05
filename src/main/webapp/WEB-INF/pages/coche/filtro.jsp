
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css" href="/css/jquery/jquery-ui-1.10.4.custom.min.css">
<script src="/js/jquery/jquery-1.10.2.js"></script>
<script src="/js/jquery/jquery-ui-1.10.4.custom.min.js"></script>
<script src="/js/jquery/jquery.i18n.properties-min-1.0.9.js"></script>
<script src="/js/jquery/jquery.cookie.js"></script>
<script src="/js/i18n.js"></script>
<script src="/js/calendario.js"></script>
<script src="/js/coche/filtro.js"></script>
	
<p><spring:message code="filtro.coches" /></p>
<form:form id="cocheFiltro" method="POST" modelAttribute="filtro" action="/empresaReparto/coche/listDisponiblesFilter">
	<table>
			<tr>
				<td><form:label path="fechaInicioPrevista"><spring:message code="filtro.fechaInicioPrevista" />:</form:label></td>
				<td><form:input id="fechaInicio" path="fechaInicioPrevista" ></form:input>
					<form:errors path="fechaInicioPrevista" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="fechaDevolucionPrevista"><spring:message code="filtro.fechaDevolucionPrevista" />:</form:label></td>
				<td><form:input id="fechaDevolucion" path="fechaDevolucionPrevista" ></form:input>
					<form:errors path="fechaDevolucionPrevista" cssClass="error"/>
				</td>
			</tr>
		</table>
		<p>
			<spring:message code="filtrar" text="Filtrar" var="filtrar"/>
			<input type="submit" value="${filtrar}"/>
		</p>
</form:form>

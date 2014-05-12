<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css" href="/css/jquery/jquery-ui-1.10.4.custom.min.css">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<form:form id="empleadoFiltro" method="GET" modelAttribute="empleadoFiltro" action="/empresaReparto/empleado/list">
	<table>
				<tr>
					<td><form:label path="apellido1"><spring:message code="empleado.apellido1" text="Primer apellido"/>:</form:label></td>
					<td><form:input path="apellido1" value="${apellido1}"></form:input>
						<form:errors path="apellido1" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="empresa"><spring:message code="empleado.empresa" text="Empresa"/>:</form:label></td>
					<td><select name="idEmpresa">
					<c:forEach var="emp" items="${empresas}">
					<c:choose>
						<c:when test="${idEmpresa==emp.id}">
							<option value="${emp.id}" selected>${emp.nombre}</option>
						</c:when>
						<c:otherwise>
							<option value="${emp.id}" >${emp.nombre}</option>
						</c:otherwise>
					</c:choose>
					</c:forEach>
					    </select>
						<form:errors path="empresa" cssClass="error"/>
					</td>
				</tr>
		</table>
		<p>
			<spring:message code="filtrar" text="Filtrar" var="filtrar"/>
			<input type="submit" value="${filtrar}"/>
		</p>
</form:form>

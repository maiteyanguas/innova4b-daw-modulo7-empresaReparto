<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="editar.empleado" otext="Editar empleado"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p><spring:message code="editar.empleado" text="Editar empleado"/></p>			
			<form:form method="post" modelAttribute="empleado" action="/empresaReparto/empleado/update">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td><form:label path="nombre"><spring:message code="empleado.nombre" text="Nombre"/>:</form:label></td>
					<td><form:input path="nombre"></form:input>
						<form:errors path="nombre" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="apellido1"><spring:message code="empleado.apellido1" text="Primer apellido"/>:</form:label></td>
					<td><form:input path="apellido1"></form:input>
						<form:errors path="apellido1" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="apellido2"><spring:message code="empleado.apellido2" text="Segundo apellido"/>:</form:label></td>
					<td><form:input path="apellido2"></form:input>
						<form:errors path="apellido2" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="empresa"><spring:message code="empleado.empresa" text="Empresa"/>:</form:label></td>
					<td><form:input path="empresa"></form:input>
						<form:errors path="empresa" cssClass="error"/>
					</td>
				</tr>
					<tr>
					<td><form:label path="fechaNacimiento"><spring:message code="empleado.fechaNacimiento" text="Fecha Nacimiento"/>:</form:label></td>
					<td><form:input path="fechaNacimiento"></form:input>
						<form:errors path="fechaNacimiento" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="telefono"><spring:message code="empleado.telefono" text="Teléfono"/>:</form:label></td>
					<td><form:input path="telefono"></form:input>
						<form:errors path="telefono" cssClass="error"/>
					</td>
				</tr>	
				<tr>
					<td><form:label path="email"><spring:message code="empleado.email" text="Correo electrónico"/>:</form:label></td>
					<td><form:input path="email"></form:input>
						<form:errors path="email" cssClass="error"/>
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
				<a class="button" href="/empresaReparto/empleado/list"><spring:message code="volver" text="Volver"/></a>	
			</p>
			</form:form>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
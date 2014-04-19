<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="editar.empresa" text="Editar empresa"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p><spring:message code="editar.empresa" text="Editar empresa"/></p>			
			<form:form method="post" modelAttribute="empresa" action="/empresaReparto/empresa/update">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td><form:label path="nombre"><spring:message code="empresa.nombre" text="Nombre"/>:</form:label></td>
					<td><form:input path="nombre"></form:input>
						<form:errors path="nombre" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="cif"><spring:message code="empresa.cif" text="CIF"/>:</form:label></td>
					<td><form:input path="cif"></form:input>
						<form:errors path="cif" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="telefono"><spring:message code="empresa.telefono" text="Teléfono"/>:</form:label></td>
					<td><form:input path="telefono"></form:input>
						<form:errors path="telefono" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="email"><spring:message code="empresa.email" text="Correo electrónico"/>:</form:label></td>
					<td><form:input path="email"></form:input>
						<form:errors path="email" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="fechaInicio"><spring:message code="empresa.fecha.inicio" text="Fecha de inicio"/>:</form:label></td>
					<td><form:input path="fechaInicio"></form:input>
						<form:errors path="fechaInicio" cssClass="error"/>
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
				<a class="button" href="/empresaReparto/empresa/list"><spring:message code="volver" text="Volver"/></a>	
			</p>
			</form:form>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
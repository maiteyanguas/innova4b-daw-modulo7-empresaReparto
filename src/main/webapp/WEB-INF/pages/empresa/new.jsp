<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="nueva.empresa" text="Nueva empresa"/></title>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<h2><spring:message code="nueva.empresa" text="Nueva empresa"/></h2>
			<form:form method="post" modelAttribute="empresa" action="/empresaReparto/empresa/add">
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
				<tr>
					<spring:message code="guardar" text="Guardar" var="guardar"/>
					<td colspan="2">
						<input type="submit" value="${guardar}"/>
						<a class="button" href="/empresaReparto/empresa/list"><spring:message code="volver" text="Volver"/></a>	
					</td>
				</tr>	
			</table>
			</form:form>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
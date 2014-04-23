<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="nuevo.empleado" text="Nuevo empleado"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p><spring:message code="nuevo.empleado" text="Nuevo empleado"/></p>
			<form:form method="post" modelAttribute="empleado" action="/empresaReparto/empleado/add">
			<table>
				<tr> 
					<td><spring:message code="nuevo.datosUsuario" text="Datos Usuario"/></td>
				</tr>
				<tr>
					<td><form:label path="usuario"><spring:message code="empleado.usuario" text="Usuario"/>:</form:label></td>
					<td><form:input path="usuario"></form:input>
						<form:errors path="usuario" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="password"><spring:message code="empleado.password" text="Contraseña"/>:</form:label></td>
					<td><form:input path="password"></form:input>
						<form:errors path="password" cssClass="error"/>
					</td>
				</tr>
			
				<tr> 
					<td><spring:message code="nuevo.datosPersonales" text="Datos personales"/></td>
				</tr>			
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
					<td><!--<form:input path="empresa"></form:input>
						<form:errors path="empresa" cssClass="error"/> -->
					
					<form:select path="empresa">
						<c:forEach items="${empresa}" var="empresa">
							<form:options items="${empresa.nombre}" />
						</c:forEach> 
					</form:select>
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="editar.empleado" text="Editar empleado"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p id="titulo_pagina"><spring:message code="editar.empleado" text="Editar empleado"/></p>			
			<form:form method="post" modelAttribute="empleado" action="/empresaReparto/empleado/update">
			<form:hidden path="id"/>
			<table>
				<tr> 
					<td id="titulo_seccion" colspan= "2"><spring:message code="nuevo.datosUsuario" text="Datos Usuario"/></td>
				</tr>
				<tr>
					<td><form:label path="usuario"><spring:message code="usuario" text="Usuario"/>:</form:label></td>
					<td><form:input path="usuario"></form:input>
						<form:errors path="usuario" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="password"><spring:message code="password" text="Contraseña"/>:</form:label></td>
					<td><form:input path="password"></form:input>
					<!-- <td><form:password path="password"></form:password> -->
						<form:errors path="password" cssClass="error"/>
					</td>
				</tr>
				<tr> 
					<td id="titulo_seccion" colspan= "2"><spring:message code="nuevo.datosPersonales" text="Datos Personales"/></td>
				</tr>
				<tr>
					<td><form:label path="dni"><spring:message code="dni" text="DNI"/>:</form:label></td>
					<td><form:input path="dni"></form:input>
						<form:errors path="dni" cssClass="error"/>
					</td>
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
				<tr> 
					<td id="titulo_seccion" colspan= "2"><spring:message code="nuevo.datosEmpresariales" text="Datos Empresariales"/></td>
				</tr>
				<tr>
					<td><form:label path="empresa"><spring:message code="empleado.empresa" text="Empresa"/>:</form:label></td>
					<td><select name="idEmpresa">
					<c:forEach var="emp" items="${empresas}">
							<option value="${emp.id}" >${emp.nombre}</option>
					</c:forEach>
					    </select>
						<form:errors path="empresa" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="jefe"><spring:message code="empleado.jefe" text="Jefe"/>:</form:label></td>
					<td><select name="jefe">
					<c:forEach var="jefe" items="${jefes}">
							<option value="${jefe.id}" >${jefe.nombre}</option>
					</c:forEach>
					    </select>
						<form:errors path="jefe" cssClass="error"/>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="datos"
		text="Mis Datos" /></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p>
				<spring:message code="datos" text="Mis Datos" />
				<a href="/empresaReparto/empleado/editUser/${empleado.id}"><img alt="editar" src="/images/edit.png" width="20" height="20"></a>
			</p>

			<table>
				<tr> 
					<td id="titulo_seccion" colspan= "2"><spring:message code="nuevo.datosPersonales" text="Datos Personales"/></td>
				</tr>
				<tr>
					<td><spring:message code="dni" text="DNI" />:</td>
					<td>${empleado.dni}</td>
				</tr>
				<tr>
					<td><spring:message code="empleado.nombre" text="Nombre" />:</td>
					<td>${empleado.nombre} &nbsp; ${empleado.apellido1} &nbsp; ${empleado.apellido2}</td>
				</tr>
				<tr>
					<td><spring:message code="empleado.fechaNacimiento" text="Fecha Nacimiento" />:</td>
					<td>${empleado.fechaNacimiento}</td>
				</tr>
				<tr>
					<td><spring:message code="empleado.telefono" text="Teléfono" />:</td>
					<td>${empleado.telefono}</td>
				</tr>
				<tr>
					<td><spring:message code="empleado.email" text="Dirección Email" />:</td>
					<td>${empleado.email}</td>
				</tr>
				<tr> 
					<td id="titulo_seccion" colspan= "2"><spring:message code="nuevo.datosEmpresariales" text="Datos Empresariales"/></td>
				</tr>
				<tr>
					<td><spring:message code="empleado.empresa" text="Empresa" />:</td>
					<td>${empleado.empresa.nombre}</td>
				</tr>
				
				<tr>
					<td><spring:message code="empleado.esJefe" text="Es jefe" />:</td>
				<c:choose>
    				<c:when test="${empty empleado.jefe}">
    					<td>Sí</td>
    				</c:when>
    				<c:otherwise>
    					<td>No</td>
    				</c:otherwise>
				</c:choose>
				</tr>
				
				<tr>
					<td><spring:message code="empleado.jefe" text="Jefe" />:</td>
				<c:choose>
    				<c:when test="${empty empleado.jefe}">
    					<td>Ninguno</td>
    				</c:when>
    				<c:otherwise>
    					<td>${empleado.jefe.nombre}</td>
    				</c:otherwise>
				</c:choose>
				</tr>
				
			</table>
			
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
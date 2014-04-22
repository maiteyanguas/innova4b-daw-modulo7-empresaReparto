<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<head>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<title><spring:message code="lista.empleados" text="Lista de empleados"/></title>

</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />		
			<div id="content">
			<p><a class="link" href="/empresaReparto/empleado/new"><spring:message code="nueva.empleado" text="Nueva"/></a></p>
			<c:if test="${error!=null}">
				<div class="errorblock">${error}</div>
			</c:if> 
			<table>
				<tr>
					<th><spring:message code="empleado.nombre" text="Nombre"/></th>
					<th><spring:message code="empleado.apellido1" text="Primer apellido"/></th>
					<th><spring:message code="empleado.apellido2" text="Segundo apellido"/></th>
					<th><spring:message code="empleado.empresa" text="Empresa"/></th>
					<th><spring:message code="empleado.fechaNacimiento" text="Fecha Nacimiento"/></th>
					<th><spring:message code="empleado.email" text="Email"/></th>
					<th><spring:message code="empleado.telefono" text="Teléfono"/></th>
					<th/>
					<th/>
				</tr>
				<c:forEach items="${empleados}" var="empleado">
					<tr>
						<td>${empleado.nombre}</td>
						<td>${empleado.apellido1}</td>
						<td>${empleado.apellido2}</td>
						<td>${empleado.empresa}</td>
						<td>${empleado.fechaNacimiento}</td>
						<td>${empleado.email}</td>
						<td>${empleado.telefono}</td>
		  				
						<td><a href="/empresaReparto/empleado/edit/${empleado.id}"><img alt="editar" src="/images/edit.png" width="20" height="20"></a></td>
						<td><a href="/empresaReparto/empleado/delete/${empleado.id}"><img alt="borrar" src="/images/delete.jpeg" width="20" height="20"></a></td>
					
					</tr>
				</c:forEach> 
			</table>
			</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</head>






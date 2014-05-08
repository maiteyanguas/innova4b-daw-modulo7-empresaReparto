<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<head>
<title><spring:message code="lista.empleados" text="Lista de empleados"/></title>

<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css" href="/css/paginateStyle.css">

<script src="/js/jquery/jquery-1.10.2.js"></script>
<script src="/js/jquery/jquery-ui-1.10.4.custom.min.js"></script>
<script src="/js/jquery/jquery.i18n.properties-min-1.0.9.js"></script>
<script src="/js/jquery/jquery.cookie.js"></script>
<script src="/js/i18n.js"></script>
<script src="/js/jquery.paginate.js"></script>

<script src="/js/empleado/filtro.js"></script>

<script type="text/javascript">			
	$(document).ready(function() {
		$(function() {
			$("#paginationdemo").paginate({
				count 		: <c:out value="${numberOfPages}"/>,
				start 		: <c:out value="${responsePage}"/>,
				display     : <c:out value="${numElementosMostrar}"/>,
				border					: true,
				border_color			: '#fff',
				text_color  			: '#fff',
				background_color    	: 'black',	
				border_hover_color		: '#ccc',
				text_hover_color  		: '#000',
				background_hover_color	: '#fff', 
				images					: true,
				mouse					: 'press'
			});
			$('ul.jPag-pages li a').click( function(){
				
				var page =$(this).text();
				window.location.replace('/empresaReparto/empleado/list/'+page);
			});	
			$('a.jPag-first').click( function(){
				
				var page =$(this).text();
				window.location.replace('/empresaReparto/empleado/list/1');
			});	
			$('a.jPag-last').click( function(){
				
				var page =$(this).text();
				window.location.replace('/empresaReparto/empleado/list/'+<c:out value="${numberOfPages}"/>);
			});	
		});		
		
	});
</script>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />		
			<div id="content">
			<p><a class="link" href="/empresaReparto/empleado/new"><spring:message code="nuevo.empleado" text="Nuevo Empleado"/></a></p>
			<c:if test="${error!=null}">
				<div class="errorblock">${error}</div>
			</c:if> 
			<jsp:include page="filtro.jsp" />
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
				 
				<c:forEach items="${empleado}" var="empleado">
					<tr> 
						<td>${empleado.nombre}</td>
						<td>${empleado.apellido1}</td>
						<td>${empleado.apellido2}</td> 
					 	<td>${empleado.empresa.nombre}</td> 
						<td>${empleado.fechaNacimientoAsString}</td>
						<td>${empleado.email}</td>
						<td>${empleado.telefono}</td> 		
						<td><a href="/empresaReparto/empleado/edit/${empleado.id}"><img alt="editar" src="/images/edit.png" width="20" height="20"></a></td>
						<td><a href="/empresaReparto/empleado/delete/${empleado.id}"><img alt="borrar" src="/images/delete.jpeg" width="20" height="20"></a></td>
					
					</tr>
				</c:forEach> 
			</table>
			<c:if test="${numberOfPages>0}">
				<div id="paginationdemo"  class="demo"></div>
			</c:if>
			</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</head>






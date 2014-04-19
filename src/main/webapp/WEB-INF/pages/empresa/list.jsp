<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<title><spring:message code="lista.empresas" text="Lista de empresas"/></title>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />		
			<div id="content">
			<p><a class="link" href="/empresaReparto/empresa/new"><spring:message code="nueva.empresa" text="Nueva"/></a></p>
			<c:if test="${error!=null}">
				<div class="errorblock">${error}</div>
			</c:if>
			<table>
				<tr>
					<th><spring:message code="empresa.nombre" text="Nombre"/></th>
					<th><spring:message code="empresa.cif" text="CIF"/></th>
					<th><spring:message code="empresa.telefono" text="Teléfono"/></th>
					<th><spring:message code="empresa.direccion.principal" text="Dirección Principal"/></th>
					<th/>
					<th/>
				</tr>
				<c:forEach items="${empresas}" var="empresa">
					<tr>
						<td>${empresa.nombre}</td>
						<td>${empresa.cif}</td>
						<td>${empresa.telefono}</td>
						<td>${empresa.direccionPrincipalAsString}</td>
						<td><a href="/empresaReparto/empresa/edit/${empresa.id}"><img alt="editar" src="/images/edit.png" width="20" height="20"></a></td>
						<td><a href="/empresaReparto/empresa/delete/${empresa.id}"><img alt="borrar" src="/images/delete.jpeg" width="20" height="20"></a></td>
					</tr>
				</c:forEach>
			</table>
			</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
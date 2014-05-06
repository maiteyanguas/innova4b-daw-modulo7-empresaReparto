<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p>
				<spring:message code="lista.incidencias" text="Lista de incidencias" />
			</p>
			
			<table>
				<tr>
					<th><spring:message code="incidencia.fechaCreacion"
							text="Fecha de creacion" /></th>
					<th><spring:message code="incidencia.resuelta" text="Resuelta" /></th>
					<th><spring:message code="incidencia.descripcion"
							text="Descripcion" /></th>
				</tr>
				<c:forEach items="${incidencias}" var="incidencia">
					<tr>
						<td>${incidencia.fechaCreacion}</td>
						<td>${incidencia.resuelta}</td>
						<td>${incidencia.descripcion}</td>
						<td><a href="/empresaReparto/incidencia/show/${incidencia.id}"><img alt="mostrar" src="/images/ojo.png" width="20" height="20"></a></td>
						<c:if test="${incidencia.resuelta==false}">

						<td><a href="/empresaReparto/incidencia/solve/${incidencia.id}"><img alt="resolver" src="/images/Tick.svg" width="20" height="20"></a></td>
						</c:if>
						

					</tr>
				</c:forEach>
			</table>			
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
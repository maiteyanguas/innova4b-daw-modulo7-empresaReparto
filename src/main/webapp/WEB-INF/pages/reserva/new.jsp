<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="nueva.reserva" text="Nueva reserva" /></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css" href="/css/jquery/jquery-ui-1.10.4.custom.min.css">
<script src="/js/jquery/jquery-1.10.2.js"></script>
<script src="/js/jquery/jquery-ui-1.10.4.custom.min.js"></script>
<script src="/js/jquery/jquery.i18n.properties-min-1.0.9.js"></script>
<script src="/js/jquery/jquery.cookie.js"></script>
<script src="/js/i18n.js"></script>
<script src="/js/calendario.js"></script>
<script src="/js/reserva/new.js"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p>
				<spring:message code="nueva.reserva" />
			</p>

			<c:if test="${error!=null}">
				<div class="errorblock">${error}</div>
			</c:if>

			<form:form method="post" modelAttribute="reserva"
				action="/empresaReparto/reserva/add">
				<table>
					<tr>
						<td><form:label path="fechaInicioPrevista">
								<spring:message code="reserva.fechaInicioPrevista" />:</form:label></td>
						<td><form:input path="fechaInicioPrevista"
								id="fechaInicioPrevista"></form:input> <form:errors
								path="fechaInicioPrevista" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="fechaDevolucionPrevista">
								<spring:message code="reserva.fechaDevolucionPrevista" />:</form:label></td>
						<td><form:input path="fechaDevolucionPrevista"
								id="fechaDevolucionPrevista"></form:input> <form:errors
								path="fechaDevolucionPrevista" cssClass="error" /></td>
					</tr>
				</table>
				<p>
					<spring:message code="guardar" text="Guardar" var="guardar" />
					<input type="submit" value="${guardar}" /> <a class="button"
						href="/empresaReparto/coche/listDisponibles"><spring:message
							code="volver" text="Volver" /></a>
				</p>
			</form:form>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>

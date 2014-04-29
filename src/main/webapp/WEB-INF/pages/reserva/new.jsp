<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

	<link rel="stylesheet" type="text/css" href="/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/css/pages.css">
	<link rel="stylesheet" type="text/css" href="/css/jquery/jquery-ui-1.10.4.custom.css">
	<link rel="stylesheet" type="text/css" href="/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/css/pages.css">
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><spring:message code="nueva.reserva" text="Nueva reserva" /></title>

	<script src="/lib/jquery/jquery-1.10.2.js"></script>
	<script src="/lib/jquery/jquery-ui-1.10.4.custom.js"></script>
	<script src="/lib/jquery/jquery-ui-1.10.4.custom.min.js"></script>
	
	<script type="text/javascript">
		$(function() {
			$("#fechaInicioPrevista").datepicker(
					{
						dateFormat : 'dd/mm/yy',
						minDate : 0,
						monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril',
								'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre',
								'Octubre', 'Noviembre', 'Diciembre' ],
								 onSelect: function(){
									 var dt2 = $('#fechaDevolucionPrevista');
							            var startDate = $(this).datepicker('getDate');
							            //add 30 days to selected date
							            startDate.setDate(startDate.getDate() + 30);
							            var minDate = $(this).datepicker('getDate');
							            //minDate of dt2 datepicker = dt1 selected day
							            dt2.datepicker('setDate', minDate);
							            //sets dt2 maxDate to the last day of 30 days window
							            dt2.datepicker('option', 'maxDate', startDate);
							            //first day which can be selected in dt2 is selected date in dt1
							            dt2.datepicker('option', 'minDate', minDate);
							            //same for dt1
							            $(this).datepicker('option', 'minDate', minDate);}
					});
			$("#fechaDevolucionPrevista").datepicker({
				dateFormat : 'dd/mm/yy',
				minDate : 0,
				monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril',
						'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre',
						'Octubre', 'Noviembre', 'Diciembre' ],
						 onSelect: function(){
							 var startDate = $(this).datepicker('getDate');
							//add 30 days to selected date
					        startDate.setDate(startDate.getDate() + 30);
					            var minDate = $(this).datepicker('getDate');
						 }
				
			});
		});
	</script>
	
	
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
						<td><form:input path="fechaInicioPrevista" id="fechaInicioPrevista"></form:input> <form:errors
								path="fechaInicioPrevista" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="fechaDevolucionPrevista">
								<spring:message code="reserva.fechaDevolucionPrevista" />:</form:label></td>
						<td><form:input path="fechaDevolucionPrevista" id="fechaDevolucionPrevista"></form:input>
							<form:errors path="fechaDevolucionPrevista" cssClass="error" /></td>
					</tr>
				</table>
				<p>
					<spring:message code="guardar" text="Guardar" var="guardar" />
					<input type="submit" value="${guardar}" /> <a class="button"
						href="/empresaReparto/coche/listWithOutIncidencias"><spring:message
							code="volver" text="Volver" /></a>
				</p>
			</form:form>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
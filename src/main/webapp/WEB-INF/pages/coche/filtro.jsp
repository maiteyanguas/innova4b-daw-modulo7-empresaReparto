<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	<script src="jquery.ui.datepicker-es.js"></script>
	
	<script>
	$(function() {
		$("#datepickerInicio").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					minDate : 0,
					monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril',
							'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre',
							'Octubre', 'Noviembre', 'Diciembre' ],
							 onSelect: function(){
								 var dt2 = $('#datepickerDevolucion');
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
		$("#datepickerDevolucion").datepicker({
			dateFormat : 'dd/mm/yy'
			
		});
	});
	</script>
	
	<p><spring:message code="Filtro.coches" text="Filtro Coches"/></p>
			
	<c:if test="${error!=null}">
		<div class="errorblock">${error}</div>
	</c:if>

	<form:form method="post" modelAttribute="coche" action="/empresaReparto/reserva/listWithOutIncidencias">
			<table>
				<tr>
					<td><form:label path="fechaInicio"><spring:message code="reserva.fechaInicio" text="Fecha Inicio"/>:</form:label></td>
					<td><form:input path="fechaInicio"></form:input>
						<form:errors path="fechaInicio" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="fechaDevolucion"><spring:message code="reserva.fechaDevolucion" text="Fecha Devolución"/>:</form:label></td>
					<td><form:input path="fechaDevolucion"></form:input>
						<form:errors path="fechaDevolucion" cssClass="error"/>
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
				<a class="button" href="/empresaReparto/coche/listWithOutIncidencias"><spring:message code="volver" text="Volver"/></a>	
			</p>
			</form:form>
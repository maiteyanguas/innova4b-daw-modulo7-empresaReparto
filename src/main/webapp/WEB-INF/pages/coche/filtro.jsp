
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css"
	href="/css/jquery/jquery-ui-1.10.4.custom.css">
<link rel="stylesheet" type="text/css"
	href="/css/jquery/jquery-ui-1.10.4.custom.min.css">

	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />

<script src="/js/jquery-1.10.2.js"></script>
<script src="/js/jquery-ui-1.10.4.custom.js"></script>
<script src="/js/jquery-ui-1.10.4.custom.min.js"></script>

<script type="text/javascript">
		$(function() {
			$("#fechaInicio").datepicker(
					{
						dateFormat : 'dd/mm/yy',
						minDate : 0,
						monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril',
								'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre',
								'Octubre', 'Noviembre', 'Diciembre' ],
								 onSelect: function(){
									 var dt2 = $('#fechaDevolucion');
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
			$("#fechaDevolucion").datepicker({
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
	
	<p><spring:message code="filtro.coches" /></p>
			
	<c:if test="${error!=null}">
		<div class="errorblock">${error}</div>
	</c:if>

	<form name="input" action="/empresaReparto/coche/listWithOutIncidenciasFilter" method="post">
		<table>
				<tr>
					<td><label><spring:message code="reserva.fechaInicio" />:</label></td>
					<td><input id="fechaInicio" ></input>
					</td>
				</tr>
				<tr>
					<td><label><spring:message code="reserva.fechaDevolucion" />:</label></td>
					<td><input id="fechaDevolucion"></input>
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
			</p>
	</form>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css"
	href="/css/jquery/jquery-ui-1.10.4.custom.min.css">

	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />

	<script src="/js/jquery-1.10.2.js"></script>
	<script src="/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="/js/jquery.i18n.properties-min-1.0.9.js"></script>
	<script src="/js/jquery.cookie.js"></script>

	<script type="text/javascript">
					 $.datepicker.setDefaults($.datepicker.regional['es']);
	$(document).ready(function(){	
		var cookie = $.cookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
		var lang = cookie===undefined?'es':cookie;
		
		jQuery.i18n.properties({
	        name: 'messages',
	        mode: 'both',
	        path: '/messages/',
	        language: lang
	    });
		
			$("#fechaInicio").datepicker(
					{
						closeText : jQuery.i18n.prop('calendario.cerrar'),
						prevText : jQuery.i18n.prop('calendario.<ant'),
						nextText : jQuery.i18n.prop('calendario.sig>'),
						currentText : jQuery.i18n.prop('calendario.hoy'),
						dateFormat : 'dd/mm/yy',
						minDate : 0,
						monthNames : [ jQuery.i18n.prop('calendario.enero'),
								jQuery.i18n.prop('calendario.febrero'),
								jQuery.i18n.prop('calendario.marzo'),
								jQuery.i18n.prop('calendario.abril'),
								jQuery.i18n.prop('calendario.mayo'),
								jQuery.i18n.prop('calendario.junio'),
								jQuery.i18n.prop('calendario.julio'),
								jQuery.i18n.prop('calendario.agosto'),
								jQuery.i18n.prop('calendario.septiembre'),
								jQuery.i18n.prop('calendario.octubre'),
								jQuery.i18n.prop('calendario.noviembre'),
								jQuery.i18n.prop('calendario.diciembre') ],
						monthNamesShort : [ jQuery.i18n.prop('calendario.ene'),
								jQuery.i18n.prop('calendario.feb'),
								jQuery.i18n.prop('calendario.mar'),
								jQuery.i18n.prop('calendario.abr'),
								jQuery.i18n.prop('calendario.may'),
								jQuery.i18n.prop('calendario.jun'),
								jQuery.i18n.prop('calendario.jul'),
								jQuery.i18n.prop('calendario.ago'),
								jQuery.i18n.prop('calendario.sep'),
								jQuery.i18n.prop('calendario.oct'),
								jQuery.i18n.prop('calendario.nov'),
								jQuery.i18n.prop('calendario.dic') ],
						dayNamesMin : [ jQuery.i18n.prop('calendario.do'),
								jQuery.i18n.prop('calendario.lu'),
								jQuery.i18n.prop('calendario.ma'),
								jQuery.i18n.prop('calendario.mi'),
								jQuery.i18n.prop('calendario.ju'),
								jQuery.i18n.prop('calendario.vi'),
								jQuery.i18n.prop('calendario.sa') ],
						dayNames: [jQuery.i18n.prop('calendario.domingo'),
						           jQuery.i18n.prop('calendario.lunes'),
						           jQuery.i18n.prop('calendario.martes'),
						           jQuery.i18n.prop('calendario.miercoles'),
						           jQuery.i18n.prop('calendario.jueves'),
						           jQuery.i18n.prop('calendario.viernes'),
						           jQuery.i18n.prop('calendario.sabado')],
						dayNamesShort: [jQuery.i18n.prop('calendario.dom'),
								        jQuery.i18n.prop('calendario.lun'),
								        jQuery.i18n.prop('calendario.mar'),
								        jQuery.i18n.prop('calendario.mie'),
								        jQuery.i18n.prop('calendario.jue'),
								        jQuery.i18n.prop('calendario.vie'),
								        jQuery.i18n.prop('calendario.sab')],
						firstDay : 1,
						isRTL : false,
						showMonthAfterYear : false,
						yearSuffix : '',
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
				closeText : jQuery.i18n.prop('calendario.cerrar'),
				prevText : jQuery.i18n.prop('calendario.<ant'),
				nextText : jQuery.i18n.prop('calendario.sig>'),
				currentText : jQuery.i18n.prop('calendario.hoy'),
				dateFormat : 'dd/mm/yy',
				minDate : 0,
				monthNames : [ jQuery.i18n.prop('calendario.enero'),
						jQuery.i18n.prop('calendario.febrero'),
						jQuery.i18n.prop('calendario.marzo'),
						jQuery.i18n.prop('calendario.abril'),
						jQuery.i18n.prop('calendario.mayo'),
						jQuery.i18n.prop('calendario.junio'),
						jQuery.i18n.prop('calendario.julio'),
						jQuery.i18n.prop('calendario.agosto'),
						jQuery.i18n.prop('calendario.septiembre'),
						jQuery.i18n.prop('calendario.octubre'),
						jQuery.i18n.prop('calendario.noviembre'),
						jQuery.i18n.prop('calendario.diciembre') ],
				monthNamesShort : [ jQuery.i18n.prop('calendario.ene'),
						jQuery.i18n.prop('calendario.feb'),
						jQuery.i18n.prop('calendario.mar'),
						jQuery.i18n.prop('calendario.abr'),
						jQuery.i18n.prop('calendario.may'),
						jQuery.i18n.prop('calendario.jun'),
						jQuery.i18n.prop('calendario.jul'),
						jQuery.i18n.prop('calendario.ago'),
						jQuery.i18n.prop('calendario.sep'),
						jQuery.i18n.prop('calendario.oct'),
						jQuery.i18n.prop('calendario.nov'),
						jQuery.i18n.prop('calendario.dic') ],
				dayNamesMin : [ jQuery.i18n.prop('calendario.do'),
						jQuery.i18n.prop('calendario.lu'),
						jQuery.i18n.prop('calendario.ma'),
						jQuery.i18n.prop('calendario.mi'),
						jQuery.i18n.prop('calendario.ju'),
						jQuery.i18n.prop('calendario.vi'),
						jQuery.i18n.prop('calendario.sa') ],
				dayNames: [jQuery.i18n.prop('calendario.domingo'),
				           jQuery.i18n.prop('calendario.lunes'),
				           jQuery.i18n.prop('calendario.martes'),
				           jQuery.i18n.prop('calendario.miercoles'),
				           jQuery.i18n.prop('calendario.jueves'),
				           jQuery.i18n.prop('calendario.viernes'),
				           jQuery.i18n.prop('calendario.sabado')],
				dayNamesShort: [jQuery.i18n.prop('calendario.dom'),
						        jQuery.i18n.prop('calendario.lun'),
						        jQuery.i18n.prop('calendario.mar'),
						        jQuery.i18n.prop('calendario.mie'),
						        jQuery.i18n.prop('calendario.jue'),
						        jQuery.i18n.prop('calendario.vie'),
						        jQuery.i18n.prop('calendario.sab')],
				firstDay : 1,
				isRTL : false,
				showMonthAfterYear : false,
				yearSuffix : '',
												onSelect : function() {
													var startDate = $(this)
															.datepicker(
																	'getDate');
													//add 30 days to selected date
													startDate.setDate(startDate
															.getDate() + 30);
													var minDate = $(this)
															.datepicker(
																	'getDate');
												}

											});
						});
	</script>
	
	<p><spring:message code="filtro.coches" /></p>
			
	<c:if test="${error!=null}">
		<div class="errorblock">${error}</div>
	</c:if>
<form:form id="cocheFiltro" method="POST" modelAttribute="filtro" action="/empresaReparto/coche/listWithOutIncidenciasFilter">
		<table>
				<tr>
					<td><form:label path="fechaInicioPrevista"><spring:message code="filtro.fechaInicioPrevista" />:</form:label></td>
					<td><form:input id="fechaInicio" path="fechaInicioPrevista" ></form:input>
						<form:errors path="fechaInicioPrevista" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="fechaDevolucionPrevista"><spring:message code="filtro.fechaDevolucionPrevista" />:</form:label></td>
					<td><form:input id="fechaDevolucion" path="fechaDevolucionPrevista" ></form:input>
						<form:errors path="fechaDevolucionPrevista" cssClass="error"/>
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
			</p>
	</form:form>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css"
	href="/css/jquery/jquery-ui-1.10.4.custom.css">
<link rel="stylesheet" type="text/css"
	href="/css/jquery/jquery-ui-1.10.4.custom.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="/lib/jquery/jquery-1.10.2.js"></script>
<script src="/lib/jquery/jquery-ui-1.10.4.custom.js"></script>
<script src="/lib/jquery/jquery-ui-1.10.4.custom.min.js"></script>

<script type="text/javascript">
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

</head>
<body>
	Fecha prevista de inicio:
	<input type="text" id="datepickerInicio" name="fechaPrevistaInicio"
		value="">
	<br> Fecha prevista de devolucion:
	<input type="text" id="datepickerDevolucion"
		name="fechaPrevistaDevolucion" value="">
	<input type="submit" id="enviar" value="Enviar datos">
</body>
</html>
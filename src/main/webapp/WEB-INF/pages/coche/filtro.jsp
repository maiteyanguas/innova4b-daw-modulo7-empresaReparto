<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	<script src="jquery.ui.datepicker-es.js"></script>

	<script>
	$(function () {
	$.datepicker.setDefaults($.datepicker.regional["es"]);
	$("#datepickerInicio").datepicker({
	firstDay: 1
	});
	$("#datepickerDevolucion").datepicker({
		firstDay: 1
		});
	});
	</script>
	</head>

</script>

	Fecha prevista de inicio: <input type="text" id="datepickerInicio" name="fechaPrevistaInicio" value=""> <br>
	Fecha prevista de devolucion: <input type="text" id="datepickerDevolucion" name="fechaPrevistaDevolucion" value=""> <br>
	<input type="submit" id="enviar" value="Enviar datos"> <br>
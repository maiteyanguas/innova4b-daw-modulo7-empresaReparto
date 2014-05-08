$(document).ready(function() {
    $( document ).tooltip();
	getI18nReady();
	getCalendario($("#fechaInicio"), 30, 0, $("#fechaDevolucion"));
	getCalendario($("#fechaDevolucion"), 30, 0);
});

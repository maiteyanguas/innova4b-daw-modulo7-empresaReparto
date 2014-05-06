$(document).ready(function() {
    $( document ).tooltip();
	getI18nReady();
	getCalendario($("#fechaInicio"), 30, $("#fechaDevolucion"));
	getCalendario($("#fechaDevolucion"), 30);
});

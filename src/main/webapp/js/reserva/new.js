$(document).ready(function() {
	getI18nReady();
	getCalendario($("#fechaInicioPrevista"), 30, $('#fechaDevolucionPrevista'));
	getCalendario($("#fechaDevolucionPrevista"), 30);
});

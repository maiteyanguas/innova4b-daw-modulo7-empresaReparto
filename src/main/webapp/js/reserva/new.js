$(document).ready(function() {
	getI18nReady();
	getCalendario($("#fechaInicioPrevista"), 30, 0, $('#fechaDevolucionPrevista'));
	getCalendario($("#fechaDevolucionPrevista"), 30, 0);
});

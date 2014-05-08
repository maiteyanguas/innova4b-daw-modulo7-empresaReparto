function mostrarOpciones() {
	if($('#eleccionCombo').val() == "empresa") {
		$('#idEmpresa').show();
		$('#eleccionEmpresa').show();
		$('#matricula').hide();
	}else if ($('#eleccionCombo').val() =="matricula"){
		$('#idEmpresa').hide();
		$('#eleccionEmpresa').hide();
		$('#matricula').show();
	} else {
		$('#idEmpresa').hide();
		$('#eleccionEmpresa').hide();
		$('#matricula').hide();
	}
}
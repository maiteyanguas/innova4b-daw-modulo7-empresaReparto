$(document).ready(function(){
	getI18nReady();
	$('#newIncidencia').click(function(){
		$( "#incidenciaDialog" ).dialog( "open" );
		$( ".ui-widget-header" ).addClass("dialog-class");
		$( ".ui-button" ).addClass("dialog-class");
		
	});
	//limpio el formulario y los mensajes de error
	$('#incidenciaForm')[0].reset();
	$("#incidenciaForm span").remove();
	var incidencias = [];
	$( "#incidenciaDialog" ).dialog({
		title: jQuery.i18n.prop('incidencia.nueva'),
	    autoOpen: false,
	    height: 450,
	    width: 700,
	    modal: true,
	    buttons: [{
	    	text:jQuery.i18n.prop('guardar'),			    	
	    	click: function() {
	    		var incidencia = $('#incidenciaForm').serialize();
	    		
	    		$.post('/empresaReparto/incidencia/add', incidencia, function(response) {
	    			if(response.respuesta=="OK"){
		    			$('#addedIncidencias').append("<p>"+response.incidenciaAsString+"</p>");
		    			incidencias.push(response.incidencia);	
		    			$('#incidenciasJSON').val(JSON.stringify(incidencias));
		    			$('#incidenciaForm')[0].reset();
		    			$("#incidenciaForm span").remove();
	    			}else{
	    				$("#incidenciaForm span").remove();
	    				for(var key in response.errores){
	                    	var mensajeError="<span class=\"error\" id=\""+key+".errors\">"+response.errores[key]+"</span>";
	                        $("[name^='"+key+"']").after(mensajeError);
	    				}
	    			}
	    		});
	    	}
	    },{
	    	text:jQuery.i18n.prop('volver'),	
	    	click: function() {
	        	$( this ).dialog( "close" );
	    	}
		}],
        close: function() {}
	});	
});

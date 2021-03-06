$(document).ready(function(){
	getI18nReady();
	$('#newDireccion').click(function(){
		$( "#direccionDialog" ).dialog( "open" );
		$( ".ui-widget-header" ).addClass("dialog-class");
		$( ".ui-button" ).addClass("dialog-class");
		
	});
	//limpio el formulario y los mensajes de error
	$('#direccionForm')[0].reset();
	$("#direccionForm span").remove();
	var direcciones = [];
	$( "#direccionDialog" ).dialog({
		title: jQuery.i18n.prop('direccion.nueva'),
	    autoOpen: false,
	    height: 450,
	    width: 700,
	    modal: true,
	    buttons: [{
	    	text:jQuery.i18n.prop('guardar'),			    	
	    	click: function() {
	    		var direccion = $('#direccionForm').serialize();
	    		if($("#principal").is(':checked'))
	    				direccion = direccion + "&principal=true";
	    		$.post('/empresaReparto/direccion/add', direccion, function(response) {
	    			if(response.respuesta=="OK"){
		    			$('#addedDirecciones').append("<p>"+response.direccionAsString+"</p>");
		    			direcciones.push(response.direccion);	
		    			$('#direccionesJSON').val(JSON.stringify(direcciones));
		    			$('#direccionForm')[0].reset();
		    			$("#direccionForm span").remove();
	    			}else{
	    				$("#direccionForm span").remove();
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="nueva.empresa" text="Nueva empresa"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<link rel="stylesheet" type="text/css" href="/css/jquery-ui-1.10.4.custom.min.css">
<script src="/js/jquery-1.10.2.js"></script>
<script src="/js/jquery-ui-1.10.4.custom.min.js"></script>
<script src="/js/jquery.i18n.properties-min-1.0.9.js"></script>
<script src="/js/jquery.cookie.js"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p><spring:message code="nueva.empresa" text="Nueva empresa"/></p>
			
			<form:form id="empresaForm" method="POST" modelAttribute="empresa" action="/empresaReparto/empresa/add">
			<table>
				<tr>
					<td><form:label path="nombre"><spring:message code="empresa.nombre" text="Nombre"/>:</form:label></td>
					<td><form:input path="nombre"></form:input>
						<form:errors path="nombre" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="cif"><spring:message code="empresa.cif" text="CIF"/>:</form:label></td>
					<td><form:input path="cif"></form:input>
						<form:errors path="cif" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="telefono"><spring:message code="empresa.telefono" text="Teléfono"/>:</form:label></td>
					<td><form:input path="telefono"></form:input>
						<form:errors path="telefono" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="email"><spring:message code="empresa.email" text="Correo electrónico"/>:</form:label></td>
					<td><form:input path="email"></form:input>
						<form:errors path="email" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="fechaInicio"><spring:message code="empresa.fechaInicio" text="Fecha de inicio"/>:</form:label></td>
					<td><form:input path="fechaInicio"></form:input>
						<form:errors path="fechaInicio" cssClass="error"/>
					</td>
				</tr>
				
				<tr>
					<td><form:label path="direcciones"><spring:message code="empresa.direcciones" text="Direcciones"/>:</form:label></td>
					<td>
						<input type="hidden" id="direccionesJSON" name="direccionesJSON"/>
						<div id="addedDirecciones"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<spring:message code="direccion.nueva" text="Nueva Dirección" var="nuevaDireccion"/>
						<input id="newDireccion" type="button" value="${nuevaDireccion}">
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
				<a class="button" href="/empresaReparto/empresa/list"><spring:message code="volver" text="Volver"/></a>	
			</p>
			</form:form>	
			<div id="direccionDialog">
			<form:form id="direccionForm" method="POST" modelAttribute="direccion"  action="/empresaReparto/direccion/add">
			<table>
				<tr>
					<td><form:label path="calle"><spring:message code="direccion.calle" text="Calle"/>:</form:label></td>
					<td><form:input path="calle"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="portal"><spring:message code="direccion.portal" text="Portal"/>:</form:label></td>
					<td><form:input path="portal"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="piso"><spring:message code="direccion.piso" text="Piso"/>:</form:label></td>
					<td><form:input path="piso"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="letra"><spring:message code="direccion.letra" text="Letra"/>:</form:label></td>
					<td><form:input path="letra"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="otros"><spring:message code="direccion.otros" text="Otros"/>:</form:label></td>
					<td><form:input path="otros"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="codigoPostal"><spring:message code="direccion.codigoPostal" text="Código Postal"/>:</form:label></td>
					<td><form:input path="codigoPostal"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="municipio"><spring:message code="direccion.municipio" text="Municipio"/>:</form:label></td>
					<td><form:input path="municipio"></form:input></td>
				</tr>
				<tr>
					<td><spring:message code="empresa.direccionPrincipal" text="Dirección Principal"/>:</td>
					<td><input id="principal" type="checkbox" checked="checked"/></td>
				</tr>
			</table>
			</form:form>		
			</div>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
	<script type="text/javascript">
	
	$(document).ready(function(){
		var cookie = $.cookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
		var lang = cookie===undefined?'es':cookie;
		jQuery.i18n.properties({
	        name: 'messages', 
	        path: '/messages/', 
	        mode: 'both',
	        language: lang
	    });
		
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
		
	</script>
	
</body>
</html>
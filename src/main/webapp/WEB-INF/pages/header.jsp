<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="header">
	<div class="left">
		<spring:message code="usuario" text="Usuario"/>: ${usuario.usuario} 	
	</div>
	<div class="right">
		<spring:message code="idioma" text="Idioma"/> : <a href="?language=es">Español</a>|<a href="?language=eu_ES">Euskara</a>
		<a href="/empresaReparto/logout"><spring:message code="salir" text="Salir"/></a>
	</div>
</div>
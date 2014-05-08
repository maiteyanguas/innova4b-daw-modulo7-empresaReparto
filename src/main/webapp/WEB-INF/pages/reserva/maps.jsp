<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="gmap_wrapper">
	<div id="map-canvas"></div>
</div>
<a id="searchboxRouteBt" class="button" href="#"><spring:message code="mapa.calcularRuta" text="Calcular Ruta"/></a>
<a id="showRouteDetailsBt" class="button" href="#"><spring:message code="mapa.detallesRuta" text="Detalles Ruta"/></a>
<div id="gmapDirectionsPanelWrapper">
	<div id="directions-panel"></div>
</div> 
<input id="pac-inputOrigin" class="controls" type="text" placeholder=<spring:message code="mapa.origen" text="Origen"/>>
<input id="pac-inputDestiny" class="controls" type="text" placeholder=<spring:message code="mapa.destino" text="Destino"/>>
<hr>
<script src="/js/reserva/maps.js"></script>

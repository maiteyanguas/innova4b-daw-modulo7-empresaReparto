/** Global Gmaps variables **/

// Error messages
var ERROR_BETWEEN_DIRECTIONS = "No se ha podido calcular la ruta. Inténtelo desde otro punto de partida";
var ERROR_ORIGIN_OR_DESTINY_UNDEFINED = "No se ha definido ningún punto de origen o destino";

var directionsService;

var lastSearchedPlaceOrigin;
var lastSearchedPlaceDestiny;
var markerOrigin;
var markerDestiny;

//Interactive Google Map
var g_map;

//Global variables for each routing request
var directionsService;
var directionsDisplay;
var request;

/** FUNCTIONS **/

//A function that loads the init script for google maps to be loaded
function loadGmapServiceCaller() {
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = "https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&callback=initializeGmap&key=AIzaSyAQfSl374qZidrcPgHfWZPKSp04j05XzSE&libraries=places";
	document.body.appendChild(script);
};

//The function that initializes google maps js API
function initializeGmap() {
	directionsService = new google.maps.DirectionsService();
	// This is the default start point (not really selected in the search box, but it is used for center the map on some point)
	var initCoordsChicago = new google.maps.LatLng(41.850033, -87.6500523);
	
	var mapOptions = {
	    zoom: 7,
	    center: initCoordsChicago,
		zoomControl: true,
	    zoomControlOptions: {
	      style: google.maps.ZoomControlStyle.SMALL
	    },
	    mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	
	g_map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
	
	markerOrigin = new google.maps.Marker({
		position: initCoordsChicago,
		map: g_map
	});

	var defaultBounds = new google.maps.LatLngBounds(
		initCoordsChicago,
		initCoordsChicago
	);
	g_map.fitBounds(defaultBounds);
	
	// Create the search boxes and link them to the UI element.
	var inputOrigin = /** @type {HTMLInputElement} */(document.getElementById('pac-inputOrigin'));
	g_map.controls[google.maps.ControlPosition.TOP_LEFT].push(inputOrigin);
  
	var inputDestiny = /** @type {HTMLInputElement} */(document.getElementById('pac-inputDestiny'));
	g_map.controls[google.maps.ControlPosition.TOP_RIGHT].push(inputDestiny);

	var searchBoxOrigin = new google.maps.places.SearchBox(/** @type {HTMLInputElement} */(inputOrigin));
	var searchBoxDestiny = new google.maps.places.SearchBox(/** @type {HTMLInputElement} */(inputDestiny));
		    
	// [START region_getplaces]
	// Listen for the event fired when the user selects an item from the
	// pick list. Retrieve the matching places for that it. It does for both searchboxes
	google.maps.event.addListener(searchBoxOrigin, 'places_changed', function() {
		var places = searchBoxOrigin.getPlaces();
		// Hide the direction panel and its wrapper not to show previous routes
		$("#gmapDirectionsPanelWrapper, #directions-panel").css("display", "none");
		// The first matching place is stored for future routing processes
		lastSearchedPlaceOrigin = places[0];
		
		// The marker that appears in the map related to the origin is removed as it could be related to previous routes
		if((typeof markerOrigin !== "undefined") && (markerOrigin != null)){
			markerOrigin.setMap(null);
			markerOrigin = null;
		}
		
		// Adjust the map to the selected origin coordinates
		var bounds = new google.maps.LatLngBounds();
		var image = {
			url: lastSearchedPlaceOrigin.icon,
			size: new google.maps.Size(71, 71),
			origin: new google.maps.Point(0, 0),
			anchor: new google.maps.Point(17, 34),
			scaledSize: new google.maps.Size(25, 25)
		};

		// Create a marker for the selected place.
		markerOrigin = new google.maps.Marker({
			map: g_map,
			icon: image,
			title: lastSearchedPlaceOrigin.name,
			position: lastSearchedPlaceOrigin.geometry.location
		});

		bounds.extend(lastSearchedPlaceOrigin.geometry.location);

		g_map.fitBounds(bounds);
  });
  
  google.maps.event.addListener(searchBoxDestiny, 'places_changed', function() {
	 var places = searchBoxDestiny.getPlaces();
	 // It does the same as the listener for searchBoxOrigin
	 $("#gmapDirectionsPanelWrapper, #directions-panel").css("display", "none");
	 // The first matching place is stored for future routing processes
	 lastSearchedPlaceDestiny = places[0];
	 
		// The marker that appears in the map related to the destiny is removed as it could be related to previous routes	
	 if((typeof markerDestiny !== "undefined") && (markerDestiny != null)){
    	markerDestiny.setMap(null);
    	markerDestiny = null;
	 }
	 
	 // It does the same as the listener of origin
	 var bounds = new google.maps.LatLngBounds();
	 	var image = {
			url: lastSearchedPlaceDestiny.icon,
			size: new google.maps.Size(71, 71),
			origin: new google.maps.Point(0, 0),
			anchor: new google.maps.Point(17, 34),
			scaledSize: new google.maps.Size(25, 25)
		};

	 // Create a marker for the selected place.
	 markerDestiny = new google.maps.Marker({
		map: g_map,
		icon: image,
		title: lastSearchedPlaceDestiny.name,
		position: lastSearchedPlaceDestiny.geometry.location
	});

	bounds.extend(lastSearchedPlaceDestiny.geometry.location);

    g_map.fitBounds(bounds);
  });
  // [END region_getplaces]

  // Bias the SearchBox elements's results towards places that are within the bounds of the
  // current map's viewport.
  google.maps.event.addListener(g_map, 'bounds_changed', function() {
    var bounds = g_map.getBounds();
    searchBoxOrigin.setBounds(bounds);
  });
};

// Check the route calculation button for the search box
$("body").on("click", function(event){
	if($(event.target).attr("id") == "searchboxRouteBt") {
		// Check for the coordinates of origin and destiny not to be undefined
		if((lastSearchedPlaceOrigin !== undefined) && (lastSearchedPlaceDestiny !== undefined)
				&& (lastSearchedPlaceOrigin !== null) && (lastSearchedPlaceDestiny !== null)){
			// Information of previous routes is removed if exists 
	    	if((typeof markerOrigin !== "undefined") && (markerOrigin != null)){
	    		markerOrigin.setMap(null);
	    		markerOrigin = null;
	    	}
	    	if((typeof markerDestiny !== "undefined") && (markerDestiny != null)){
		    	markerDestiny.setMap(null);
		    	markerDestiny = null;
	    	}
			$("#directions-panel").html("");
			if((typeof directionsDisplay !== "undefined") && (directionsDisplay != null)){
				directionsDisplay.setMap(null);
				directionsDisplay = null;
			}
			directionsDisplay = new google.maps.DirectionsRenderer();
			directionsDisplay.setMap(g_map);
			directionsDisplay.setPanel(document.getElementById("directions-panel"));
			request = {
				origin:lastSearchedPlaceOrigin.geometry.location,
				destination:lastSearchedPlaceDestiny.geometry.location,
				travelMode: google.maps.TravelMode.DRIVING
			};
			// The route calculation request is sent
			directionsService.route(request, function(response, status) {
				if (status == google.maps.DirectionsStatus.OK) {
					directionsDisplay.setDirections(response);
				}
				else {
					alert(ERROR_BETWEEN_DIRECTIONS);
				}
			});
		}
		else {
			alert(ERROR_ORIGIN_OR_DESTINY_UNDEFINED);
		}
	}
	else if($(event.target).attr("id") == "showRouteDetailsBt") {
		// Check if the user has selected an origin and destiny before showing detailed information about the calculated route
		if((lastSearchedPlaceOrigin !== undefined) && (lastSearchedPlaceDestiny !== undefined)
				&& (lastSearchedPlaceOrigin !== null) && (lastSearchedPlaceDestiny !== null)){
			$("#gmapDirectionsPanelWrapper, #directions-panel").css("display", "block");
		}
		else
			alert(ERROR_ORIGIN_OR_DESTINY_UNDEFINED);
	}
});

$(window).on("load", function(){
	//Load the google maps init script
	loadGmapServiceCaller();
});

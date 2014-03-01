var userId = "1234";
var myPlacesToggle = false;
var myPlacesList = [];
var map;
var marker;
var markerArray =[];
var routesMarkerArray = [];
var routePolylinesArray = [];
var markerArray = [];
var infoWindow = new google.maps.InfoWindow({
	maxwidth: 500
}
);
var zoomFluid;
var lineSymbol = {
	    path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW
	  };

var upIkotRoutePath;
var upTokiRoutePath;
var upKatipRoutePath;
var upPhilcRoutePath;
var visiblePath = [0,0,0,0,0];

var routeMarkerArray = [];

var directionsDisplay;
var directionsService = new google.maps.DirectionsService();

var display = 0;
var resultsToggle = 0;

var upMapBoundaryCoordinates = [
  	                           	new google.maps.LatLng(14.662367,121.044873),
  	                          	new google.maps.LatLng(14.661994,121.046836),  	    	                          
  	                         	new google.maps.LatLng(14.662149,121.047319),
  	                         	new google.maps.LatLng(14.662108,121.049979),
  	                         	new google.maps.LatLng(14.662118,121.051406),
  	                         	new google.maps.LatLng(14.661983,121.053359),
  	                       		new google.maps.LatLng(14.662004,121.054872),
  	                       		new google.maps.LatLng(14.661942,121.057125),
  	                       		new google.maps.LatLng(14.661921,121.058273),
  	                       		new google.maps.LatLng(14.661879,121.059303),
  	                       		new google.maps.LatLng(14.66189,121.060107),
	                       		new google.maps.LatLng(14.661765,121.062167),
	                       		new google.maps.LatLng(14.661827,121.064796),
	                       		new google.maps.LatLng(14.662066,121.066985),
  	                          	new google.maps.LatLng(14.663,121.072424),
	                       		new google.maps.LatLng(14.663177,121.074066),
	                       		new google.maps.LatLng(14.662025,121.07501),
	                       		new google.maps.LatLng(14.65972,121.076083),
	                       		
	                       		new google.maps.LatLng(14.659087,121.076104),
  	                       		new google.maps.LatLng(14.657769,121.074624),
  	                       		new google.maps.LatLng(14.657489,121.074506),
  	                       		new google.maps.LatLng(14.654448,121.074504),
	                       		new google.maps.LatLng(14.653576,121.07444),
	                       		new google.maps.LatLng(14.652517,121.074375),
	                       		new google.maps.LatLng(14.652543,121.076851),
  	                          	new google.maps.LatLng(14.652138,121.076389),
	                       		new google.maps.LatLng(14.652024,121.076373),
	                       		new google.maps.LatLng(14.650809,121.076507),
	                       		new google.maps.LatLng(14.650296,121.077285),
	                       		new google.maps.LatLng(14.647654,121.074646),
  	                           	
	                       		new google.maps.LatLng(14.647597,121.07443),
	                       		new google.maps.LatLng(14.64631,121.074452),
	                       		new google.maps.LatLng(14.646216,121.073969),
	                       		new google.maps.LatLng(14.636822,121.064094),
	                       		new google.maps.LatLng(14.636697,121.062682),
	                       		new google.maps.LatLng(14.646787,121.061331),//B.Baluyot
	                       		
  	                          	new google.maps.LatLng(14.646777,121.059528),
	                       		new google.maps.LatLng(14.652039,121.056996),
	                       		new google.maps.LatLng(14.651925,121.056824),
	                       		new google.maps.LatLng(14.651759,121.055805),
	                       		new google.maps.LatLng(14.651842,121.05382),
	                       		new google.maps.LatLng(14.653399,121.052887),
	                       		new google.maps.LatLng(14.653835,121.052436),
	                          	new google.maps.LatLng(14.654406,121.052383),
	                       		new google.maps.LatLng(14.654666,121.051321),
	                       		new google.maps.LatLng(14.655797,121.05043),
	                       		new google.maps.LatLng(14.656285,121.049486),
	                       		new google.maps.LatLng(14.656804,121.048831),
	                       		
	                       		new google.maps.LatLng(14.658163,121.047769),
	                       		new google.maps.LatLng(14.658215,121.047608),
	                       		new google.maps.LatLng(14.658548,121.04734),
	                       		new google.maps.LatLng(14.658693,121.046772),
	                       		new google.maps.LatLng(14.659575,121.046407),
	                       		new google.maps.LatLng(14.659637,121.045881),
	                       		new google.maps.LatLng(14.65999,121.045924),
	                          	new google.maps.LatLng(14.660219,121.046171),
	                       		new google.maps.LatLng(14.660219, 121.046171),
	                       		new google.maps.LatLng(14.660489,121.046235),
	                       		new google.maps.LatLng(14.661215,121.045827),
	                       		new google.maps.LatLng(14.661184,121.045591),
	                       		
	                       		new google.maps.LatLng(14.660956,121.045355),
	                       		new google.maps.LatLng(14.661454,121.044604),
	                       		new google.maps.LatLng(14.662367,121.044873)
	                       		
	                       		
  	                         
  	                          
  	                         ];

var upIkotRouteCoordinates = [	
								new google.maps.LatLng(14.65765,121.062345), //magsaysay ave emilio jacinto st corner
								new google.maps.LatLng(14.654837,121.06234), //u ave.
								new google.maps.LatLng(14.647285,121.062294), //cp garcia
								new google.maps.LatLng(14.647659,121.064034),
								new google.maps.LatLng(14.64768,121.064313),
								new google.maps.LatLng(14.647742,121.065096),
								new google.maps.LatLng(14.647804,121.065407),
								new google.maps.LatLng(14.647908,121.065686),
								new google.maps.LatLng(14.64795,121.066255),
								new google.maps.LatLng(14.647192,121.067821),
								new google.maps.LatLng(14.647161,121.068122),
								new google.maps.LatLng(14.647161,121.068969),
								new google.maps.LatLng(14.648801,121.068991), //engg lib 2
								new google.maps.LatLng(14.648874,121.06897),
								new google.maps.LatLng(14.649668,121.068681),
								new google.maps.LatLng(14.650181,121.068487),
								new google.maps.LatLng(14.65097,121.068418),
								new google.maps.LatLng(14.651692,121.068557),
								new google.maps.LatLng(14.652439,121.068659),
								new google.maps.LatLng(14.652444,121.070682), //Fernandez St.
								new google.maps.LatLng(14.652473,121.071672),
								new google.maps.LatLng(14.653871,121.071648), //Roxas Ave.
								new google.maps.LatLng(14.653897,121.072761),
								new google.maps.LatLng(14.654191,121.072922),
								new google.maps.LatLng(14.654383,121.073005),
								new google.maps.LatLng(14.654663,121.07308),//ikot jeepney stop
								new google.maps.LatLng(14.655405,121.073099),
								new google.maps.LatLng(14.655662,121.073029),
								new google.maps.LatLng(14.655883,121.072919),
								new google.maps.LatLng(14.655979,121.072849),
								new google.maps.LatLng(14.656082,121.072734),
								new google.maps.LatLng(14.657081,121.072734), //Romulo Hall
								new google.maps.LatLng(14.657507,121.072734),
								new google.maps.LatLng(14.658599,121.072734),
								new google.maps.LatLng(14.658851,121.072726),
								new google.maps.LatLng(14.659087,121.072723),
								new google.maps.LatLng(14.659259,121.072651),
								new google.maps.LatLng(14.659329,121.072581),
								new google.maps.LatLng(14.659383,121.072468),
								
								new google.maps.LatLng(14.659386,121.072254),
								new google.maps.LatLng(14.65938,121.071605), //F. Agoncillo St.
								new google.maps.LatLng(14.65938,121.0705), //Shopping Center
								new google.maps.LatLng(14.659373,121.069993),
								new google.maps.LatLng(14.659362,121.069563),
								new google.maps.LatLng(14.659357,121.069212), //Romulo Hall
								new google.maps.LatLng(14.659349,121.068949),
								new google.maps.LatLng(14.659344,121.06855),
								new google.maps.LatLng(14.657484,121.068555), //Magsaysay Ave
								new google.maps.LatLng(14.657489,121.067678),
								new google.maps.LatLng(14.657502,121.066943),
								new google.maps.LatLng(14.657523,121.065749),
								new google.maps.LatLng(14.657525,121.065543),
								new google.maps.LatLng(14.65753,121.064813),
								new google.maps.LatLng(14.657608,121.063826),
								new google.maps.LatLng(14.657632,121.06282), 
								new google.maps.LatLng(14.657639,121.062482),
								new google.maps.LatLng(14.65765,121.062345)
                            
                            ];


var upTokiRouteCoordinates = [	
								new google.maps.LatLng(14.653742, 121.064903), 
								new google.maps.LatLng(14.653846,121.068579), //a. roces
								new google.maps.LatLng(14.657468,121.068536),
								new google.maps.LatLng(14.659373,121.068525), //sc
								new google.maps.LatLng(14.659388, 121.072424),
								new google.maps.LatLng(14.659233, 121.072692), //ilangilang
								new google.maps.LatLng(14.656088, 121.072714),									
								new google.maps.LatLng(14.656056, 121.068594),
								
								new google.maps.LatLng(14.653825, 121.068658), //circle again
								new google.maps.LatLng(14.653897, 121.072692),
								new google.maps.LatLng(14.653773, 121.072757), //near vinzons curve
								new google.maps.LatLng(14.652237, 121.072810),
								new google.maps.LatLng(14.652039, 121.072778), //curve again
								new google.maps.LatLng(14.651261, 121.071963), 
								new google.maps.LatLng(14.651136, 121.071920), //curve again agian
								new google.maps.LatLng(14.650347, 121.071984), //science circle
								new google.maps.LatLng(14.650493, 121.072639),
								new google.maps.LatLng(14.650534, 121.073615),
								new google.maps.LatLng(14.650462, 121.073744), //curve again
								new google.maps.LatLng(14.648230, 121.073765), //CP Garcia
								new google.maps.LatLng(14.648188, 121.072531), 
								new google.maps.LatLng(14.647597, 121.071383), //used to be path to Math
								new google.maps.LatLng(14.647327, 121.070907),
								new google.maps.LatLng(14.647187, 121.070124),
								new google.maps.LatLng(14.647171, 121.068986),
								new google.maps.LatLng(14.648874, 121.068981), //DCS
								new google.maps.LatLng(14.650223, 121.068471),
								new google.maps.LatLng(14.650436, 121.068429), //MS
								new google.maps.LatLng(14.651095, 121.068418),
								new google.maps.LatLng(14.652003, 121.068627), 
								new google.maps.LatLng(14.652423, 121.068654),
								new google.maps.LatLng(14.652403,121.068321),
								new google.maps.LatLng(14.652252,121.067812),
								new google.maps.LatLng(14.652128,121.067506),
								new google.maps.LatLng(14.651738,121.066959), //OUR
								new google.maps.LatLng(14.651297,121.066749),
								new google.maps.LatLng(14.651183,121.066728),
								
								new google.maps.LatLng(14.650327,121.06683),
								new google.maps.LatLng(14.651733,121.065156),
								new google.maps.LatLng(14.652003,121.065022), 
								new google.maps.LatLng(14.652932,121.065172), 
								new google.maps.LatLng(14.652896,121.06234), 

								new google.maps.LatLng(14.657634,121.062356),
								new google.maps.LatLng(14.657608,121.063757), //SURP
								new google.maps.LatLng(14.657525,121.064811),
								new google.maps.LatLng(14.655914,121.064789), //Circle
								new google.maps.LatLng(14.654894,121.064277), 
								new google.maps.LatLng(14.654811,121.064282),
								new google.maps.LatLng(14.653799,121.064795),
								new google.maps.LatLng(14.653742, 121.064903)
                            
                            ];

var upKatipRouteCoordinates = [	
								new google.maps.LatLng(14.657525,121.072742), //GT
								new google.maps.LatLng(14.659144,121.072736), 
								new google.maps.LatLng(14.659393,121.072468),
								new google.maps.LatLng(14.659362,121.068547), 
								new google.maps.LatLng(14.657494,121.068547), //Engg
								new google.maps.LatLng(14.657546,121.064818), 
								
								new google.maps.LatLng(14.655911,121.064791), //Circle								
								new google.maps.LatLng(14.654961,121.064287),
								new google.maps.LatLng(14.654832,121.064276), 
								new google.maps.LatLng(14.65382,121.064775),
								new google.maps.LatLng(14.6537,121.064888), 
								new google.maps.LatLng(14.653804,121.068594), //AS
								new google.maps.LatLng(14.653887,121.072735), //Vinsonz
								new google.maps.LatLng(14.654349,121.072988), 
								new google.maps.LatLng(14.654858,121.073096), 
								new google.maps.LatLng(14.655408,121.073096),
								new google.maps.LatLng(14.655885,121.072919),
								new google.maps.LatLng(14.656103,121.072715),
								new google.maps.LatLng(14.657478,121.072736), //GT again
								
								new google.maps.LatLng(14.657489,121.074163), //Katip
								new google.maps.LatLng(14.653565,121.074216), 
								new google.maps.LatLng(14.648303,121.074237), //CPG
								new google.maps.LatLng(14.64631,121.074246),
								new google.maps.LatLng(14.643694,121.074547), 
								new google.maps.LatLng(14.636843,121.074225), //Arr-neo
								new google.maps.LatLng(14.632005,121.074032), //Jeep Stop
								
								new google.maps.LatLng(14.632218,121.074351),
								new google.maps.LatLng(14.634694,121.074474),
								new google.maps.LatLng(14.634808,121.074437),
								new google.maps.LatLng(14.641223,121.074683), //Arr-neo2
								new google.maps.LatLng(14.643299,121.074801),
								new google.maps.LatLng(14.646611,121.074431), 
								new google.maps.LatLng(14.649559,121.074474),
								new google.maps.LatLng(14.653534,121.074474), //Shister
								new google.maps.LatLng(14.654624,121.074527),
								new google.maps.LatLng(14.65751,121.074522),
								new google.maps.LatLng(14.657541,121.074469),
								new google.maps.LatLng(14.657525,121.072742)
                             
                             ];

var upPhilcRouteCoordinates = [	
								new google.maps.LatLng(14.657525,121.072742), //GT
								new google.maps.LatLng(14.659144,121.072736), 
								new google.maps.LatLng(14.659393,121.072468),
								new google.maps.LatLng(14.659362,121.068547), 
								new google.maps.LatLng(14.657494,121.068547), //Engg
								new google.maps.LatLng(14.656067,121.068562),
								new google.maps.LatLng(14.656046,121.065001),
								new google.maps.LatLng(14.655911,121.064791), //Circle								
								new google.maps.LatLng(14.654961,121.064287),
								
								new google.maps.LatLng(14.654946,121.064105), //ENtrance
								new google.maps.LatLng(14.654904,121.062345),
								new google.maps.LatLng(14.654889,121.058397),
								new google.maps.LatLng(14.654858,121.056906),
								new google.maps.LatLng(14.654909,121.055876),
								new google.maps.LatLng(14.655024,121.055704),
								new google.maps.LatLng(14.655143,121.055661),
								new google.maps.LatLng(14.655465,121.055822), //commonwealth
								new google.maps.LatLng(14.656549,121.057517), //uturn
								new google.maps.LatLng(14.656835,121.057292),
								new google.maps.LatLng(14.656207,121.056267),
								new google.maps.LatLng(14.655076,121.054545),
								new google.maps.LatLng(14.65451,121.053762),
								new google.maps.LatLng(14.653965,121.053177),
								
								new google.maps.LatLng(14.652808,121.05138), //uturn again
								new google.maps.LatLng(14.652615,121.051544),
								new google.maps.LatLng(14.653,121.052092),
								new google.maps.LatLng(14.653433,121.052802),
								new google.maps.LatLng(14.654035,121.053961),
								new google.maps.LatLng(14.654193,121.054382),
								new google.maps.LatLng(14.654642,121.056461),
								new google.maps.LatLng(14.654694,121.05693),
								new google.maps.LatLng(14.654767,121.062332), //gate
								new google.maps.LatLng(14.65479,121.064062),
								
								new google.maps.LatLng(14.654746,121.064304), //oble
								new google.maps.LatLng(14.65382,121.064775),
								new google.maps.LatLng(14.6537,121.064888), 
								new google.maps.LatLng(14.653804,121.068594), //AS
								new google.maps.LatLng(14.653887,121.072735), //Vinsonz
								new google.maps.LatLng(14.654349,121.072988), 
								new google.maps.LatLng(14.654858,121.073096), 
								new google.maps.LatLng(14.655408,121.073096),
								new google.maps.LatLng(14.655885,121.072919),
								new google.maps.LatLng(14.656103,121.072715),
								new google.maps.LatLng(14.657478,121.072736), //GT again
								new google.maps.LatLng(14.657525,121.072742)
                             
                             ];

function initialize() {
	directionsDisplay = new google.maps.DirectionsRenderer();


	
	var myLatlng = new google.maps.LatLng(14.651147,121.060274); 


  	var mapOptions = {
    		center: myLatlng,
    		zoom: 15,
    		disableDefaultUI: false,
    		clickableLabels:false 
  	};
  	map = new google.maps.Map(document.getElementById("map-canvas"),
      	mapOptions);
  	directionsDisplay.setMap(map);

  	
  	var upMapBoundaryPath = new google.maps.Polyline({
  	                 path: upMapBoundaryCoordinates,
  	                 geodesic: true,
  	                 strokeColor: '#A23030',
  	                 strokeOpacity: 0.55,
  	                 strokeWeight: 3
  	               });

  	upMapBoundaryPath.setMap(map);

	
	upIkotRoutePath = new google.maps.Polyline({
             path: upIkotRouteCoordinates,
             geodesic: true,
             strokeColor: '#fff000',
             strokeOpacity: 0.80,
             strokeWeight: 4,
             icons: [{
                 icon: lineSymbol,
                 offset: '100%'
               }]

           });
	
	upTokiRoutePath = new google.maps.Polyline({
             path: upTokiRouteCoordinates,
             geodesic: true,
             strokeColor: '#7f00ff',
             strokeOpacity: 0.80,
             strokeWeight: 4,
             icons: [{
                 icon: lineSymbol,
                 offset: '100%'
               }]
           });

	
	upKatipRoutePath = new google.maps.Polyline({
             path: upKatipRouteCoordinates,
             geodesic: true,
             strokeColor: '#f00',
             strokeOpacity: 0.80,
             strokeWeight: 4,
             icons: [{
                 icon: lineSymbol,
                 offset: '100%'
               }]
           });

	
	upPhilcRoutePath = new google.maps.Polyline({
             path: upPhilcRouteCoordinates,
             geodesic: true,
             strokeColor: '#0f0',
             strokeOpacity: 0.80,
             strokeWeight: 4,
             icons: [{
                 icon: lineSymbol,
                 offset: '100%'
               }]
           });

	/*----------------------------------------------------
		Object: #goup-logo
		Event: click
		Function: pans the map back to the initial center 
	------------------------------------------------------*/
	google.maps.event.addDomListener(document.getElementById("goup-logo"), 'click', function() {

	 	map.panTo(myLatlng);
	    map.setZoom(15);
	    
	  
	});	
	
	
	}

function path() {
	var origin = $("#searchOriginPlaceName").val();
	var dest = $("#searchDestinationPlaceName").val();
	if(origin == "" || dest == "") {
		clearMarkers();
		directionsDisplay.setMap();
		$("div#routes").html("");
	}
	else {
		var originLat = "";
		var originLng = "";
		var destLat = "";
		var destLng = "";
		$.ajax({
			type: "Get",
			url: "/UPMap/findPlace",
			data: "placeName=" +origin,
			success: function(json){
				place = $.parseJSON(json);
				originLat = place[0].placeLat;
				originLng = place[0].placeLong;
			},
			error: function(e){
				alert("Error: "+ e);
			}
			
		});
		
		$.ajax({
			type: "Get",
			url: "/UPMap/findPlace",
			data: "placeName=" +dest,
			success: function(json){
				place = $.parseJSON(json);
				destLat = place[0].placeLat;
				destLng = place[0].placeLong;
				calcRoute(originLat+","+originLng, destLat+","+destLng);
			},
			error: function(e){
				alert("Error: "+ e);
			}
			
		});
	}
}


function calcRoute(originLatLngStr, destinationLatLngStr) {

	  clearMarkers();

	 for (var i = 0; i < routeMarkerArray.length; i++) {
	    routeMarkerArray[i].setMap(null);
	  }
	 routeMarkerArray = [];
	  

	  var request = {
	      origin:originLatLngStr,
	      destination:destinationLatLngStr,
	      travelMode:google.maps.TravelMode.WALKING,
	      provideRouteAlternatives:true
	  };
	  directionsService.route(request, function(response, status) {
	    if (status == google.maps.DirectionsStatus.OK) {
	    	$("div#routes").html("");
    	 for(var i = 1; i <= response.routes.length; i++) {
    		 
	    	  $("div#routes").append('<div class="col-md-1"><a class="route-link" data-index='+(i-1)+'>'+i+'</a></div> ');
	      }
    	 $("div#routes").append("<br />");
	      directionsDisplay.setMap(map);
	      directionsDisplay.setDirections(response);
	      drawRoutesMarkers(response, 0);
	    }
	    
	    $(document).ready(function() {
    	    $(".route-link").click(function() {
    	    	var index = $(this).data("index");
    	    	clearMarkers();
    	    	directionsDisplay.setRouteIndex(index);
    	    	drawRoutesMarkers(response, index);
    	    });
    	});
	  });
	 
	  
}

function drawRoutesMarkers(directionResult, ind) {
	
	var distance = 0.0;
	var myRoute = directionResult.routes[ind].legs[0];
	  for (var i = 0; i < myRoute.steps.length; i++) {
		distance += myRoute.steps[i].distance.value;
	    var newMarker = new google.maps.Marker({
	      position: myRoute.steps[i].start_location,
	      map: map
	    });
	    attachInstructionText(newMarker, myRoute.steps[i].instructions);
	    routesMarkerArray[i] = newMarker;
	    newMarker = null;
	  }
	  //$("div#routes").append(distance+" m <br />");
}

function attachInstructionText(marker, text) {
	  google.maps.event.addListener(marker, 'click', function() {
	    stepDisplay.setContent(text);
	    stepDisplay.open(map, marker);
	  });
}


function setInitPanAndZoom(){
	
	var myLatlng = new google.maps.LatLng(14.651147,121.060274); 
	map.panTo(myLatlng);
	zoomFluid = map.getZoom();
	zoomOut();
}
function ikotRoute (){
	
	if(visiblePath[0]==0){
		
		upIkotRoutePath.setMap(map);
		visiblePath[0]=1;
		
	}else{
		upIkotRoutePath.setMap(null);
		visiblePath[0]=0;
		visiblePath[4]=0;
	}
		

}

function tokiRoute (){
	if(visiblePath[1]==0){
		upTokiRoutePath.setMap(map);
		visiblePath[1]=1;
		
	}else{
		upTokiRoutePath.setMap(null);
		visiblePath[1]=0;
		visiblePath[4]=0;
	}
}

function katipRoute (){
	if(visiblePath[2]==0){
		upKatipRoutePath.setMap(map);
		visiblePath[2]=1;
		
	}else{
		upKatipRoutePath.setMap(null);
		visiblePath[2]=0;
		visiblePath[4]=0;
	}
}
function philcRoute (){
	if(visiblePath[3]==0){
		upPhilcRoutePath.setMap(map);
		visiblePath[3]=1;
		
	}else{
		upPhilcRoutePath.setMap(null);
		visiblePath[3]=0;
		visiblePath[4]=0;
	}
}

function allRoute (){
	
	if(visiblePath[4]==0){
		upIkotRoutePath.setMap(map);
		upTokiRoutePath.setMap(map);
		upKatipRoutePath.setMap(map);
		upPhilcRoutePath.setMap(map);
		var i = 0;
		while(i<5){
			visiblePath[i] = 1;
			i++;
		}
	}else{
		upIkotRoutePath.setMap(null);
		upTokiRoutePath.setMap(null);
		upKatipRoutePath.setMap(null);
		upPhilcRoutePath.setMap(null);
		var i = 0;
		while(i<5){
			visiblePath[i] = 0;
			i++;
		}
	}
	
}

function panToLatLng(placeName,placeLat,placeLong){
	var myLatLng = new google.maps.LatLng(placeLat,placeLong);

	
	zoomFluid = map.getZoom();
	map.panTo(myLatLng);
	
	if(zoomFluid<=17)
		zoomTo();
	else
		zoomOut();
	
	
	
}

function clearMarkers(){
	for(var i=0;i<markerArray.length;i++){
		markerArray[i].setMap(null);
	}
	markerArray = [];
	
	for(var i = 0; i < routesMarkerArray.length; i++) {
		for(var j = 0; j < routesMarkerArray[i].length; j++) {
			routesMarkerArray[i][j].setMap(null);
		}
	}
	routesMarkerArray = [];
}

var autoCompleteCategory = "";
function getAllPlaceNames(){
	
	var availablePlaceNames = [];
	$.ajax({
		type: "Get",
		url: "/UPMap/findPlaceByCategoryAndName",
		data: "category=" + autoCompleteCategory +"&placeName=" +"",
		success: function(json){
		
			if(json){
				var place = $.parseJSON(json);
				if(place) {
				
					
					for(var i = 0; i < place.length; i++) {
						availablePlaceNames.push(place[i].placeName);
					}
				}
			}
			
						
		},
		error: function(e){
			alert("Error: "+ e);
		}
		
	});
	
	$( "#searchPlaceName" ).autocomplete({
		source: availablePlaceNames
	});
	
	$( ".search-input" ).autocomplete({
		source: availablePlaceNames
	});
}



function containsObject(obj,array){
	
	for(var i=0;i<array.length;i++){
		if(_.isEqual(array[i],obj))
			return true;
	}
	return false;
}

function getMyPlaces(){
	
	$.ajax({
		type: "Get",
		url: "/UPMap/getMyPlaces",
		data: "userId="+userId,
		success: function(json){
			myPlacesList = $.parseJSON(json);
			updateMyPlaces();
			
		},
		error: function(e){
			return null;
		}
	});
	

	
	
}

function updateMyPlaces(){
	
	
	
	$("div#favorites").html("");
	if(myPlacesList!=""){
		for(var i=0;i<myPlacesList.length;i++){
			$("div#favorites").append('<div class="results-item"><a>'+myPlacesList[i].placeName+'</a></div>');
			
		}
		
	}else{
		
		$("div#favorites").append("<p>No saved places yet.</p>");
	}

}

function showOrHideTarget(target){
	if($(target).css("display")!="none"){
		$(target).fadeOut(250);
		display = display -1;
		showOrHideFeature();
	}else{
		$(target).fadeIn(250);
		display = display + 1;
		showOrHideFeature();
	}
}


function viewMyPlaces(){
	
	getMyPlaces();
	updateMyPlaces();
	updateRecentlySearched();
	showOrHideTarget($("#myPlaces"));
		
	
}

function viewGetDirections(){
	
	
	showOrHideTarget($("#getDirections"));
		
	
}

function updateRecentlySearched(){
	
	$("div#recent").html("");
	
	var searchedList = $.cookie("recentlySearched");
	
	if(searchedList){
		searchedList = $.parseJSON(searchedList);
		
		if(searchedList.length == 0){
			
			$("div#recent").append("No recently searched items.");
		}else{
			
			for(var i=0; i<searchedList.length;i++){
			 
				$("div#recent").append('<div class="recent-place"><a class="recent-place-link" data-placename="'+ searchedList[i].placeName+ '">'+searchedList[i].placeName+'</a><i class="delete-mark fa fa-times"></i></div>');
				
				$(".recent-place-link").click(function(){
					var category ="";
					var placeName = $(this).data("placename");
					doSearchOptimized(category,placeName);
				});
				
				$(".recent-place").hover(function(){
					$(this).find(".delete-mark").css("visibility","visible");
					$(this).find(".recent-place-link").addClass("recent-place-focus");
				},function(){
					$(this).find(".delete-mark").css("visibility","hidden");
					$(this).find(".recent-place-link").removeClass("recent-place-focus");
				});
			}
			
			
		}
		
		
		
	}else{
		$("div#recent").append("No recently searched items.");
	}
	
	
	
}

function addRecentlySearchedPlace(object){
	
	
	var searchedList = $.cookie("recentlySearched");
	var objectJSON;
	
	if(!searchedList){
		searchedList = [];
		searchedList.unshift(object);
		objectJSON = JSON.stringify(searchedList);
		$.cookie("recentlySearched",objectJSON,{path: '/', expires:7});
		updateRecentlySearched();
		
	}else{
		searchedList = $.parseJSON(searchedList);
		
		if(!containsObject(object,searchedList)){
			
			if(searchedList.length<5){
				searchedList.unshift(object);
			}else{
				searchedList.pop();
				searchedList.unshift(object);
			}
			
			objectJSON = JSON.stringify(searchedList);
			$.cookie("recentlySearched",objectJSON,{path: '/', expires:7});
			updateRecentlySearched();
		}
	}
	
	
}

function doSearchOptimized(category,placeName){
	
	
	clearMarkers();
	
	setInitPanAndZoom();

	$.ajax({
		type: "Get",
		url: "/UPMap/findPlaceByCategoryAndName",
		data: "category=" + category +"&placeName=" +placeName,
		success: function(json){
			
			$("div#results").html("");
			$("div#results").removeClass("hidden");
			if(resultsToggle==0){
				display = display + 1;
				resultsToggle=1;
			}
				
			
			showOrHideFeature();
			if(json){
				
				var searchString;
				
				
				var place = $.parseJSON(json);
				if(place) {
					if(placeName!="")
						searchString = placeName;
					else
						searchString = place[0].placeCategory;
						
					if(place.length>1)
						$("div#results").append('<p><b style="font-size:20px">'+ searchString+'</b><br />'+ place.length +' results found.</p>');
					else
						$("div#results").append('<p><b style="font-size:20px">'+ searchString+'</b><br />'+ place.length +' result found.</p>');
					
					
					for(var i = 0; i < place.length; i++) {
						
						var letter= String.fromCharCode('A'.charCodeAt() + i);
						var string = "";
						string = string + '<div class="results-item">';
						string = string + '<div class="marker-label"><a class="map-marker">'+letter+'</a></div>';
						string = string + '<div class="results-details"><a class="place-link" data-placename="'+place[i].placeName +'" data-latitude="' +place[i].placeLat + '" data-longitude="'+place[i].placeLong +'">' + place[i].placeName + '</a><br />';
						string = string + '<p class="small-note">Category: <a class="category-link">'+ place[i].placeCategory +'</a></p></div>';
						
						var myPlaceObj = new Object({
							userId: userId,
							placeId: place[i].placeId,
							placeName: place[i].placeName
						});
						var starclass = '';
						if(containsObject(myPlaceObj,myPlacesList)){
							starclass = 'favorite-star fa fa-star active';
						}else{
							starclass = 'favorite-star fa fa-star';
						}
						
						string = string + '<div class="favorite-star-wrapper"><a class="'+ starclass +'" data-placeid="'+place[i].placeId +'"></a></div>';
						string = string + '</div>';
						
						
						$("div#results").append(string);
						var markerPosition = new google.maps.LatLng(place[i].placeLat,place[i].placeLong);
						var newMarker = new google.maps.Marker({
						    position: markerPosition,
						    map: map,
						    title: place[i].placeName
						      
						});
						
						var markerIcon = new google.maps.MarkerImage(
							    'resources/img/marker'+letter+'.png',
							    null, /* size is determined at runtime */
							    null, /* origin is 0,0 */
							    null, /* anchor is bottom center of the scaled image */
							    new google.maps.Size(32,45)
							);  
						newMarker.setIcon(markerIcon);
						markerArray.push(newMarker);
						newMarker.setMap(map);
						
						/*--------------------------------------------------
						Object: marker
						Event: click
						Function: Shows information box about UP 
						-----------------------------------------------------*/
						google.maps.event.addListener(newMarker, 'click', function() {
							zoomFluid = map.getZoom();
							infoWindow.close();
							map.panTo(this.getPosition());
							infoWindow.setContent('<div class="info-window"><p>'+this.getTitle()+'</p></div>');
							infoWindow.open(map, this);
							if(zoomFluid<=17)
								zoomTo();
							else
								zoomOut();
							
							
							
				
						});
						
					}
					$(document).ready(function() {
			    	    $(".place-link").click(function() {
			    	    	var placeLat = $(this).data("latitude");
			    	    	var placeLong = $(this).data("longitude");
			    	    	var placeName = $(this).data("placename");
			    	    	panToLatLng(placeName,placeLat,placeLong);
			    	    	
			    	    	
			    	    	var object = new Object();
			    	    	
			    	    	object={	placeName: placeName,
			    	    				placeLat: placeLat,
			    	    				placeLong: placeLong  };
			    	    	
			    	    	addRecentlySearchedPlace(object);
			    	    		
			    	    	
			    	    	
			    	    	
			    	    	
			    	    });
			    	    
			    	    $(".favorite-star").click(function() {
			    	    	
			    	    	if(!$(this).hasClass('active')){
			    	    		var placeId = $(this).data("placeid");
				    	    	if($.ajax({
				    	    		type: "Post",
				    	    		url: "/UPMap/insertMyPlace",
				    	    		data: "userId="+userId+"&placeId="+placeId,
				    	    		success: function(){
				    	    			getMyPlaces();
					    	    		
				    	    			return true;
				    	    		},
				    	    		error: function(){
				    	    			return false;
				    	    		}
				    	    		}
				    	    	
				    	    			
				    	    	
				    	    	)){
				    	    		$(this).addClass('active');
				    	    		
				    	    	}
			    	    		
			    	    	}else{
			    	    		var placeId = $(this).data("placeid");
				    	    	if($.ajax({
				    	    		type: "Post",
				    	    		url: "/UPMap/removeMyPlace",
				    	    		data: "userId="+userId+"&placeId="+placeId,
				    	    		success: function(){
				    	    			getMyPlaces();
					    	    		
				    	    			return true;
				    	    		},
				    	    		error: function(){
				    	    			return false;
				    	    		}
				    	    		}
				    	    	
				    	    			
				    	    	
				    	    	)){
				    	    		$(this).removeClass('active');
				    	    		
				    	    	}
			    	    	}
			    	    	
			    	    	
			    	    	
			    	    	
			    	    	
			    	    	
			    	    	
			    	    	
			    	    });
			    	    
			    
			    	    
			    	    
			    	    $(".category-link").click(function() {
			    	    	var category = "";
			    	    	var placeName = $(this).text();
			    	    	
			    	    	
			    	    	doSearchOptimized(category,placeName);
			    	    	
			    	    	
			    	    });
			    
			    	});
				}
			
			}else{
				document.getElementById('results').innerHTML="<p>Sorry, no results found.</p>";
				return false;
			}
			
			
			
  
			
		},
		error: function(e){
			alert("Error: "+ e);
		}
		
	});
	
}

function showOrHideFeature(){
	if(display==0){
		$("#welcome").fadeIn(250);
	}else{
		$("#welcome").fadeOut(250);
	}
}	

function categoryOnChange(){
	
	var category = $( "#categorySelect option:selected" ).val();
	var placeName = $('#searchPlaceName').val();
	
	autoCompleteCategory = category;
	getAllPlaceNames();
	
	
	if(category=="" && placeName==""){
		
		clearMarkers();
		$("div#results").html("");
		$("div#results").addClass("hidden");
		display=display-1;
		resultsToggle = 0;
		showOrHideFeature();
	}
		
	else
		doSearchOptimized(category,placeName);
	
}


function zoomTo(){
    //console.log(zoomFluid);
    if(zoomFluid==17) return 0;
    else {
         zoomFluid ++;
         map.setZoom(zoomFluid);
         setTimeout("zoomTo()", 500);
    }
}

function zoomOut(){
    //console.log(zoomFluid);
    if(zoomFluid==15) return 0;
    else {
         zoomFluid --;
         map.setZoom(zoomFluid);
         setTimeout("zoomOut()", 500);
    }
}
/*----------------------------------------------------
Object: window
Event: load
Function: initializes the map on window load
------------------------------------------------------*/
google.maps.event.addDomListener(window, 'load', initialize);

function getCategories(){
	
	$.ajax({
		type: "Get",
		url: "/UPMap/getCategories",
		success: function(json){
			categoryList = $.parseJSON(json);
			$("select#categorySelect").append('<option value="">Select a category</option>');
			for(var i=0; i<categoryList.length ; i++){
			
				$("select#categorySelect").append('<option value="' + categoryList[i].categoryId+'">'+categoryList[i].categoryName +'</option>');
			}
			
		},
		error: function(e){
			return null;
		}
	});
}

function searchPlaceClick(){
	
	var category = $( "#categorySelect option:selected" ).val();
	var placeName = $('#searchPlaceName').val();
	if(placeName!="")
	doSearchOptimized(category,placeName);

}

function searchPlaceEnter() {
	
	var category = $( "#categorySelect option:selected" ).val();
	var placeName = $('#searchPlaceName').val();
	
	$( "#searchPlaceName" ).autocomplete( "close" );
	
	if(placeName!="")
		doSearchOptimized(category,placeName);
	
	
}


function showJeepneyRoutes(){
	
		
		if($("#jeepneyRoutes").css("display")!="none"){
			$("#jeepneyRoutes").fadeOut(250);
			visiblePath[4] = 1;
			allRoute();
			display = display - 1;
			resultsToggle = 0;
			showOrHideFeature();
		}else{
			$("#jeepneyRoutes").fadeIn(250);
			display = display + 1;
			showOrHideFeature();
		}
		
	
}


$(document).ready(function(){

	getCategories();
	getAllPlaceNames();
	getMyPlaces();
	updateMyPlaces();
	updateRecentlySearched();
	
	$('.jeepney-places-button').click(
			function(){
				var target = "div"+$(this).attr("href");
				if($(target).hasClass("hidden")){
					$(target).removeClass("hidden");
					//$(target).html("List buildings here");
				}else{
					$(target).addClass("hidden");
					//$(target).html("");
				}
				
				return false;
			}
			
			
	);
	
});


$(document).keyup(function(e){
	
	
   if($('#searchPlaceName').is(':focus')) {
	   
	   
	   var category = $( "#categorySelect option:selected" ).val();
	   var placeName = $('#searchPlaceName').val();

	   if(placeName!=""){
		   
		   if(e.keyCode == 32){
			      
			   doSearchOptimized(category, placeName);
				
		   }else if(e.keyCode==8){
			   clearMarkers();
			   $("div#results").html("");
			   $("div#results").addClass("hidden");
			   display = display - 1;
			   resultsToggle = 0;
		   }
		   
		   
		   
	   }else if(category!=""&&placeName==""){
		   doSearchOptimized(category, placeName);
	   }else if (category==""&&placeName==""){
		   clearMarkers();
		   $("div#results").html("");
		   $("div#results").addClass("hidden");
		   display = display - 1;
		   resultsToggle = 0;
	   }
	   
   }
   
});


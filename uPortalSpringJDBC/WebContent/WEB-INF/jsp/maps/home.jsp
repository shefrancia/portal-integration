<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
  <head>
  	<title>Home | GoUP</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    
    <!--Include Stylesheets -->
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/global.css" />" rel="stylesheet"/>
 
    <!--End Including Stylesheets-->
    
    <!-- Include JS Plugins -->
     

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=geometry&key=AIzaSyCblPnV936VjhXRneHrOKPl_aB1hozPlFU&sensor=false">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/html2canvas.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/map.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.cookie.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/underscore-min.js" />"></script>
  
    <!--End Including JS Plugins-->
 	
 
        
    <script type="text/javascript">
    	 // calling function from here
    	/*-------------------------
    	Function: 	Gets the height of the window screen 
    				and sets it as the height of the map wrapper
    	--------------------------*/
    	function setWrapperHeight(){
    		var height = $(window).innerHeight() - 90;
    		if(height<300)
    			height=300;
    		$("#big-wrapper").css("height",height);
    		$("#map-wrapper").css("height",height);
    		$("#welcome").css("height",height);
    		$("#side-box").css("height",height);
    		$(".feature-panel").css("height",height);
    	}
    	
    	function setWrapperWidth(){
    		
    		var width = screen.availWidth;
    		$("#nav").css("width",width);
    		$("#big-wrapper").css("width",width);
    		$("#side-box").css("width",width * 0.30);    		
    		$("#map-wrapper").css("width",width * 0.70);    		
    		
    		
    	}
    	
    	
    	//Sets map wrapper height when page has loaded
    	$(document).ready(
    			function(){
    				setWrapperWidth();
    				setWrapperHeight();
    				
    				
    				$(".myplaces-tab-button").click(
    						function(){
    							if($(this).hasClass("active")){
    								return false;
    							}else{
    								$(".myplaces-tab-panel").removeClass("active");
    								$(".myplaces-tab-button").removeClass("active");
    								var target= "div"+$(this).data("target");
    								$(target).addClass("active");
    								$(this).addClass("active");
    							}
    						});
    				
    				$('section[data-type="background"]').each(function(){
    				      var $backgroundObj = $(this); // assigning the object
    				      
    				      $(window).scroll(function() {
    				    	  var yPos = -($window.scrollTop() / $backgroundObj.data('speed'));
    				    	  
    				    	// Put together our final background position
    				            var coords = '50% '+ yPos + 'px';
    				    	
    				         // Move the background
    				            $bgobj.css({ backgroundPosition: coords });
    				      });
    				    }); 
    				
    				$('#findPlace').click(function(){
    					$("#searchPlaceName").focus();
    					
    					
    				});
    				
    				
    				$('#screenshot').click(function(){
    					html2canvas($('#map-canvas'), {
  						  proxy: "proxy.js",
  						  useCORS: true,
  						  logging: true, 
  						  onrendered: function(canvas) {
  							var img = canvas.toDataURL();
  							var w;
  							w.location = img;
  							
  							
  						  }
  						});
    					
    				});
    				
    				showOrHideFeature();
    				$('ul.ui-autocomplete').removeAttr('style');
    			    			});
    	
    		
    	//Sets map wrapper height when page has resized
    	$(window).resize(setWrapperHeight); 
    	
    </script>
    
  </head>
  <body>
  	
  	<div id="nav">
  		<a id="goup-logo">
		</a>
		
		<div id="searchForm">
		
			<div class="styled-select">
			
				<select id="categorySelect" onchange="categoryOnChange();">
	  				
	  			</select>
			
			</div>
			
	  		
	  		<input id="searchPlaceName" placeholder="Type the name of the place" type="text" onKeyUp="if (event.keyCode == 13) searchPlaceEnter();"/>
			<a id="searchButton" class="btn" type="button" onclick="searchPlaceClick();"><i class="fa fa-search"></i></a>
		</div>
	  	
	  	<div id="menu">
	  		<div class="icon-title"><a onclick="viewMyPlaces();"><span class="menu-icon icon-myplaces"></span>My Places</a></div>
	  		<div class="icon-title"><a onclick="viewGetDirections();"><span class="menu-icon icon-directions"></span>Get Directions</a></div>
	  		<div class="icon-title"><a onclick="showJeepneyRoutes();"><span class="menu-icon icon-jeepney"></span>Jeepney Routes</a></div>
	  		<br />
	  		<div class="icon-title"><a id="screenshot"><span class="menu-icon icon-screenshot"></span>Screenshot</a></div>
	  		<div class="icon-title"><a><span class="menu-icon icon-help"></span>Help</a></div>
	  		<div class="icon-title"><a href="home"><span class="menu-icon"></span>uPortal</a></div>
	  	
	  	</div>
	  					
	  					
	  					
	  				
	  					
	  			
  	</div>

	<div id="big-wrapper">
	
	<!-- begin of map-wrapper -->
	<div id="side-box">
		
	  		
	  			<%
	  			
	  			if(request.getAttribute("message")!=null) {
	  				out.print(" <div class=\"alert alert-success alert-dismissable\">");
	  				out.print("<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>");
	  				out.print(request.getAttribute("message"));
	  				out.print("</div>");
	  			}
	  			%>

	  			

	  			<div id="welcome"style="display:none;">
	  				<section id="one" class="feature-panel" data-type="background" data-speed="10">
	  					<div class="feature-text">
	  						<div class="feature-title">Welcome to Go UP!</div>
	  						<div class="feature-tagline">A University of the Philippines Diliman Online Map</div>
	  					</div>
	  					<div class="arrow-text">Scroll Down To See More</div>
	  					<a class="arrow"></a>

	  					
	  				</section>
	  			
	  			
	  				<section id="two" class="feature-panel" data-type="background" data-speed="10">
	  					<div class="feature-text">
		  					<div class="feature-title">Find Places in UP Diliman</div>
		  					<div class="feature-tagline">GoUP makes searching places 
		  					in the campus better and faster 
		  					with its optimized categorized
		  					search.</div>
	  					</div>
	  					<div id="findPlace" class="feature-button">Find a Place</div>
	  				</section>
	  				
	  				<section id="three" class="feature-panel" data-type="background" data-speed="10">
	  					<div class="feature-text">
		  					<div class="feature-title">Get Directions</div>
		  					<div class="feature-tagline">GoUP helps you to get travel directions
							,in the campus,from one location to another including
							info about travel time and modes of
							transportation.</div>
	  					</div>
	  				</section>
	  				
	  				<section id="four" class="feature-panel" data-type="background" data-speed="10">
	  					<div class="feature-text">
		  					<div class="feature-title">Save Your Favorite Places</div>
		  					<div class="feature-tagline">GoUP lets its users to save their favorite places
		  					using the yellow stars, making it easier to locate these places.</div>
	  					</div>
	  				</section>
	  			</div>
	  			
				<div id = "getDirections" style="display:none;">
		  			<form id="findPath" onkeypress="return event.keyCode != 13;">
		  				<b style="font-size:20px;">Get Directions</b>
		  				<input id="searchOriginPlaceName" class="search-input" placeholder="Where are you now?" type="text" />
		  				<input id="searchDestinationPlaceName" class="search-input" placeholder="Where are you going?" type="text"/>
		  				<input id="searchPathButton" class="btn btn-primary" type="button" value="Get Directions" onclick="path();" />
		  			</form>
		  			
		  			<div id="routes">
	  			
	  				</div>
	  				
	  				<div id = "routelength">
	  				
	  				</div>
		  			
	  			</div>
	  			
	  			
	  	

	  			<div id="results" style="display:none;">
	  			
	  			</div>

	  			
	  			<div id="jeepneyRoutes" style="display:none;">
	  			
	  			
	  				<b style="font-size:20px;">Jeepney Routes</b>
	  				
						<div class="jeepney-toggle-wrapper">
							<a class="btn-route btn-ikot" onclick="ikotRoute();">UP Ikot</a>
							<a href="#ikot-route-places" class="jeepney-places-button fa fa-angle-down"></a>
						</div>
						
						<div id="ikot-route-places" class="jeepney-and-places hidden">
							Virata Hall - Institute of Small Scale Industries (ISSI) <br />
							New LRT <br />
							Albert Hall <br />
							Bartlett Hall (Fine Arts) <br />
							Village A <br />
							Village B <br />
							Hardin ng Doña Aurora Walk - UP Housing <br />
							Kamagong Residence Hall <br />
							Engineering Centennial Dorm <br />
							Barangay Krus Na Ligas <br />
							Credit Union <br />
							National Institute of Geological Sciences (NIGS) <br />
							Alumni Engineers Centennial Building (Engineering Library 2 / DCS)<br />
							College of Science Library and Administration Bldg. (CSLab)
							Electrical & Electronics Engineering Bldg. 1&2<br />
							Marine Science Institute (MSI)<br />
							Science Teacher Training Center<br />
							Natural Sciences Research Institute (NSRI) Miranda Hall (College Of Science)<br />
							Vidal Tan Hall (NISMED)<br />
							ITDC<br />
							Palma Hall (AS) <br />
							Pavilion 1 - Institute of Chemistry <br />
							Pavilion 2 - Institute of Physics <br />
							Casaa Food Center <br />
							Kamia Residence Hall <br />
							Pavilion 3 - Institute of Biology <br />
							Sampaguita Residence Hall <br />
							Zoology Building <br />
							CHE Craft And Design Laboratory (CDL) <br />
							UP Integrated School (UPIS) <br />
							Solidor Hall<br />
							Benton Hall<br />
							Benitez Hall (Education)<br />
							Vinzons Hall<br />
							College of Business Administration<br />
							School of Economics<br />
							Malcolm Hall (Law)<br />
							Romulo Hall (Asian Center & Institute of Islamic Studies)<br />
							Bocobo Hall (Law Library)<br />
							Mang Laris (Isaw place)<br />
							International Center<br />
							Swimming Pool<br />
							Ilang-Ilang Residence Hall<br />
							UP Health Service<br />
							Parish of The Holy Sacrifice<br />
							Church of the Risen Lord<br />
							Shopping Center (SC)<br />
							Cooperative Grocery<br />
							Area 2<br />
							UP Post Office<br />
							Kalayaan Residence Hall<br />
							Yakal Residence Hall <br />
							Molave Residence Hall<br />
							UP Employees Housing Cooperative (UPEHCO)<br />
							Film Institute <br />
							Ang Bahay ng Alumni (TBA)<br />
							Fonacier Hall (Alumni Center)<br />
							College of Music Annex<br />
							UP Center For Women's Studies<br />							
							College of Social Work & Community Development Complex<br />
							Archery Range<br />
							DMST Complex (SURP/Rappel Tower)<br />
							CHK Gym<br />
							School of Urban and Regional Planning (SURP)<br />
							Bonifacio Hall - School of Labor and Industrial Relation (SOLAIR)<br />
							
						</div>
						
						
						<div class="jeepney-toggle-wrapper">
							<a class="btn-route btn-toki" onclick="tokiRoute();">UP Toki</a>
							<a href="#toki-route-places" class="jeepney-places-button fa fa-angle-down"></a>
						
						</div>
						
						<div id="toki-route-places" class="jeepney-and-places hidden">
							Virata Hall - Institute of Small Scale Industries (ISSI) <br />
							Bonifacio Hall - School of Labor and Industrial Relation (SOLAIR)<br />
							School of Urban and Regional Planning (SURP)<br />
							CHK Gym<br />
							DMST Complex (SURP/Rappel Tower)<br />
							Archery Range<br />
							College of Social Work & Community Development Complex<br />
							UP Center For Women's Studies<br />
							Alberto Hall - College of Music<br />
							Dance Studio<br />
							Plaridel Hall - Mass Communication<br />
							Quezon Hall - Oble<br />
							Vargas Musuem<br />
							Faculty Center<br />
							Palma Hall(AS)<br />
							Melchor Hall - College of Enggineering<br />
							Tennis Court<br />
							UP Employees Housing Cooperative (UPEHCO)<br />
							Molave Residence Hall<br />
							Yakal Residence Hall <br />
							UP Post Office<br />
							Area 2<br />
							Shopping Center (SC)<br />
							Cooperative Grocery<br />
							Kalayaan Residence Hall<br />
							Parish of The Holy Sacrifice<br />
							Church of the Risen Lord<br />
							UP Health Service<br />
							Ilang-Ilang Residence Hall<br />
							Swimming Pool<br />
							International Center<br />
							Isaw Place<br />
							Bocobo Hall (Law Library)<br />
							Romulo Hall (Asian Center & Institute of Islamic Studies)<br />
							Malcolm Hall (Law)<br />
							National Engineering Center<br />
							Benton Hall (FAN)<br />
							Solidor Hall<br />
							Benitez Hall (Education)<br />
							Vinzons Hall<br />
							Lorena Barros Hall<br />
							Narra Residence Hall<br />
							CSSP Faculty Building<br />
							UP Integrated School (UPIS)<br />
							Alonso Hall (Home Economics Complex)<br />
							Proposed NIMBB (College of Science)<br />
							Weather Bureau (Pagasa)<br />
							Institute of Chemistry Building (College of Science)<br />
							National Inst. of Physics (NIP) Bldg<br />
							UP Technology Park (Technology Business Incubator)<br />
							Advanced Science & Technology Institute (ASTI) Bldg.<br />
							Institute of Mathematics Bldg. (College of Science)<br />
							National Institute of Geological Sciences (NIGS)<br />
							Alumni Engineers Centennial Building (Engineering Library 2 / DCS)<br />
							College of Science Library and Administration Bldg. (CSLab)
							Electrical & Electronics Engineering Bldg. 1&2<br />
							Marine Science Institute (MSI)<br />
							Science Teacher Training Center<br />
							Natural Sciences Research Institute (NSRI) Miranda Hall (College Of Science)<br />
							Vidal Tan Hall (NISMED)<br />
							ITDC<br />
							Office of the University Registrar & Office of Admissions (OUR)<br />
							PAUW Day Care / Children's Playground<br />
							College of Architecture Bldg 1 & 2<br />
							University Police/ Fire Department<br />
							University Press<br />
							Coral Bldg. Office of Campus Architect (OCA)<br />
							Villadolid Hall (Archaeological Studies Program)<br />
							Albert Hall<br />
							Seaweed Building (MBB)<br />
							Supply and Property Management Office (SPMO Diliman)<br />
							New LRT<br />
						</div>
						
						<div class="jeepney-toggle-wrapper">
							<a class="btn-route btn-katip" onclick="katipRoute();">Katipunan-UP</a>
							<a href="#katip-route-places" class="jeepney-places-button fa fa-angle-down"></a>
						</div>
						
						<div id="katip-route-places" class="jeepney-and-places hidden">
							GT Toyota - Asian Center Building<br />
							Romulo Hall (Asian Center & Institute of Islamic Studies)<br />
							Bocobo Hall (Law Library)<br />
							Mang Laris (Isaw place)<br />
							International Center<br />
							Swimming Pool<br />
							Ilang-Ilang Residence Hall<br />
							UP Health Service<br />
							Parish of The Holy Sacrifice<br />
							Church of the Risen Lord<br />
							Shopping Center (SC)<br />
							Cooperative Grocery<br />
							Area 2<br />
							UP Post Office<br />
							Kalayaan Residence Hall<br />
							Yakal Residence Hall <br />
							Molave Residence Hall<br />
							UP Employees Housing Cooperative (UPEHCO)<br />
							Film Institute <br />
							Ang Bahay ng Alumni (TBA)<br />
							Fonacier Hall (Alumni Center)<br />
							College of Music Annex<br />
							UP Center For Women's Studies<br />
							Alberto Hall - College of Music<br />
							Dance Studio<br />
							Plaridel Hall - Mass Communication<br />
							Quezon Hall - Oble<br />
							Vargas Musuem<br />
							Faculty Center<br />
							Palma Hall(AS)<br />
							Benton Hall (FAN)<br />
							Solidor Hall<br />
							Benitez Hall (Education)<br />
							Vinzons Hall<br />
							College of Business Administration<br />
							School of Economics<br />
							Malcolm Hall (Law)<br />
						</div>
						
						<div class="jeepney-toggle-wrapper">
							<a class="btn-route btn-philcoa" onclick="philcRoute();">Philcoa-UP</a>
							<a href="#philcoa-route-places" class="jeepney-places-button fa fa-angle-down"></a>
						</div>
						
						<div id="philcoa-route-places" class="jeepney-and-places hidden">
							Quezon Hall - Oble<br />
							Vargas Musuem<br />
							Faculty Center<br />
							Palma Hall(AS)<br />
							Benton Hall (FAN)<br />
							Solidor Hall<br />
							Benitez Hall (Education)<br />
							Vinzons Hall<br />
							College of Business Administration<br />
							School of Economics<br />
							Malcolm Hall (Law)<br />
							Romulo Hall (Asian Center & Institute of Islamic Studies)<br />
							Bocobo Hall (Law Library)<br />
							Mang Laris (Isaw place)<br />
							International Center<br />
							Swimming Pool<br />
							Ilang-Ilang Residence Hall<br />
							UP Health Service<br />
							Parish of The Holy Sacrifice<br />
							Church of the Risen Lord<br />
							Shopping Center (SC)<br />
							Cooperative Grocery<br />
							Area 2<br />
							UP Post Office<br />
							Kalayaan Residence Hall<br />
							Yakal Residence Hall <br />
							Molave Residence Hall<br />
							UP Employees Housing Cooperative (UPEHCO)<br />
							Tennis Court<br />
							Melchor Hall - College of Enggineering<br />
							Carillon (Andres Bonifacio Centennial Hall)<br />
							Villamor Hall (UP Theater)<br />
							Abelardo Hall (Music)<br />
							Plaridel Hall (Mass Communication)<br />
							UP Wet Market <br />
							UP - Ayala Techno Hub <br />
							
						</div>
						
						<div class="jeepney-toggle-wrapper">
							<a class="btn-route" onclick="allRoute();">Show All</a>
						</div>
						
			
	  			
	  			</div>
	  			
	  			<div id="myPlaces" style="display:none;">
	  				<b style="font-size:20px;">My Places</b>
	  				<div class="myplaces-tab">
	  				<div class="myplaces-tab-button active" data-target="#favorites">Favorites</div>
	  				<div class="myplaces-tab-button" data-target="#recent">Recent</div>
	  				</div>
	  				<div id ="favorites" class="myplaces-tab-panel active">
	  				</div>
	  				<div id ="recent" class="myplaces-tab-panel">
	  				</div>
	  				
	  			</div>
	  			
	  			
	  			
	  			
	  			
	  			
	  			
	  			
	  			
	  			
	  		
  		</div>

	<div id="map-wrapper">
	

		<div id="map-canvas" >
    	</div>
		
  		
  
    	
    	
    
    </div>
    <!-- end of map wrapper -->
    </div>

    
  </body>
</html>



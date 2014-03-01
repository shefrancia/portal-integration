<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	 
<t:genericpage title="Home">
	<div class="banner">
	    <h1 class="banner-head">
	        <span style= "padding-bottom: -10px;">uPortal</span><br>
	        <span style="font-size: 40px;">The Growing Portal.</span> <br>
	        <a href="register" title="register now"><button class="pure-button" id="getstarted">Get started <i class="fa fa-angle-double-right"></i></button></a>
	    </h1>
	</div>
	<div class="cont-div">
		<div class="pure-g-r">
			<div class="apps-desc-div">
				<div class="pure-u-1-3" style="font-size: 45px;">
					<i class="fa fa-github-alt fa-5x"></i>
				</div> 
				<div class="pure-u-2-3">
					<h3>Online Classroom</h3>
					<p id="apps-desc">App that lets you collaborate with your professor and classmates online! Come on and have your class online!</p>
					<div class="vis-site">
						<c:if test="${username != null}">
							<a href="#" title="visit Online Classroom">visit site <i class="fa fa-arrow-right"></i></a>
						</c:if>
						<c:if test="${username == null}">
							<span class="vis-siteNL">visit site <i class="fa fa-arrow-right"></i></span>
						</c:if>
					</div>
				</div>
			</div>
			
			<div class="apps-desc-div">
				<div class="pure-u-2-3">
					<h3>UP Map</h3>
					<p id="apps-desc">Not yet familiar with the whereabouts of different places in UP Diliman? Try this app! Surely, it will help you how to go there as fast as possible!</p>
					<div class="vis-site">
						<a href="map" title="visit UP Map">visit site <i class="fa fa-arrow-right"></i></a>
					</div>
				</div> 
				<div class="pure-u-1-3" style="font-size: 45px;">
					<i class="fa fa-linux fa-5x" style="float:right"></i>
				</div>
			</div> 
			
			
			<div class="apps-desc-div">
				<div class="pure-u-1-3" style="font-size: 45px;">
					<i class="fa fa-twitter fa-5x"></i>
				</div> 
				<div class="pure-u-2-3">
					<h3>Brain Gym</h3>
					<p id="apps-desc">We know that you are genius! Want to test your genius right now?</p>
					<div class="vis-site">
						<c:if test="${username != null}">
							<a href="#" title="visit Brain Gym">visit site <i class="fa fa-arrow-right"></i></a>
						</c:if>
						<c:if test="${username == null}">
							<span class="vis-siteNL">visit site <i class="fa fa-arrow-right"></i></span>
						</c:if>
					</div>
				</div>
			</div>
			
			<div class="pure-u-2-3">
				<h3>Study Buddy</h3>
				<p id="apps-desc">Having a hard time managing your study life with the many luring stuff meddling upon your studies? Study Buddy is your best friend!</p>
				<div class="vis-site">
					<a href="#" title="visit Study Buddy">visit site <i class="fa fa-arrow-right"></i></a>
				</div>
			</div> 
			<div class="pure-u-1-3" style="font-size: 45px; margin-bottom: 80px;">
				<i class="fa fa-apple fa-5x" style="float:right"></i>
			</div> 
		</div>		
	</div>
	
	<div class="about-us">
		<h2 style="text-align: center; padding: 17px;">About Us</h2>
		<div class="cont-div">
			<div class="pure-g-r" style="text-align: center;">
				<div class="pure-u-1-3">
					<h4>Sherlyne Francia</h4>
					<img src=<c:url value="/resources/imgs/troll1.png"/> width="250" height="250">
					<p id="about-indiv">Blah blah blah. Something about Sherlyne Francia. Lala lala lala</p>
				</div>
				<div class="pure-u-1-3">
					<h4>Denise Alyssa Francisco</h4>
					<img src=<c:url value="/resources/imgs/troll2.png"/> width="250" height="250">
					<p id="about-indiv">Blah blah blah. Something about Denise Alyssa Francisco. Lala lala lala</p>
				</div>
				<div class="pure-u-1-3">
					<h4>Mark Paolo Navata</h4>
					<img src=<c:url value="/resources/imgs/troll3.png"/> width="250" height="250">
					<p id="about-indiv">Blah blah blah. Something about Mark Paolo Navata. Lala lala lala</p>
				</div>
				<div class="pure-u-1-3">
					<h4>Joshua Frank Rayo</h4>
					<img src=<c:url value="/resources/imgs/troll4.png"/> width="250" height="250">
					<p id="about-indiv">Blah blah blah. Something about Joshua Frank Rayo. Lala lala lala</p>
				</div>
				<div class="pure-u-1-3">
					<h4>Erwin Sanchez</h4>
					<img src=<c:url value="/resources/imgs/troll5.png"/> width="250" height="250">
					<p id="about-indiv">Blah blah blah. Something about Erwin Sanchez. Lala lala lala</p>
				</div>
			</div>
		</div>
	</div>
	
	<div class="footer l-box">
	    <div class="pure-g-r">
	    	<div class="pure-u-1-6">
	    		<p>hits: ${homePageCounter}</p>
	    	</div>
	    	<div class="pure-u-2-3">
	    		<p>&copy; Kompyuter Saiyans 2013</p>
	    	</div>
	    </div>
	</div>
</t:genericpage>
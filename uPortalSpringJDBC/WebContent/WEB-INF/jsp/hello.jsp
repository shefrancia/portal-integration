<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:userpage title="Welcome">
	<div class="pbanner" >
		<div class="pure-g-r" id="pcont-div">
			<div id="prof-pic" class="pure-u-2-5">
				<img src=<c:url value="/resources/imgs/cat.gif"/>>
			</div>
			<div class="pure-u-2-3" id="pinfo" style="font-family: 'Istok Web', sans-serif;">
				<div class="name" >
					<h1>${user.getFirstName()} ${user.getLastName()}</h1>
				</div>
				<div class="details " id="det">
					<div class="info">Username: ${user.getUsername()}</div>
					<div class="info">Email: ${user.getEmail()}</div>
					<div class="info">
						Role: <c:forEach var="i" begin="0" end="${roles.size()-1}"> ${roles.get(i)} </c:forEach>
					</div>
					<c:if test="${college != null }">
						<div class="info">College: ${college}</div>
					</c:if>
					<c:if test="${department != null}">
						<div class="info">Department: ${department}</div>
					</c:if>
					<c:if test="${course != null}">
						<div class="info">Course: ${course}</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="pure-g-r" id="prof-links">
		<div class="pure-u-1-4" id="profile-buttons">
			<a  href="map" title="visit UP Map"><button class="pure-button"><i class="fa fa-laptop"></i><br>UP Map</button></a>
		</div>
		<div class="pure-u-1-4" id="profile-buttons">
			<a href="#" title="visit Study Buddy"><button class="pure-button"><i class="fa fa-money"></i><br>Study Buddy</button></a>
		</div>
		<div class="pure-u-1-4" id="profile-buttons">
			<c:if test="${college == 'College of Engineering' || college == 'College of Science' || roles.indexOf('GOD') >= 0}">
				<a href="#" title="visit Brain Gym"><button class="pure-button"><i class="fa fa-youtube-play"></i><br>Brain Gym</button></a>
			</c:if>
			<c:if test="${college != 'College of Engineering' && college != 'College of Science' && roles.indexOf('GOD') < 0}">
				<button  class="pure-button" title="available to College of Engineering and Science students only" disabled><i class="fa fa-youtube-play"></i><br>Brain Gym</button>
			</c:if>
		</div>
		<div class="pure-u-1-4" id="profile-buttons">
			<c:if test="${department == 'Department of Computer Science' ||  roles.indexOf('GOD') >= 0}">
				<a href="#" title="visit Online Classroom"><button class="pure-button"><i class="fa fa-cut"></i><br>Classroom</button></a>
			</c:if>
			<c:if test="${department != 'Department of Computer Science' &&  roles.indexOf('GOD') < 0}">
				<button class="pure-button" title="available to DCS students only" disabled><i class="fa fa-cut"></i><br>Classroom</button>
			</c:if>
		</div>
	</div>
	<c:if test="${roles.indexOf('GOD') < 0}">
		<div align="center">
			<a href="request">Request to be an admin</a>
		</div>
	</c:if>
</t:userpage>
	
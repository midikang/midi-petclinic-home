<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:url value="/resources/images/banner-graphic.png" var="banner"/>
<img src="${banner }"/>

<div class="navbar" style="width:601px;">
	<div class="navbar-inner">
		<ul>
			<li>
				<a href="<spring:url value="/" htmlEscape="true"/>">Home</a>
			</li>
			<li>
				<a href="<spring:url value="/owners/find.html" htmlEscape="true"/>">Find owners</a>
			</li>
			<li>
				<a href="<spring:url value="/vets.html" htmlEscape="true"/>">Veterinarians</a>
			</li>
			<li>
				<a href="<spring:url value="/oups.html" htmlEscape="true"/>">Error</a>
			</li>
		</ul>
	</div>
</div>

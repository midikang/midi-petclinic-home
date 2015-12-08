<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<jsp:include page="./fragments/staticFiles.jsp"/>
	<title>PetClinic</title>
</head>
<body>
	
	<div class="container">
		<jsp:include page="./fragments/bodyHeader.jsp"/>
	
		<h1>Welcome to Spring PetClinc demo</h1>
	
		<spring:url value="/resources/images/pets.png" var="pets"/>
		<img alt="Pets" src="${pets}">
	
		<jsp:include page="./fragments/footer.jsp"/>
	
	</div>

</body>
</html>
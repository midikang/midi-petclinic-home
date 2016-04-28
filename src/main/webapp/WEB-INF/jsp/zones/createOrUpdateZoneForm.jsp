<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<jsp:include page="../fragments/staticFiles.jsp"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Create Or Update Zone</title>
	</head>
	<body>
		
		<div class="container">
			<div>
				<jsp:include page="../fragments/bodyHeader.jsp"/>
				
				<c:choose>
					<c:when test="${zone['new']}">
						<c:set var="method" value="post"/>
					</c:when>
					<c:otherwise>
						<c:set var="method" value="put"/>
					</c:otherwise>
				</c:choose>
				
			</div>
		
			<div>
				<h2><c:if test="${zone['new']}">New </c:if>Zone</h2>
				
				
				<form:form modelAttribute="zone" method="${method}" class="form-horizontal" id="add-zone-form">
					<petclinic:inputField label="Enterprise" name="enterprise"/>
					<petclinic:inputField label="Node" name="node"/>
					<petclinic:inputField label="Description" name="description"/>
					<c:choose>
						<c:when test="${zone['new']}">
							<button type="submit">Add Zone</button>
						</c:when>
						<c:otherwise>
							<button type="submit">Update Zone</button>
						</c:otherwise>
					</c:choose>
				
				</form:form>
				
				
			</div>
			
			<div>
				<jsp:include page="../fragments/footer.jsp"/>
			</div>
		
		</div>
	
	
	</body>
</html>
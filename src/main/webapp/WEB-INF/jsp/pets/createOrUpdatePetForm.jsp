<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<html>
	<jsp:include page="../fragments/staticFiles.jsp"/>

	<body>
		<script type="text/javascript">
			$(function () {
				$("#birthDate").datepicker({dateFormat: 'yy/mm/dd'});
			});
		</script>
	
		<div class="container">
			<jsp:include page="../fragments/bodyHeader.jsp"/>
			<c:choose>
				<c:when test="${pet['new']}">
					<c:set var="method" value="post" />
				</c:when>
				<c:otherwise>
					<c:set var="method" value="put"/>
				</c:otherwise>
			</c:choose>
			
			<h2>
				<c:if test="${pet['new']}">New </c:if>Pet
			</h2>
			
			<form:form modelAttribute="pet" method="${method}" class="form-horizontal">
				<dir class="control-group" id="owner">
					<label class="control-label">Owner </label>
					<c:out value="${pet.owner.firstName } ${pet.owner.lastName }"></c:out>
				</dir>
				<petclinic:inputField label="Name" name="name"/>
				<petclinic:inputField label="Birth Date" name="birthDate"/>
				<div class="control-group">
					<petclinic:selectField label="Type" name="type" size="5" names="${types}"/>
				</div>
				<div class="form-action">
					<c:choose>
						<c:when test="${pet['new']}">
							<button type="submit">Add Pet</button>
						</c:when>
						<c:otherwise>
							<button type="submit">Update Pet</button>
						</c:otherwise>
					</c:choose>
				</div>
				
				
			</form:form>
			
		</div>
	
	
	</body>
</html>










<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<jsp:include page="../fragments/staticFiles.jsp"/>
	<body>
		<div class="container">
			<div>
				<jsp:include page="../fragments/bodyHeader.jsp"/>
			</div>
			<div>
				<h2>Find Owner</h2>
				<spring:url value="/owners.html" var="formUrl"/>
				<form:form modelAttribute="owner" action="${fn:escapeXml(formUrl)}"  method="get" class="form-horizontal" id="find-owner-form">
					<div>
						<label>Last Name</label>
						<form:input path="lastName"/>
						<form:errors path="*"/>
					</div>
					<div>
						<button type="submit">Find Owner</button>
					</div>

				</form:form>
				<br/>

				<spring:url value="/owners/new" var="newUrl" htmlEscape="true"/>
				<a href="${newUrl}">Add Owner</a>
			</div>

			<div>
				<jsp:include page="../fragments/footer.jsp"/>
			</div>

		</div>


	</body>
</html>

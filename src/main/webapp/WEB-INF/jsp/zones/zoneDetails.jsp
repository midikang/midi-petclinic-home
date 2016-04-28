<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />

		<h2>Zone Information</h2>

		<table class="table table-striped" style="width: 600px;">
			
			<tr>
				<th>Enterprise</th>
				<td><c:out value="${zone.enterprise}" /></td>
			</tr>
			<tr>
				<th>Node</th>
				<td><c:out value="${zone.node}" /></td>
			</tr>
			<tr>
				<th>Description</th>
				<td><c:out value="${zone.description}" /></td>
			</tr>
			<tr>
				<td><spring:url value="{zoneId}/edit.html" var="editUrl">
						<spring:param name="zoneId" value="${zone.id}" />
					</spring:url> <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit
						Zone</a></td>
			</tr>

		</table>

		<jsp:include page="../fragments/footer.jsp" />

	</div>

</body>

</html>

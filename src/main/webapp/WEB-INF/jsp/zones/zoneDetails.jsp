<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				<th>Zone Name</th>
				<td><c:out value="${zone.zoneName}" /></td>
			</tr>
			<tr>
				<th>Description</th>
				<td><c:out value="${zone.description}" /></td>
			</tr>
			<tr>
				<th>Track Inventory</th>
				<td><form:checkbox path="zone.trackInventory"/></td>
			</tr>
			<tr>
				<td><spring:url value="{zoneId}/edit.html" var="editUrl">
						<spring:param name="zoneId" value="${zone.id}" />
					</spring:url> <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit
						Zone</a></td>
				<td>
					<spring:url value="{zoneId}/locations/new.html" var="addUrl">
						<spring:param name="zoneId" value="${zone.id}"></spring:param>
					</spring:url>
					<a href="${fn:escapeXml(addUrl)}" class="btn btn-success">Add New Location</a>
				</td>						
			</tr>

		</table>

		<h2>Locations</h2>
			<table class="table" style="width:600px;">
				<tr>
					<th>Enterprise</th>
					<th>Node</th>
					<th>Location Barcode</th>
					<th>Description</th>
				</tr>
				<c:forEach var="location" items="${zone.locations}">
						<tr>
							<td><c:out value="${location.enterprise}"/></td>
							<td><c:out value="${location.node}"/></td>
							<td><c:out value="${location.locationBarcode}"/></td>
							<td><c:out value="${location.description}"/></td>
						</tr>
				</c:forEach>
			</table>
		
		<jsp:include page="../fragments/footer.jsp" />

	</div>

</body>

</html>

<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>

<html lang="en">
  <jsp:include page="../fragments/staticFiles.jsp"/>
  <div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2>Owners</h2>
	<datatables:table id="owners" data="${selections}" row="owner"
		theme="bootstrap2">
		<datatables:column title="Name" display="html">
			<spring:url value="/owners/{ownerId}.html" var="ownerUrl">
				<spring:param name="ownerId" value="${owner.id}" />
			</spring:url>
			<a href="${fn:escapeXml(ownerUrl)}"> <c:out
					value="${owner.firstName}" /> <c:out value="${owner.lastName}" />
			</a>
		</datatables:column>
		<datatables:column title="Address" property="address"/>
		<datatables:column title="City" property="city"/>
		<datatables:column title="Telephone" property="telephone"/>
		<datatables:column title="Pets">
			<c:forEach var="pet" items="${owner.pets}">
				<c:out value="${pet.name}"/>
			</c:forEach>
		</datatables:column>
		<datatables:export type="pdf"/>
	</datatables:table>
	<jsp:include page="../fragments/footer.jsp"/>
  </div>


</html>

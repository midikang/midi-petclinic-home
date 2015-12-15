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
    <h2>Vets</h2>
	<datatables:table id="vets" data="${vets.vetList}" row="vet"
		theme="bootstrap2" cssClass="table table-stripped" pageable="false"
		info="false">
		<datatables:column title="Name" display="html">
			<c:out
					value="${vet.firstName}" /> <c:out value="${vet.lastName}" />
		</datatables:column>
	</datatables:table>
	<div></div>
	<jsp:include page="../fragments/footer.jsp"/>
  </div>
  <table>
  	<tr>
  		<td>
  			<a href="<spring:url value="/vets.xml" htmlEscape="true"/>">View as XML</a>
  		</td>
  		<td>
  			<a href="<spring:url value="/vets.xml" htmlEscape="true"/>">View as JSON</a>
  		</td>
  	</tr>
  </table>


</html>

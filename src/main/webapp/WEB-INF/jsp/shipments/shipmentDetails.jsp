<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Shipment Information</h2>

    <table class="table table-striped" style="width:600px;">
    	<tr>
            <th>Shipment No</th>
            <td><c:out value="${shipment.shipmentNo}"/></td>
        </tr>
        <tr>
            <th>Customer Name</th>
            <td><b><c:out value="${shipment.customerName}"/></b></td>
        </tr>
        <tr>
            <td> 
            	<spring:url value="{shipmentId}/edit.html" var="editUrl">
                    <spring:param name="shipmentId" value="${shipment.id}"/>
                </spring:url>
                <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit Shipment</a></td>
        </tr>
    </table>

    <jsp:include page="../fragments/footer.jsp"/>

</div>

</body>

</html>

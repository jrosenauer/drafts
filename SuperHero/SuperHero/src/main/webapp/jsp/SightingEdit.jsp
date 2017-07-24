<%-- 
    Document   : SightingEdit
    Created on : Jul 20, 2017, 2:29:27 AM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sighting</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <jsp:include page="NavigationBar.jsp"/>
            <br/>              
            <sf:form class="form-horizontal" role="form" modelAttribute="sighting" action="editSighting" method="POST">

                <div class="form-group">
                    <label for="add-sighting-date" class="col-md-4 control-label">Date </label>
                    <div class="col-md-8">
                        <sf:input type="hidden" class="form-control" id="sightingID" path="sightingID"/>
                        <sf:input type="text" class="form-control" id="add-sighting-date" path="sightingDate" placeholder="Enter Date"/>
                        <sf:errors path="sightingDate" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="location-selector" class="col-md-4 control-label">Location</label>
                        <div class="col-md-4">
                            <select id="location-selector" name="locationID">
                            <c:forEach var="loc" items="${locationList}">
                                <option value="${loc.locationID}">${loc.locationName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="super-selector" class="col-md-4 control-label">Superhero</label>
                    <div class="col-md-8">
                        <select id="super-selector" name="superID">
                            <c:forEach var="sup" items="${superList}">
                                <option value="${sup.superID}">${sup.superName}</option>
                            </c:forEach> 
                        </select>
                    </div>
                </div>                   

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Sighting"/>
                    </div>
                </div>
            </sf:form>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
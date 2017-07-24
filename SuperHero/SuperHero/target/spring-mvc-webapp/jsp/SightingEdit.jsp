<%-- 
    Document   : SightingEdit
    Created on : Jul 20, 2017, 2:29:27 AM
    Author     : apprentice
--%>

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
                        <sf:input type="text" class="form-control" id="add-sighting-date" path="sightingDate" placeholder="Enter Date"/>
                        <sf:errors path="sightingDate" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="location-selector" class="col-md-4 control-label">Location</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="location-selector" path="location.locationName" placeholder="Enter Location"/>
                        <sf:errors path="location.locationName" cssclass="error"></sf:errors>
                        </div>
                    </div>   
                        
                    <div class="form-group">
                        <label for="add-sighting-supers" class="col-md-4 control-label">Superhero</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-sighting-supers" path="superID" placeholder="Enter Superhero"/>
                        <sf:errors path="superID" cssclass="error"></sf:errors>
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
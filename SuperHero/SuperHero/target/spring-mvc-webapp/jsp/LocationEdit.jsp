<%-- 
    Document   : locationEdit
    Created on : Jul 14, 2017, 4:46:53 PM
    Author     : apprentice
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Location</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <jsp:include page="NavigationBar.jsp"/>
            <br/>    
    <sf:form class="form-horizontal" role="form" modelAttribute="location" action="editLocation" method="POST">
        <div class="form-group">
            <label for="add-location-name" class="col-md-4 control-label">Name </label>
            <div class="col-md-8">
                <sf:input type="text" class="form-control" id="add-location-name" path="locationName" placeholder="Enter Name"/>
                <sf:errors path="locationName" cssclass="error"></sf:errors>
            </div>
        </div>
        
        <div class="form-group">
            <label for="add-location-description" class="col-md-4 control-label">Description</label>
            <div class="col-md-8">
                <sf:input type="text" class="form-control" id="add-location-description" path="locationDescription" placeholder="Enter Description"/>
                <sf:errors path="locationDescription" cssclass="error"></sf:errors>
            </div>
        </div>                          
        <div class="form-group">
            <label for="add-location-address" class="col-md-4 control-label">Address</label>
            <div class="col-md-8">
                <sf:input type="text" class="form-control" id="add-location-address" path="locationAddress" placeholder="Enter Address"/>
                <sf:errors path="locationAddress" cssclass="error"></sf:errors>

            </div>
        </div>                          
        <div class="form-group">
            <label for="add-location-longitude" class="col-md-4 control-label">Longitude</label>
            <div class="col-md-8">
                <sf:input type="text" class="form-control" id="add-location-longitude" path="locationLongitude" placeholder="Enter Longitude"/>
                <sf:errors path="locationLongitude" cssclass="error"></sf:errors>

            </div>
        </div>
        <div class="form-group">
            <label for="add-location-latitude" class="col-md-4 control-label">Longitude</label>
            <div class="col-md-8">
                <sf:input type="text" class="form-control" id="add-location-latitude" path="locationLatitude" placeholder="Enter Latitude"/>
                <sf:errors path="locationLatitude" cssclass="error"></sf:errors>
                <sf:hidden path="locationID"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-4 col-md-8">
                <input type="submit" class="btn btn-default" value="Update Location"/>
            </div>
        </div>
    </sf:form>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
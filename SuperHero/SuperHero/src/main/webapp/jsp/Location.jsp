<%-- 
    Document   : location
    Created on : Jul 14, 2017, 2:46:59 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            <div class="row">
                <div class="col-md-6">
                    <h2>Locations</h2>
                    <table id="locationTable" class="table table-hover">
                        <tr>
                            <th width="30%">Name</th>
                            <th width="50%">Description</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr> 
                        <c:forEach var="currentLocation" items="${locationList}">
                            <tr>
                                <td>
                                    <c:out value="${currentLocation.locationName}"/> 
                                </td>
                                <td>
                                    <c:out value="${currentLocation.locationDescription}"/>
                                </td>
                                <td>
                                    <a href="displayEditLocationForm?locationID=${currentLocation.locationID}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteLocation?locationID=${currentLocation.locationID}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="col-md-6">
                    <h2>Add New Location</h2>
                    <form class="form-horizontal" role="form" method="POST" action="createLocation">
                        <div class="form-group">
                            <label for="add-location-name" class="col-md-4 control-label">Name</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationName" id="add-location-name" placeholder="Enter Name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-location-description" class="col-md-4 control-label">Description</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationDescription" id="add-location-description" placeholder="Enter Description"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-location-address" class="col-md-4 control-label">Address</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationAddress" id="add-location-address" placeholder="Enter Address"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-location-longitude" class="col-md-4 control-label">Longitude</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationLongitude" id="add-location-longitude" placeholder="Enter Longitude"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-location-latitude" class="col-md-4 control-label">Latitude</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationLatitude" id="add-location-latitude" placeholder="Enter Latitude"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" class="btn btn-default" id="create-location">Add Location</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
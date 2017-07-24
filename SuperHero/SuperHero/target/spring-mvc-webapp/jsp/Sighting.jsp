<%-- 
    Document   : Sighting
    Created on : Jul 18, 2017, 3:28:50 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            <div class="row">
                <div class="col-md-6">
                    <h2>Sightings</h2>
                    <table id="sightingTable" class="table table-hover">
                        <tr>
                            <th width="20%">Date</th>
                            <th width="30%">Location</th>
                            <th width="30%">Superhero</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <c:forEach var="currentSighting" items="${sightingList}">
                            <tr>
                                <td>
                                    <c:out value="${currentSighting.sightingDate}"/> 
                                </td>
                                <td>
                                    <c:out value="${currentSighting.location.locationName}"/>
                                </td>
                                <td>
                                    <c:forEach var="super1" items="${currentSighting.supers}">
                                        <c:out value="${super1.superName}"/>
                                    </c:forEach>
                                </td>
                                <td>
                                    <a href="displayEditSightingForm?sightingID=${currentSighting.sightingID}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteSighting?sightingID=${currentSighting.sightingID}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="col-md-6">
                    <h2>Add New Sighting</h2>
                    <form class="form-horizontal" role="form" action="createSighting" method="POST">
                        <div class="form-group">
                            <label for="add-sighting-date" class="col-md-4 control-label">Date</label>
                            <div class="col-md-4">
                                <input type="date" class="form-control" name="sightingDate" id="add-sighting-date"/>
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
                                <button type="submit" id="create-sighting" class="btn btn-default">Add Sighting</button>
                                <input type="hidden" id="sightingID">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!--        <script src="${pageContext.request.contextPath}/js/organizationList.js"></script>
        <script src="${pageContext.request.contextPath}/js/locationList.js"></script>
        <script src="${pageContext.request.contextPath}/js/sightingList.js"></script>-->

    </body>
</html>


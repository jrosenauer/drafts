<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet"> 
        <style>
            
            td
            {padding:10px}
            
        </style>
    </head>
    <body>
        <div class="container">
            <jsp:include page="NavigationBar.jsp"/>
            <br/>

            <div class="row">
                <div class="col-md-12">
                    <br/>
                    <h2>Most Recent Sightings</h2>

                    <table id="RecentTenSightingsTable">
                        <tr>
                            <th width="20%">Date</th>
                            <th width="40%">Location</th>
                            <th width="40%">Superheroes</th>
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
                            </tr>
                        </c:forEach>
                    </table>
                </div>                
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>       
    </body>
</html>


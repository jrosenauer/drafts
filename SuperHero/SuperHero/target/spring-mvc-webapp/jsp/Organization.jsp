<%-- 
    Document   : Organization
    Created on : Jul 16, 2017, 5:11:43 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>        
        <title>Organization</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <jsp:include page="NavigationBar.jsp"/>
            <br/>

            <div class="row">
                <div class="col-md-6">
                    <h2>Organizations</h2>
                    <table id="organizationTable" class="table table-hover">
                        <tr>
                            <th width="30%">Name</th>
                            <th width="50%">Description</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <c:forEach var="currentOrganization" items="${organizationList}">
                            <tr>
                                <td>
                                    <c:out value="${currentOrganization.organizationName}"/> 
                                </td>
                                <td>
                                    <c:out value="${currentOrganization.organizationDescription}"/>
                                </td>
                                <td>
                                    <a href="displayEditOrganizationForm?organizationID=${currentOrganization.organizationID}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteOrganization?organizationID=${currentOrganization.organizationID}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <!--new Organization form-->
                <div class="col-md-6">
                    <h2>Add New Organization</h2>
                    <form class="form-horizontal" role="form" action="createOrganization" method="POST">
                        <div class="form-group">
                            <label for="add-organization-name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationName" placeholder="Enter Organization"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-organization-description" class="col-md-4 control-label">Description</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationDescription" id="add-organization-description" placeholder="Enter Description"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-organization-address" class="col-md-4 control-label">Address</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationAddress" id="add-organization-address" placeholder="Enter Address"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-organization-phone" class="col-md-4 control-label">Phone:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationPhone" id="add-organization-phone" placeholder="Enter Phone"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-organization-email" class="col-md-4 control-label">Email:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationEmail" id="add-organization-email" placeholder="Enter Email"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="create-organization" class="btn btn-default">Add Organization</button>                        
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

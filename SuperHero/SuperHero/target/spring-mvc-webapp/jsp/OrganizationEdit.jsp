<%-- 
    Document   : organizationEdit
    Created on : Jul 16, 2017, 4:47:41 PM
    Author     : apprentice
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <sf:form class="form-horizontal" role="form" modelAttribute="organization" action="editOrganization" method="POST">
                <div class="form-group">
                    <label for="add-organization-name" class="col-md-4 control-label">Name </label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-name" path="organizationName" placeholder="Enter Name"/>
                        <sf:errors path="organizationName" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-organization-description" class="col-md-4 control-label">Description</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-description" path="organizationDescription" placeholder="Enter Description"/>
                        <sf:errors path="organizationDescription" cssclass="error"></sf:errors>
                        </div>
                    </div>                          
                    <div class="form-group">
                        <label for="add-organization-address" class="col-md-4 control-label">Address</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-address" path="organizationAddress" placeholder="Enter Address"/>
                        <sf:errors path="organizationAddress" cssclass="error"></sf:errors>

                        </div>
                    </div>                          
                    <div class="form-group">
                        <label for="add-organization-phone" class="col-md-4 control-label">Phone</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-phone" path="organizationPhone" placeholder="Enter Phone"/>
                        <sf:errors path="organizationPhone" cssclass="error"></sf:errors>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-organization-email" class="col-md-4 control-label">Email</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-organization-email" path="organizationEmail" placeholder="Enter Email"/>
                        <sf:errors path="organizationEmail" cssclass="error"></sf:errors>
                        <sf:hidden path="organizationID"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Organization"/>
                    </div>
                </div>
            </sf:form>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
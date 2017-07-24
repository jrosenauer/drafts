<%-- 
    Document   : SuperEdit
    Created on : Jul 18, 2017, 3:25:50 PM
    Author     : apprentice
--%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Superhero</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <jsp:include page="NavigationBar.jsp"/>
            <br/>    
            <sf:form class="form-horizontal" role="form" modelAttribute="superPerson" action="editSuper" method="POST">
                <div class="form-group">
                    <sf:input type="hidden" path="superID"></sf:input>
                    <label for="add-super-name" class="col-md-4 control-label">Name </label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-super-name" path="superName" placeholder="Enter Name"/>
                        <sf:errors path="superName" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-super-description" class="col-md-4 control-label">Description</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-super-description" path="superDescription" placeholder="Enter Description"/>
                        <sf:errors path="superDescription" cssclass="error"></sf:errors>
                        </div>
                    </div>                          
                    <div class="form-group">
                        <label for="add-super-power" class="col-md-4 control-label">Power</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-super-power" path="superPower" placeholder="Enter Power"/>
                        <sf:errors path="superPower" cssclass="error"></sf:errors>

                        </div>
                    </div>                          

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Update Power"/>
                        </div>
                    </div>
            </sf:form>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
<%-- 
    Document   : Super
    Created on : Jul 18, 2017, 3:25:35 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Super</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <jsp:include page="NavigationBar.jsp"/>
            <br/>

            <div class="row">
                <div class="col-md-6">
                    <h2>Superheroes</h2>
                    <table id="superTable" class="table table-hover">
                        <tr>
                            <th width="30%">Name</th>
                            <th width="50%">Description</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr> 
                        <c:forEach var="currentSuper" items="${superList}">
                            <tr>
                                <td>
                                    <c:out value="${currentSuper.superName}"/> 
                                </td>
                                <td>
                                    <c:out value="${currentSuper.superDescription}"/>
                                </td>
                                <td>
                                    <a href="displayEditSuperForm?superID=${currentSuper.superID}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteSuper?superID=${currentSuper.superID}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="col-md-6">
                    <h2>Add New Superhero</h2>
                    <form class="form-horizontal" role="form" method="POST" action="createSuper">
                        <div class="form-group">
                            <label for="add-super-name" class="col-md-4 control-label">Name</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="superName" id="add-super-name" placeholder="Enter Name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-super-description" class="col-md-4 control-label">Description</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="superDescription" id="add-super-description" placeholder="Enter Description"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-super-power" class="col-md-4 control-label">Super</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="superPower" id="add-super-power" placeholder="Enter Power"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" class="btn btn-default" id="create-super">Add Superhero</button>
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

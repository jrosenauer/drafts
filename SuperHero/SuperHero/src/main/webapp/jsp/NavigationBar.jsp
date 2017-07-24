<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <div class="container">
        <div class="row col-md-12">
            <div class="col-md-10">
                <h1 class="navbar" role="presentation">The Hero Education Relationship Organization</h1>
            </div>

            <div class="col-md-6">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingPage">Sighting</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPage">Superhero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationPage">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organization</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <%@include file="/WEB-INF/pageParts/head.jsp" %>
</head>
<body>
<header class="header--form-page">
    <%@include file="/WEB-INF/pageParts/header.jsp" %>
    <div class="slogan container container--90">
        <h2 class="account-header"><spring:message code="profile.yourAccount"/></h2>
    </div>
    <table>
        <form:form modelAttribute="user"
        <tr>
            <td><spring:message code="profile.username"/>/email</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td><spring:message code="profile.date"/></td>
            <td>${user.creationDate}</td>
        </tr>
        <tr>
            <td><spring:message code="form.name"/></td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td><spring:message code="form.lastname"/></td>
            <td>${user.lastName}</td>
        </tr>
    </table>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
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
<header class="header--small-page">
    <%@include file="/WEB-INF/pageParts/header.jsp" %>
</header>
<section class="login-page">
    <h2><spring:message code="header.rules"/></h2>
    <ul class="rules">
        <c:forEach items="${rules}" var="rule">
            <li>${rule}</li>
            <br>
        </c:forEach>
    </ul>
</section>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
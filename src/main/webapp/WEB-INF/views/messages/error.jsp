<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <%@include file="/WEB-INF/pageParts/head.jsp"%>
</head>
<body>
<header class="header--form-page">
    <%@include file="/WEB-INF/pageParts/header.jsp"%>
    <div class="slogan container container--90">
        <h2>
            Ups !
            Wystąpił nieoczekiwany błąd.<br/>
            Przepraszamy za niedogodności.<br>
            <br>
            An unexpected error has occurred.<br/>
            We apologize for the inconvenience.<br>
        </h2>
    </div>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
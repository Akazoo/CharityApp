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
<header class="header--main-page">
    <div class="header--top">
        <h2 class="header--logo"><spring:message code="general.goodHands"/></h2>
        <nav class="container container--70 header--nav">
            <ul>
                <li><a href="/logout" class="btn btn--without-border"><spring:message code="general.logOut"/>/a></li>
            </ul>
        </nav>
    </div>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Gratulacje! Właśnie zmieniłeś/aś hasło.<br>
                Aby móc korzystać ze swojego konta musisz sie ponownie zalogować.<br>
                <br>
                Congratulations! You have just changed your password <br>
                I order to use your account you must log in again.
            </h1>
        </div>
    </div>
</header>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
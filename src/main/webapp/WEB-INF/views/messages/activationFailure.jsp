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
                <li><a href="/logout" class="btn btn--without-border"><spring:message code="general.logOut"/></a></li>
            </ul>
        </nav>
    </div>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Aby móc korzystać ze swojego konta musisz je aktywować.<br>
                Link aktywacyjny został wysłany na podany przy rejestracji adres email.<br>
                <br>
                You must activate your account first.<br>.
                The activation link has been sent to the email address you provided during registration.
            </h1>
        </div>
    </div>
</header>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
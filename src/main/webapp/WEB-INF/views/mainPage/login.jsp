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
<header class="header--small-page">
    <%@include file="/WEB-INF/pageParts/header.jsp"%>
</header>
<section class="login-page">
    <h2><spring:message code="general.logIn"/></h2>
    <form method="post" action="/login">
        <div class="form-group">
            <input type="text" id="login" name="username" placeholder="Email"/>
        </div>
        <div class="form-group">
            <spring:message code="form.password" var="formPass"/>
            <input type="password" id="password" name="password" placeholder="${formPass}"/>
            <a href="/login/forgotten" class="btn btn--small btn--without-border reset-password"><spring:message code="general.forgotPass"/></a>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border"><spring:message code="general.register"/></a>
            <button class="btn" type="submit"><spring:message code="general.log"/> </button>
        </div>
    </form>
</section>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
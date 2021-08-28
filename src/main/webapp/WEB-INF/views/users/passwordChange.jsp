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
<section class="steps">
    <h2><spring:message code="profile.changePassword"/></h2>
    <form:form method="post" action="/user/changePassword" modelAttribute="passwordChanger">
        <div class="steps--container">
            <div class="form-group">
                <form:hidden path="email" value="${passwordChanger.email}"/>
                <spring:message code="form.password" var="formPass"/>
                <form:input type="password" path="password" placeholder="${formPass}"/>
                <form:errors path="password" element="p"/>
            </div>
            <div class="form-group">
                <spring:message code="form.repeatPass" var="repeatPass"/>
                <form:input type="password" path="password2" placeholder="${repeatPass}"/>
                <form:errors path="password2" element="p"/>
            </div>
            <div class="form-group form-group--buttons">
                <button class="btn" id="asd" type="submit"><spring:message code="general.edit.changePassword"/></button>
            </div>
        </div>
    </form:form>
</section>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
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
    <form:form modelAttribute="userEdit" method="post">
        <table>
            <tr>
                <td><spring:message code="profile.username"/>/email</td>
                <td><input value="${loggedUser.email}" disabled></td>
            </tr>
            <tr>
                <td><spring:message code="profile.date"/></td>
                <td><input value="${loggedUser.creationDate}" disabled></td>
            </tr>
            <tr>
                <td><spring:message code="form.name"/></td>
                <td><form:input path="firstName" id="firstName" value="${loggedUser.firstName}" disabled="true"/>
                    <form:errors path="firstName" element="p"/>
                </td>
            </tr>
            <tr>
                <td><spring:message code="form.lastname"/></td>
                <td><form:input path="lastName" id="lastName" value="${loggedUser.lastName}" disabled="true"/>
                    <form:errors path="lastName" element="p"/>
                </td>
            </tr>
        </table>
        <div class="form-group--buttons edit-start" id="gorms">
            <a class="btn btn--without-border" id="editStart"><spring:message code="general.edit.start"/></a>
            <a href="/user/profile#gorms"  class="btn btn--without-border" id="changePassword"><spring:message code="general.edit.changePassword"/></a>
            <div class="form-group--buttons edit-end">
                <button class="btn hidden" id="editEnd" type="submit"><spring:message code="general.edit.end"/></button>
            </div>
        </div>
</header>
<section class="steps hidden" id="passwordForm">
    </form:form>
        <h2><spring:message code="profile.changePassword"/></h2>
        <form:form method="post" action="/profile/changePassword" modelAttribute="passwordChanger">
        <div class="steps--container">
            <div class="form-group">
                <spring:message code="form.password" var="formPass"/>
                <form:input type="password" path="password" placeholder="${formPass}" />
                <form:errors path="password" element="p"/>
            </div>
            <div class="form-group">
                <spring:message code="form.repeatPass" var="repeatPass"/>
                <form:input type="password" path="password2" placeholder="${repeatPass}" />
                <form:errors path="password2" element="p"/>
            </div>
            <div class="form-group form-group--buttons">
                <button class="btn" type="submit"><spring:message code="general.edit.changePassword"/></button>
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
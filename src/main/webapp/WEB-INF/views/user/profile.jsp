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
    <form:form modelAttribute="userEdit" method="post" action="/user/profile">
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
        <div class="form-group--buttons edit-start" id="pass">
            <a class="btn btn--without-border" id="editStart"><spring:message code="general.edit.start"/></a>
            <a href="/user/changePassword" class="btn btn--without-border"><spring:message code="general.edit.changePassword"/></a>
            <div class="form-group--buttons edit-end">
                <button class="btn hidden" id="editEnd" type="submit"><spring:message code="general.edit.end"/></button>
            </div>
        </div>
    </form:form>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
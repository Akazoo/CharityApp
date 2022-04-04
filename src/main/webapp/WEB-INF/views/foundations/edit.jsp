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
        <h2 class="account-header"><spring:message code="admin.editFoundation"/></h2>
    </div>
    <form:form modelAttribute="institutionEdit" method="post" action="/admin/foundations/edit/check">
        <table class="tablep top40">
            <form:hidden path="id" value="${institutionEdit.id}"/>
            <tr>
                <td><spring:message code="admin.name"/></td>
                <td><form:input path="name"/>
                    <form:errors path="name" element="p"/>
                </td>
            </tr>
            <tr>
                <td><spring:message code="admin.description"/></td>
                <td><form:textarea rows="3" path="description"/>
                    <form:errors path="description" element="p"/>
                </td>
            </tr>
        </table>

        <div class="form-group--buttons center">
            <a href="${back}" class="btn btn--without-border"><spring:message code="general.back"/></a>
            <button class="btn" style="margin-left: 150px" type="submit"><spring:message code="general.edit.end"/></button>
        </div>

    </form:form>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
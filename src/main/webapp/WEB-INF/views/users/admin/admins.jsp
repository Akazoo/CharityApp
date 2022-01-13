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
        <h2 class="account-header"><spring:message code="admin.admins"/></h2>

        <div class="one-object tableA overflow-auto">
            <table border="1" frame="hsides" rules="rows">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Email</th>
                    <th><spring:message code="form.name"/></th>
                    <th><spring:message code="form.lastname"/></th>
                    <th><spring:message code="admin.accountStatus"/></th>
                    <th><spring:message code="admin.actions"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="admin" items="${admins}">
                    <tr>
                        <td>${admin.id}</td>
                        <td>${admin.email}</td>
                        <td>${admin.firstName}</td>
                        <td>${admin.lastName}</td>
                        <td>${admin.accountConfirmation}</td>
                        <td>
                        <span>
                        <input type="button" class="btn btn--without-border demoteButton" id="${admin.id}" value="<spring:message code="admin.degrade"/>"/>
                        </span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form>
            <p>${noAdmin}</p>
            </form>
        </div>
    </div>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
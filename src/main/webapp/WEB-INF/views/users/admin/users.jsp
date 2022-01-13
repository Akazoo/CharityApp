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
        <h2 class="account-header"><spring:message code="admin.users"/></h2>

        <div class="one-object tableA" style="overflow: auto">
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
                <c:forEach var="user" begin="1" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.accountConfirmation}</td>
                        <td>
                        <span>
                            <c:if test="${user.id !=1}">
                        <input type="button" class="btn btn--without-border" value="<spring:message code="general.edit.end"/>" onClick="location.href = '/admin/users/edit/' + ${user.id}">
                        <input type="button" class="btn btn--without-border deleteUserButton"  id="${user.id}" value="<spring:message code="general.delete"/>"/>
                        <input type="button" class="btn btn--without-border blockUserButton" id="${user.id}"  value="<spring:message code="admin.block"/>"/>
                        <input type="button" class="btn btn--without-border elevateUserButton" id="${user.id}" value="<spring:message code="admin.grant"/>"/>
                            </c:if>
                        </span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
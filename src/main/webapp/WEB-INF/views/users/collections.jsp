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
        <h2 class="account-header">
            <sec:authorize access="hasRole('ADMIN')">Donacje</sec:authorize>
            <sec:authorize access="hasRole('USER')">Twoje Donacje</sec:authorize>
        </h2>

        <div class="one-object tableA" style="overflow: auto">
            <table border="1" frame="hsides" rules="rows">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Data stworzenia</th>
                    <th>Status</th>
                    <th>Zmiana statusu</th>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th>Użytkownik</th>
                    </sec:authorize>
                    <th>Dostępne akcje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${donations}" var="donation">
                    <tr>
                        <td>${donation.id}</td>
                        <td>${donation.creationDate}</td>
                        <td>${donation.status}</td>
                        <td>${donation.statusChangedDate}</td>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td>${donation.user.email}</td>
                            <td>
                            <span>
                            <input type="button" class="btn btn--without-border" value="Szczegóły"
                                   onClick="location.href='/donation/${donation.id}'">
                                <input type="button" class="btn btn--without-border deleteButton" value="Usuń"
                                       id="${donation.id}"/>
                            </span>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('USER')">
                            <td>
                            <span>
                            <input type="button" class="btn btn--without-border" value="Szczegóły"
                                   onClick="location.href='/donation/${donation.id}'">
                            <c:if test="${donation.status == 'created'}">
                                <input type="button" class="btn btn--without-border deleteButton" value="Usuń"
                                       id="${donation.id}"/>
                                <input type="button" class="btn btn--without-border confirmButton" value="Potwierdź"
                                       id="${donation.id}"/>
                            </c:if>
                            </span>
                            </td>
                        </sec:authorize>
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
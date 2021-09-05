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
        <h2 class="account-header">Fundacje</h2>

        <div class="one-object tableA" style="overflow: auto">
            <table border="1" frame="hsides" rules="rows">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Dostępne akcje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="institution" items="${institutions}">
                    <tr>
                        <td>${institution.id}</td>
                        <td>${institution.name}</td>
                        <td>${institution.description}</td>
                        <td>
                        <span>
                              <c:if test="${institution.id !=1}">
                                  <input type="button" class="btn btn--without-border" value="Edytuj"
                                         onClick="location.href = '/admin/foundations/edit/' + ${institution.id}">
                                  <input type="button" class="btn btn--without-border deleteFoundationButton"
                                         id="${institution.id}" value="Usuń"/>
                              </c:if>
                        </span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="form-group--buttons " style="margin-left: 16%">
        <a href="/admin/foundations/add" class="btn btn--without-border">Dodaj fundacje</a>
    </div>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
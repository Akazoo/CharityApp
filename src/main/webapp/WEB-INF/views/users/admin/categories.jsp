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
        <h2 class="account-header"><spring:message code="admin.categories"/></h2>

        <div class="one-object tableA" style="overflow: auto">
            <table border="1" frame="hsides" rules="rows">
                <thead>
                <tr>
                    <th>Id</th>
                    <th><spring:message code="admin.name"/></th>
                    <th><spring:message code="admin.actions"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="category" begin="1" items="${categories}">
                    <tr>
                        <td>${category.id}</td>
                        <td>${category.name}</td>
                        <td>
                        <span>
                            <c:if test="${category.id !=1}">
                                <input type="button" class="btn btn--without-border" value="<spring:message code="general.edit.end"/>"
                                       onClick="location.href = '/admin/categories/edit/' + ${category.id}">
                                <input type="button" class="btn btn--without-border deleteCategoryButton"
                                       id="${category.id}" value="<spring:message code="general.delete"/>"/>
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
        <a href="/admin/categories/add" class="btn btn--without-border"><spring:message code="admin.addCategory"/></a>
    </div>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
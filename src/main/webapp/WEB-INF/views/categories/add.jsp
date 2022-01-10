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
        <h2 class="account-header">Dodaj kategorię</h2>
    </div>
    <form:form modelAttribute="categoryAdd" method="post">
        <table class="tablep top40">
            <tr>
                <td>Nazwa</td>
                <td><form:input path="name"/>
                    <form:errors path="name" element="p"/>
                </td>
            </tr>
        </table>

        <div class="form-group--buttons center">
                <button class="btn" type="submit">Dodaj</button>
        </div>
    </form:form>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
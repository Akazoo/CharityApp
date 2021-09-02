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
        <h2 class="account-header">Szczegóły donacji o id ${donation.id}</h2>
    </div>
    <div class="one-object tablep top40" style="overflow: auto">
        <table>
            <tr>
                <td>Ilość worków</td>
                <td><input value="${donation.quantity}" disabled></td>
            </tr>
            <tr>
                <td>Kategorie</td>
                <td>
                    <c:forEach items="${donation.categories}" var="category">
                        <textarea rows="2" cols="19" disabled>${category.name}</textarea><br/><br/>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>Instytucja</td>
                <td><input value="${donation.institution.name}" disabled></td>
            </tr>
            <tr>
                <td>Adres</td>
                <td><input value="${donation.street}" disabled><br/><br/>
                    <input value="${donation.city}" disabled><br/><br/>
                    <input value="${donation.zipCode}" disabled></td>
            </tr>
            <tr>
                <td>Data odbioru</td>
                <td><input value="${donation.pickUpDate}" disabled><br/><br/>
                    <input value="${donation.pickUpTime}" disabled></td>
            </tr>
            <tr>
                <td>Komentarz</td>
                <td><textarea rows="3" cols="19>" disabled>${donation.pickUpComment}</textarea>
                </td>
            </tr>
            <tr>
                <td>Numer telefonu</td>
                <td><input value="${donation.phoneNumber}" disabled></td>
            </tr>
            <tr>
                <td>Status/Data zmiany statusu</td>
                <td><input value="${donation.status}" disabled><br/><br/>
                    <input value="${donation.statusChangedDate}" disabled></td>
            </tr>

        </table>
    </div>
    <div class="form-group--buttons " style="margin-left: 300px">
        <a href="${back}" class="btn btn--without-border">Wróć</a>
    </div>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
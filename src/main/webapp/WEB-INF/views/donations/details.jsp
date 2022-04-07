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
        <h2 class="account-header"><spring:message code="donation.details"/> ${donation.id}</h2>
    </div>
    <div class="one-object tablep top40 overflow-auto">
        <table>
            <tr>
                <td><spring:message code="donation.bags.number"/></td>
                <td><input value="${donation.quantity}" disabled></td>
            </tr>
            <tr>
                <td><spring:message code="admin.categories"/></td>
                <td>
                    <c:forEach items="${donation.categories}" var="category">
                        <textarea rows="2" cols="19" disabled>${category.name}</textarea><br/><br/>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td><spring:message code="donation.foundation"/></td>
                <td><input value="${donation.institution.name}" disabled></td>
            </tr>
            <tr>
                <td><spring:message code="donation.address"/></td>
                <td><input value="${donation.street}" disabled><br/><br/>
                    <input value="${donation.city}" disabled><br/><br/>
                    <input value="${donation.zipCode}" disabled></td>
            </tr>
            <tr>
                <td><spring:message code="form.step.four.dateTime"/></td>
                <td><input value="${donation.pickUpDate}" disabled><br/><br/>
                    <input value="${donation.pickUpTime}" disabled></td>
            </tr>
            <tr>
                <td><spring:message code="donation.comment"/></td>
                <td><textarea rows="3" cols="19>" disabled>${donation.pickUpComment}</textarea>
                </td>
            </tr>
            <tr>
                <td><spring:message code="form.step.four.phone"/></td>
                <td><input value="${donation.phoneNumber}" disabled></td>
            </tr>
            <tr>
                <td><spring:message code="donations.status"/></td>
                <td><input value="${donation.status}" disabled><br/><br/>
                    <input value="${donation.statusChangedDate}" disabled></td>
            </tr>

        </table>
    </div>
    <div class="form-group--buttons marginleft300">
        <a href="${back}" class="btn btn--without-border"><spring:message code="general.back"/></a>
    </div>
</header>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
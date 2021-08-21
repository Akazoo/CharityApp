<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <%@include file="/WEB-INF/pageParts/head.jsp"%>
</head>
<body>
<header class="header--main-page">
    <%@include file="/WEB-INF/pageParts/header.jsp"%>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                <spring:message code="index.slogan.first"/><br/>
                <spring:message code="index.slogan.second"/>
            </h1>
        </div>
    </div>
</header>

<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${bags}</em>

            <h3><spring:message code="index.givenBags"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>${donations}</em>
            <h3><spring:message code="index.donations"/></h3>
            <p id="steps">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>
    </div>
</section>

<section class="steps">
    <h2><spring:message code="index.steps.steps"/></h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3><spring:message code="index.steps.choose.first"/></h3>
            <p><spring:message code="index.steps.choose.second"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3><spring:message code="index.steps.pack.first"/></h3>
            <p><spring:message code="index.steps.pack.second"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3><spring:message code="index.steps.destination.first"/></h3>
            <p><spring:message code="index.steps.destination.second"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3><spring:message code="index.steps.courier.first"/></h3>
            <p><spring:message code="index.steps.courier.second"/></p>
        </div>
    </div>

    <a href="/register" class="btn btn--large" id="about-us"><spring:message code="general.register"/></a>
</section>

<section class="about-us">
    <div class="about-us--text">
        <h2><spring:message code="header.us"/></h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img id="help" src="<c:url value="/resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="/resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section class="help">
    <h2><spring:message code="index.help.header"/></h2>

    <div class="help--slides active" data-id="1">
        <p><spring:message code="index.help.secondHeader"/></p>

        <ul class="help--slides-items">
            <c:forEach var="inst" items="${institutions}" varStatus="count">
                <c:if test="${count.index %2==0}">
                    <li>
                </c:if>
                <div class="col">
                    <div class="title"><spring:message code="index.help.foundation"/> "${inst.name}"</div>
                    <div class="subtitle"><spring:message code="index.help.goal"/> ${inst.description}</div>
                </div>
                <c:if test="${count.index %2!=0}">
                    </li>
                </c:if>
            </c:forEach>
            <c:if test="${institutions.size() %2!=0 }">
                <div class="col" style="visibility: hidden">
                </div>
                </li>
            </c:if>
        </ul>
    </div>
</section>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
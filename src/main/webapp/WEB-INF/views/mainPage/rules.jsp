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
<header class="header--small-page">
    <%@include file="/WEB-INF/pageParts/header.jsp" %>
</header>
<section class="login-page">
    <h2><spring:message code="header.rules"/></h2>
    <lu class="rules">
        <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Mauris lacinia justo nec pellentesque laoreet.
            In feugiat lorem vel tortor fringilla, eget ornare mi vulputate.
            Nulla aliquet est quis felis sodales, nec accumsan massa bibendum.
            Morbi rhoncus mauris sit amet convallis consectetur.
            Pellentesque at libero sodales, dignissim neque at, aliquam ligula.
        </li>
        <br>
        <li>Praesent a ipsum nec nulla tristique cursus at iaculis erat.
            Donec egestas massa non nisl vulputate, quis venenatis felis posuere.
            Proin vehicula eros et ante porta, non vehicula turpis ultricies.
            Nam interdum erat ac tempor posuere.
            Ut pharetra neque ut dolor auctor feugiat.
        </li>
        <br>
        <li>Donec euismod turpis faucibus elit vulputate, eget rhoncus purus dictum.
            Nam vestibulum ligula quis metus interdum, quis feugiat tortor egestas.
            Cras a magna nec metus mollis sodales.
            Vivamus placerat augue sed aliquam varius.
        </li>
        <br>
        <li>Etiam sed libero at orci eleifend condimentum.
            Etiam dignissim leo vitae dapibus condimentum.
            Donec maximus velit nec massa lobortis, ac pellentesque felis elementum.
            Suspendisse a orci non nibh suscipit aliquam ac id quam.
            Praesent a lacus aliquam, porta urna vitae, auctor odio.
        </li>
        <br>
        <li>Ut in lorem quis est fringilla fringilla.
            Integer ac libero ut felis hendrerit placerat eget eu ante.
        </li>
    </lu>
</section>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
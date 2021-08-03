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
<header style="height: 20vh">
    <%@include file="/WEB-INF/pageParts/header.jsp"%>
</header>
<section class="login-page">
    <h2>Zresetuj hasło</h2>
    <form:form method="post" modelAttribute="passwordReminder">
        <div class="form-group">
            <form:input path="email" placeholder="Email"/>
            <br/>
            <form:errors path="email" element="p"/>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Resetuj</button>
        </div>
    </form:form>
</section>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
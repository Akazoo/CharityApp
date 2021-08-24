<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
  <%@include file="/WEB-INF/pageParts/head.jsp"%>
</head>
<body>
<header class="header--small-page">
  <%@include file="/WEB-INF/pageParts/header.jsp"%>
</header>
    <section class="login-page">
      <h2><spring:message code="general.register"/></h2>
      <form:form method="post" modelAttribute="userAdd">
        <div class="form-group">
          <form:input path="email" placeholder="Email" />
          <form:errors path="email" element="p"/>
        </div>
        <div class="form-group">
          <spring:message code="form.password" var="formPass"/>
          <form:input type="password" path="password" placeholder="${formPass}" />
          <form:errors path="password" element="p"/>
        </div>
        <div class="form-group">
          <spring:message code="form.repeatPass" var="repeatPass"/>
          <form:input type="password" path="password2" placeholder="${repeatPass}" />
          <form:errors path="password2" element="p"/>
        </div>
        <div class="form-group">
          <spring:message code="form.name" var="formName"/>
          <form:input path="firstName" placeholder="${formName}" />
          <form:errors path="firstName" element="p"/>
        </div>
        <div class="form-group">
          <spring:message code="form.lastname" var="formLastName"/>
          <form:input path="lastName" placeholder="${formLastName}" />
          <form:errors path="lastName" element="p"/>
        </div>

        <div class="form-group form-group--buttons">
          <a href="/login" class="btn btn--without-border"><spring:message code="general.logIn"/></a>
          <button class="btn" type="submit"><spring:message code="general.register"/></button>
        </div>
      </form:form>
    </section>
<footer>
  <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
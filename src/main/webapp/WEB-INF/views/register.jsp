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
<header style="height: 20vh">
  <%@include file="/WEB-INF/pageParts/header.jsp"%>
</header>
    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form method="post" modelAttribute="userAdd">
        <div class="form-group">
          <form:input path="email" placeholder="Email" />
          <form:errors path="email" element="p"/>
        </div>
        <div class="form-group">
          <form:input type="password" path="password" placeholder="Hasło" />
          <form:errors path="password" element="p"/>
        </div>
        <div class="form-group">
          <form:input type="password" path="password2" placeholder="Powtórz hasło" />
          <form:errors path="password2" element="p"/>
        </div>
        <div class="form-group">
          <form:input path="firstName" placeholder="Podaj swoje imię" />
          <form:errors path="firstName" element="p"/>
        </div>
        <div class="form-group">
          <form:input path="lastName" placeholder="Podaj swoje nazwisko" />
          <form:errors path="lastName" element="p"/>
        </div>

        <div class="form-group form-group--buttons">
          <a href="/login" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </form:form>
    </section>
<footer>
  <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
<%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
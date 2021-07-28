<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="contact" id="contact">
    <h2>Skontaktuj się z nami</h2>
    <h3>Formularz kontaktowy</h3>
    <form:form class="form--contact" method="post" action="/contact" modelAttribute="contactMessage">

        <div class="form-group form-group--50"><form:input required="required" path="firstName" placeholder="Imię"/></div>
        <div class="form-group form-group--50"><form:input required="required" path="responseMail" placeholder="Twój email"/></div>
        <div class="form-group"><form:textarea  required="required" path="text" placeholder="Wiadomość" rows="1"/></div>
        <button class="btn" type="submit">Wyślij</button>
    </form:form>
</div>
<div class="bottom-line">
    <span class="bottom-line--copy">Copyright &copy; 2021</span>
    <div class="bottom-line--icons">
        <a
                href="https://www.linkedin.com/in/paweł-kucharski-akazoo"
                target="_blank"
                rel="noopener noreferrer"
                class="btn btn--small">
                <img src="<c:out value="/resources/images/icon-facebook.svg"/>"/>
        </a>
        <a
                href="https://www.linkedin.com/in/paweł-kucharski-akazoo"
                target="_blank"
                rel="noopener noreferrer"
                class="btn btn--small">
            <img src="<c:out value="/resources/images/icon-instagram.svg"/>"/>
        </a>
    </div>
</div>
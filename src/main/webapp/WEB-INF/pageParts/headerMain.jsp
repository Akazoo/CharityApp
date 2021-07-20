<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp"%>
<header class="header--main-page">
    <div style="width:100%;height:15%;background-color: rgba(224, 230, 255, 0.5);position: fixed">
        <h2 style="position:fixed;left: 100px">Dobre Ręce</h2>
        <nav class="container container--70" style="position:fixed;right: 80px;">
            <ul class="nav--actions">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </ul>

            <ul>
                <li><a href="" class="btn btn--without-border">Start</a></li>
                <li><a href="#steps" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="#about-us" class="btn btn--without-border">O nas</a></li>
                <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <li><a href="/donate" class="btn btn--without-border">Przekaż dary</a></li>
                <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
            </ul>
        </nav>

    </div>
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>
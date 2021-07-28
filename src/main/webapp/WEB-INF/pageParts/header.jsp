<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <div class="header--top">
        <h2 class="header--logo">Dobre Ręce</h2>
        <nav class="container container--70 header--nav">
            <ul class="nav--actions">

                <sec:authorize access="isAnonymous()">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
                </sec:authorize>

                <sec:authorize access="hasRole('USER')">
                <li class="logged-user">
                    Witaj ${logged}!
                    <ul class="dropdown">
                        <li><a href="#">Profil</a></li>
                        <li><a href="#">Moje zbiórki</a></li>
                        <li><a href="/logout">Wyloguj</a></li>
                    </ul>
                </li>
                </sec:authorize>

                <sec:authorize access="hasRole('ADMIN')">
                    <li class="logged-user">
                         Widok Administratora<br/>
                        Witaj ${logged}!
                        <ul class="dropdown">
                            <li><a href="#">Profil</a></li>
                            <li><a href="#">Moje zbiórki</a></li>
                            <li><a href="/logout">Wyloguj</a></li>
                        </ul>
                    </li>
                </sec:authorize>

            </ul>

            <ul>
                <li><a href="/" class="btn btn--without-border">Start</a></li>
                <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
                <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <sec:authorize access="hasRole('USER')">
                <li><a href="/donate" class="btn btn--without-border">Przekaż dary</a></li>
                </sec:authorize>
                <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
            </ul>
        </nav>
    </div>
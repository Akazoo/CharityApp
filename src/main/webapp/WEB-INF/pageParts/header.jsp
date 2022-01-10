<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <div class="header--top">
        <h2 class="header--logo">Dobre Ręce</h2>
        <nav class="container container--70 header--nav" style="margin-right: 20px">
            <ul class="nav--actions">

                <sec:authorize access="isAnonymous()">
                <li><a href="/login" class="btn btn--small btn--without-border"><spring:message code="general.log"/></a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted"><spring:message code="general.register"/></a></li>
                </sec:authorize>

                <sec:authorize access="hasRole('USER')">
                <li class="logged-user">
                    <spring:message code="general.hello"/> ${loggedUser.firstName}!
                    <ul class="dropdown">
                        <li><a href="/user/profile"><spring:message code="general.profile"/></a></li>
                        <li><a href="/user/collections"><spring:message code="general.collections"/></a></li>
                        <li><a href="/logout"><spring:message code="general.logOut"/></a></li>
                    </ul>
                </li>
                </sec:authorize>

                <sec:authorize access="hasRole('ADMIN')">
                    <li class="logged-user">
                        <spring:message code="admin.view"/><br/>
                        <spring:message code="general.hello"/> ${loggedUser.firstName}!
                        <ul class="dropdown">
                            <li><a href="/user/profile"><spring:message code="general.profile"/></a></li>
                            <li><a href="/admin/collections"><spring:message code="admin.collections"/></a></li>
                            <li><a href="/admin/admins"><spring:message code="admin.admins"/></a></li>
                            <li><a href="/admin/foundations"><spring:message code="admin.foundations"/></a></li>
                            <li><a href="/admin/categories"><spring:message code="admin.categories"/></a></li>
                            <li><a href="/admin/users"><spring:message code="admin.users"/></a></li>
                            <li><a href="/logout"><spring:message code="general.logOut"/></a></li>
                        </ul>
                    </li>
                </sec:authorize>

                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li><a id="PL" class="btn btn--small btn--highlighted">PL</a></li>
                <li><a id="ENG" class="btn btn--small btn--highlighted">ENG</a></li>
            </ul>

            <ul>
                <li><a href="/" class="btn btn--without-border">Start</a></li>
                <li><a href="/#steps" class="btn btn--without-border"><spring:message code="header.about"/></a></li>
                <li><a href="/#about-us" class="btn btn--without-border"><spring:message code="header.us"/></a></li>
                <li><a href="/#help" class="btn btn--without-border"><spring:message code="header.foundations"/></a></li>
                <sec:authorize access="hasRole('USER')">
                <li><a href="/donation/donate" class="btn btn--without-border"><spring:message code="header.donate"/></a></li>
                </sec:authorize>
                <li><a href="#contact" class="btn btn--without-border"><spring:message code="header.contact"/></a></li>
            </ul>
        </nav>
    </div>
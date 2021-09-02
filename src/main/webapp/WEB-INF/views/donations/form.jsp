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
<header class="header--form-page">
    <%@include file="/WEB-INF/pageParts/header.jsp"%>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            <spring:message code="form.slogan.first"/><br/>
            <span class="uppercase"><spring:message code="form.slogan.second"/></span>
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title"><spring:message code="form.steps.slogan"/>:</div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span><spring:message code="form.steps.first"/></span></div>
                </li>
                <li>
                    <div><em>2</em><span><spring:message code="form.steps.second"/></span></div>
                </li>
                <li>
                    <div><em>3</em><span><spring:message code="form.steps.third"/></span></div>
                </li>
                <li>
                    <div><em>4</em><span><spring:message code="form.steps.fourth"/></span></div>
                </li>
            </ul>
        </div>
    </div>
</div>
    <div class="form-error">
        <p>${error}</p>
        <p>${error1}</p>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3><spring:message code="form.instruction.important"/>!</h3>
            <p data-step="1" class="active">
                <spring:message code="form.instruction.first"/>
            </p>
            <p data-step="2">
                <spring:message code="form.instruction.first"/>
            </p>
            <p data-step="3">
                <spring:message code="form.instruction.third"/>
            </p>
            <p data-step="4">
                <spring:message code="form.instruction.fourth"/>
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"><spring:message code="form.step"/> <span>1</span>/4</div>

        <form:form action="/donation/donate/completed" method="post" modelAttribute="donationAdd">

            <!-- STEP 1 -->
            <div data-step="1" class="active">
                <h3><spring:message code="form.step.one.slogan"/>:</h3>

                <c:forEach items="${categories}" begin="1" var="category">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:checkbox path="categories" class="cat" value="${category.id}"/>
                            <span class="checkbox"></span>
                            <span class="description">${category.name}</span>
                        </label>
                    </div>
                </c:forEach>
                <br/>
                <form:errors path="categories" element="p"/>
                <br/>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="form.backwards"/></button>
                    <button type="button" class="btn next-step"><spring:message code="form.forward"/></button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3><spring:message code="form.step.two.slogan"/>:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        <spring:message code="form.step.two.label"/>:
                        <form:input id="number" type="number" path="quantity"/>
                    </label>
                    <br/>
                    <form:errors path="quantity" element="p"/>
                    <br/>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="form.backwards"/></button>
                    <button type="button" class="btn next-step"><spring:message code="form.forward"/></button>
                </div>
            </div>

            <!-- STEP 3 -->
            <div data-step="3">
                <h3><spring:message code="form.step.third.slogan"/>:</h3>

                <c:forEach items="${institutions}" begin="1" var="inst">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:radiobutton path="institution" class="spa" value="${inst.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <div class="title"><spring:message code="index.help.foundation"/> <div id="instr">“${inst.name}”</div></div>
                        <div class="subtitle">
                            <spring:message code="index.help.goal"/> : ${inst.description}
                        </div>
                        </span>
                        </label>
                    </div>
                </c:forEach>
                <br/>
                <form:errors path="institution" element="p"/>
                <br/>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="form.backwards"/></button>
                    <button type="button" class="btn next-step"><spring:message code="form.forward"/></button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3><spring:message code="form.step.four.slogan"/>:</h3>

                <div class="form-section form-section--columns" id="address">
                    <div class="form-section--column">
                        <h4><spring:message code="form.step.four.address"/></h4>
                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="form.step.four.street"/>
                                <form:input type="text" path="street"/>
                            </label>
                            <br/>
                            <form:errors path="street" element="p"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="form.step.four.city"/>
                                <form:input type="text" path="city"/>
                            </label>
                            <br/>
                            <form:errors path="city" element="p"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="form.step.four.zipCode"/>
                                <form:input type="text" path="zipCode"/>
                            </label>
                            <br/>
                            <form:errors path="zipCode" element="p"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="form.step.four.phone"/>
                                <form:input type="phone" path="phoneNumber"/>
                            </label>
                            <br/>
                            <form:errors path="phoneNumber" element="p"/>
                        </div>
                    </div>

                    <div class="form-section--column" id="time">
                        <h4><spring:message code="form.step.four.dateTime"/></h4>
                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="form.step.four.date"/>
                                <form:input id="txtDate" type="date" path="pickUpDate"/>
                            </label>
                            <br/>
                            <form:errors path="pickUpDate" element="p"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="form.step.four.hour"/>
                                <form:input type="time" path="pickUpTime"/>
                            </label>
                            <br/>
                            <form:errors path="pickUpTime" element="p"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="form.step.four.notes"/>
                                <form:textarea rows="5" id="comment" path="pickUpComment"/>
                            </label>
                            <br/>
                            <form:errors path="pickUpComment" element="p"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="form.backwards"/></button>
                    <button type="button" class="btn next-step"><spring:message code="form.forward"/></button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3><spring:message code="form.step.five.slogan"/></h3>

                <div class="summary">
                    <div class="form-section">
                        <h4><spring:message code="form.step.five.give"/>:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text" id="numberResult"></span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text" id="institutionResult">
                    </span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column" id="addressResult">
                        </div>

                        <div class="form-section--column" id="timeResult">
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="form.backwards"/></button>
                    <button type="submit" class="btn"><spring:message code="form.confirm"/></button>
                </div>
            </div>
        </form:form>
    </div>
</section>
<footer>
    <%@ include file="/WEB-INF/pageParts/footer.jsp" %>
</footer>
    <%@ include file="/WEB-INF/pageParts/scripts.jsp" %>
</body>
</html>
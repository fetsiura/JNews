<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="additional/headerLogNReg.jsp"%>

<section class="banner-area relative">
    <div class="overlay overlay-bg"></div>
    <div class="container">
        <div class="row fullscreen align-items-center justify-content-between">

            <div class="col-lg-4 col-md-6 banner-right">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="flight-tab" data-toggle="tab" href="#flight" role="tab" aria-controls="flight" aria-selected="true">Registration</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="flight" role="tabpanel" aria-labelledby="flight-tab">
                        <form:form class="form-wrap" method="post" modelAttribute="userDto" enctype="utf8">
                            <form:input type="text" path="username" class="form-control" placeholder="Username " onfocus="this.placeholder = 'Username'" onblur="this.placeholder = 'Username'"/>
                            <form:errors path="username" cssClass="error" element="div" />

                            <form:input type="text" path="email" class="form-control" placeholder="Email " onfocus="this.placeholder = 'Email'" onblur="this.placeholder = 'Email '"/>
                            <form:errors path="email" cssClass="error" element="div" />
                            <c:if test="${not empty errorEmail}">
                                <div class="error">${errorEmail.toString()}</div>
                            </c:if>
                            <c:if test="${not empty errorExists}">
                                <div class="error">${errorExists.toString()}</div>
                            </c:if>

                            <form:input type="password" path="password" class="form-control" placeholder="Password " onfocus="this.placeholder = 'Password'" onblur="this.placeholder = 'Password '"/>
                            <form:errors path="password" cssClass="error" element="div" />
                            <c:if test="${not empty errorPass}">
                                <div class="error">${errorPass.toString()}</div>
                            </c:if>

                            <form:input type="password" path="confirmPassword" class="form-control" placeholder="Password confirm " onfocus="this.placeholder = 'Password confirm'" onblur="this.placeholder = 'Password confirm '"/>
                            <form:errors path="confirmPassword" cssClass="error" element="div" />
                            <c:if test="${not empty errorConf}">
                                <div class="error">${errorConf.toString()}</div>
                            </c:if>

                            <button type="submit" class="primary-btn text-uppercase">Registration</button>
                        </form:form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="additional/footerLogNReg.jsp"%>

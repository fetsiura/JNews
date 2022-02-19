<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../additional/headerForLoginUserWithoutLanguage.jsp"%>
<script src="<c:url value="/js/confirm.js"/>"></script>
<section class="banner-area relative">
    <div class="overlay overlay-bg"></div>
    <div class="container">
        <div class="row fullscreen align-items-center justify-content-between">

            <div class="col-lg-4 col-md-6 banner-right">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="flight-tab" data-toggle="tab" href="#flight" role="tab" aria-controls="flight" aria-selected="true">Edit</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="flight" role="tabpanel" aria-labelledby="flight-tab">
                        <form:form class="form-wrap" method="post" modelAttribute="user" enctype="utf8" action="/user/update">
                            <form:hidden path="id"/>
                            <form:hidden path="role"/>
                            <form:hidden path="status"/>
                            <form:hidden path="email"/>
                            <form:hidden path="password"/>
                            <form:input type="text" path="username" class="form-control" placeholder="Username " onfocus="this.placeholder = ''" onblur="this.placeholder = 'username '"/>
                            <form:errors path="username" cssClass="error" element="div" />

                            <button type="submit" class="primary-btn text-uppercase">Edit</button>
                        </form:form>


                    </div>

                </div>
                <div>
                    <button class="genric-btn danger circle" id="buttonDelete">Delete account</button>
                </div>
                <div class="tab-pane fade show active" id="divDelete" style="display: none" >
                    <span class="text-white">Are you sure you want to delete the account?</span>
                <a href="<c:url value="/user/delete"/>" class="genric-btn danger circle">YES</a>
            </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../additional/footerLogNReg.jsp"%>

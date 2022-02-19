<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="additional/headerLogNReg.jsp"%>


<section class="banner-area relative">
    <div class="overlay overlay-bg"></div>
    <div class="container">
        <div class="row fullscreen align-items-center justify-content-between">

            <div class="col-lg-4 col-md-6 banner-right">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="flight-tab" data-toggle="tab" href="#flight" role="tab" aria-controls="flight" aria-selected="true">Login</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="flight" role="tabpanel" aria-labelledby="flight-tab">
                        <form class="form-wrap" method="post" action="/login">

                            <input type="text" class="form-control" name="username" id="username" placeholder="Email " onfocus="this.placeholder = 'Email'" onblur="this.placeholder = 'Email '"/>

                            <input type="password" class="form-control" id="password" name="password" placeholder="Password " onfocus="this.placeholder = 'Password'" onblur="this.placeholder = 'Password '"/>
                            <c:if test="${not empty error}">
                                <div class="error">  ${error.toString()}</div>
                            </c:if>

                            <button type="submit" class="primary-btn text-uppercase">Sing in</button>
                        </form>

                    </div>

                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="additional/footerLogNReg.jsp"%>

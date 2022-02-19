<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../additional/headerForLoginUserWithoutLanguage.jsp"%>



<!-- start banner Area -->
<section class="about-banner relative">
    <div class="overlay overlay-bg"></div>
    <div class="container">
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    Favorite
                </h1>
            </div>
        </div>
    </div>
</section>
<!-- End banner Area -->

<!-- Start destinations Area -->
<section class="destinations-area section-gap" >
    <div class="container" style="display: block">
        <div class="row d-flex justify-content-center">
            <div class="menu-content pb-40 col-lg-8">
                <div class="title text-center">
                    <h1 class="mb-10">Cities</h1>
                </div>
            </div>
        </div>
        <div class="row" >

        <c:forEach items="${cities}" var="city" >

            <div class="col-lg-4">
                <div class="single-destinations">
                    <div class="thumb">
                        <img src="img/hotels/d1.jpg" alt="">
                    </div>
                    <div class="details">
                        <h4 class="d-flex justify-content-between">
                            <span>${city.name}</span><button href="#" class="genric-btn danger circle">Delete</button>
                        </h4>
                        <ul class="package-list">
                            <li class="d-flex justify-content-between align-items-center">
                                <span>Temperature</span>
                                <span class="btn-light">${city.Temperature}</span>
                            </li>
                            <li class="d-flex justify-content-between align-items-center">
                                <span>Sensed temperature</span>
                                <span class="btn-light">${city.sensedTemperature}</span>
                            </li>
                            <li class="d-flex justify-content-between align-items-center">
                                <span>Weather</span>
                                <span class="btn-light">${city.cloud}</span>
                            </li>
                            <li class="d-flex justify-content-between align-items-center">
                                <span>Pressure</span>
                                <span class="btn-light">${city.pressure}</span>
                            </li>
                            <li class="d-flex justify-content-between align-items-center">
                                <span>Wind</span>
                                <span class="btn-light">${city.wind}</span>
                            </li>
                            <li class="d-flex justify-content-between align-items-center">
                                <span>Sunset</span>
                                <span class="btn-light">${city.sunset}</span>
                            </li>
                            <li class="d-flex justify-content-between align-items-center">
                                <span>Sunrise</span>
                                <span class="btn-light">${city.sunrise}</span>
                            </li>
                            <li class="d-flex justify-content-between align-items-center">
                                <span>Air Condition</span>
                                <span class="btn-light">${city.airCondition}</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </div>
</section>


<section class="destinations-area section-gap" >
    <div class="container" style="display: block">
        <div class="row d-flex justify-content-center">
            <div class="menu-content pb-40 col-lg-8">
                <div class="title text-center">
                    <h1 class="mb-10">News</h1>
                </div>
            </div>
        </div>
        <c:forEach items="${news}" var="someNews">

            <div class="section-top-border">
                    <%--                <h3 class="mb-30">${str2[1]}</h3>--%>
                <div class="row">
                    <div class="col-md-3">
                        <img src="${someNews.urlToImage}" alt="" class="img-fluid">
                    </div>
                    <div class="col-md-9 mt-sm-20 left-align-p">
                        <p>${someNews.title}</p>
                        <p>${someNews.content}</p><a href="${someNews.url}" class="genric-btn info circle arrow">More..<span class="lnr lnr-arrow-right"></span></a><button href="#" class="genric-btn danger circle">Delete</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</section>
<%@include file="../additional/footer.jsp"%>

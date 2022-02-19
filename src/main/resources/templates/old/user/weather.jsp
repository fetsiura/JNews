<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../additional/headerForLoginUserWithoutLanguage.jsp"%>

<section class="about-banner relative">
    <div class="overlay overlay-bg"></div>
    <div class="container">
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    WEATHER
                </h1>
                <h5 class="text-white">Last update ${cities.get(0).updated.toString()}</h5>
            </div>
        </div>
    </div>
</section>
<section >
    <div >
        <div>
            <div class="section-top-border">
                <div class="mb-30">
                    <h3>SORT BY</h3>
                    <form action="/user/weather" method="post" enctype="utf8">

                    <select name="filter">
                        <option value="tempHighToLow">Temp: High to Low</option>
                        <option value="tempLowToHigh">Temp: Low to High</option>
                        <option value="nameAtoZ">Name: A-Z</option>
                        <option value="nameZtoA">Name: Z-A</option>
                        <option value="wind">Wind</option>
                    </select>
                        <input name="name" type="text" placeholder="Find city ...">
                        <button type="submit" class="badge-dark success-border radius">Find</button>
                    </form>
                </div>
                <div class="progress-table-wrap">
                    <div class="progress-table">
                        <h4><div class="table-head">
                            <div class="serial">#</div>
                            <div class="serial">City</div>
                            <div class="serial">Temp</div>
                            <div class="serial">Feels like</div>
                            <div class="serial">Cloud</div>
                            <div class="serial">Wind</div>
                            <div class="serial">Pressure</div>
                            <div class="serial">Sunrise</div>
                            <div class="serial">Sunset</div>
                            <div class="serial">Air Condition</div>
                        </div> </h4>
                        <c:forEach items="${cities}" var="city" varStatus="no">
                            <div class="table-row">
                                <div class="serial text-black">${no.count}</div>
                                <div class="serial text-black">${city.name}</div>
                                <div class="serial text-black">${city.temperature} °C</div>
                                <div class="serial text-black">${city.feelsLike} °C</div>
                                <div class="serial text-black">${city.cloud}</div>
                                <div class="serial text-black">${city.wind} m/s</div>
                                <div class="serial text-black">${city.pressure} mb</div>
                                <div class="serial text-black">${city.sunrise}</div>
                                <div class="serial text-black">${city.sunset}</div>
                                <div class="serial text-black">${city.airCondition}</div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>


    </div>
</section>





<%@include file="../additional/footerLogNReg.jsp"%>
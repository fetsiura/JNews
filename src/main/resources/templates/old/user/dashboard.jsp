<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../additional/headerForLoginUser.jsp"%>

<section class="relative about-banner" id="home">
    <div class="overlay overlay-bg"></div>
    <div class="container">
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <form action="/homepage" method="post" enctype="utf8">

                    <h3 class="row d-flex align-middle justify-content-center">
                        <input path="category" name="category" type="text" class="circle primary-border" placeholder="write category"/>
                        <select  class="circle primary-border" name="language">
                            <c:forEach items="${languagesToSelect}" var="lang">
                                <option value="${lang.key}">${lang.value}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="genric-btn primary circle">SHOW</button>
                    </h3>
                </form>
            </div>
        </div>
    </div>
    </div>
    <div class="col-lg-3 sidebar-widgets">
        <div class="widget-wrap table">
            <div class="single-sidebar-widget search-widget">
                <table >
                    <thead>
                    <tr>
                        <th class="head"><a>Cryptocurrency</a></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${currencies}" var="currency">
                        <tr>
                            <td class="country "> <img src="../${currency.urlToPic}" alt="flag">   ${currency.name}</td>
                            <td><strong class="text-lg-right">  -  ${currency.usd} USD</strong></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!-- End banner Area -->
<div class="whole-wrap">
    <div class="container">
        <c:forEach items="${news}" var="someNews">


            <div class="section-top-border">
                <div class="row">
                    <div class="col-md-3">
                        <img src="${someNews.urlToImage}" alt="" class="img-fluid">
                    </div>
                    <div class="col-md-9 mt-sm-20 left-align-p">
                        <p>${someNews.title}</p>
                        <p>${someNews.description}</p><a href="${someNews.url}" target="_blank" rel="noopener noreferrer" class="genric-btn info circle arrow">More..<span class="lnr lnr-arrow-right"></span></a>

<%--                        <form class="form-wrap" method="post" enctype="utf8" action="/user/favorite/news/add">--%>
<%--                            <input type="hidden" name="title" value="${someNews.title}" />--%>
<%--                            <input type="hidden" name="url" value="${someNews.url}" />--%>
<%--                            <input type="hidden" name="urlToImage" value="${someNews.urlToImage}" />--%>
<%--                            <input type="hidden" name="description" value="${someNews.description}" />--%>

<%--                            <button type="submit" class="genric-btn primary circle">Add to favorite</button>--%>
<%--                        </form>--%>
                    </div>
                </div>
            </div>


        </c:forEach>

    </div>
</div>
<%@include file="../additional/footer.jsp"%>


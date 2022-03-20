package pl.jnews.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.jnews.core.crypto.Crypto;
import pl.jnews.core.crypto.CryptoServiceImplement;
import pl.jnews.core.news.News;
import pl.jnews.core.news.NewsServiceImplement;
import pl.jnews.core.user.UserServiceImplement;
import pl.jnews.core.weather.City;
import pl.jnews.core.weather.CityServiceImplement;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Secured("ROLE_USER")
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class LoginUserController {

    private final CityServiceImplement cityService;
    private final NewsServiceImplement newsService;
    private final CryptoServiceImplement cryptoService;
    private final UserServiceImplement userService;

    @GetMapping("/dashboard")
    public String getDashboard(Model model,
                               HttpSession session,
                               @CurrentSecurityContext(expression="authentication?.name")
                                           String username){

        if(session.getAttribute("userEmail") ==null){
            session.setAttribute("userLogin",userService.findByEmail(username).getLogin());
        }
        model.addAttribute("userId",userService.findByEmail(username).getId());
        model.addAttribute("news",newsService.getNewsWhenInputEmpty());
        return "user/dashboard";
    }


    @PostMapping("/dashboard")
    public String postDashboard(Model model,
                                   @Param("category") String category,
                                @CurrentSecurityContext(expression="authentication?.name")
                                            String username){

        if(newsService.check(category)){
            model.addAttribute("news", newsService.getNewsWithCategory(category));
        } else {
            model.addAttribute("error","Bad request, please try to describe differently.");
        }
        model.addAttribute("userId",userService.findByEmail(username).getId());

        return "user/dashboard";
    }

    @GetMapping("/favorite")
    public String getFavorite(Model model,
                              @CurrentSecurityContext(expression="authentication?.name")
                                          String username){
        model.addAttribute("news",newsService.getNewsFromId(userService.findByEmail(username).getId()));

        return "user/favorite";
    }

    @GetMapping("/news/add")
    @ResponseBody
    public String addNews(@Param("title") String title,
                          @Param("url")String url,
                          @Param("urlToImage")String urlToImage,
                          @Param("description")String description,
                          @Param("source") String source,
                          @Param("userId") String userId){

        News news = new News();
        news.setTitle(title);
        news.setUrl(url);
        news.setUrlToImage(urlToImage);
        news.setDescription(description);
        news.setSource(source);
        news.setUserId(Long.parseLong(userId));
        newsService.add(news);

        return "added";

    }

    ////kontrolery pogody
    @GetMapping("/weather")
    public String getWeather(Model model){
        if(cityService.countAllCity()<1){
            cityService.addCityToDatabase();
        }
        
        model.addAttribute("cities",cityService.cityByNameASC());
        return "user/weather";
    }

    @PostMapping("/weather")
    public String getWeather(Model model,
                             @Param("filter") String filter,
                             @Param("name")String name){
        List<City> cities = new ArrayList<>();

        ///jeżeli nie wpisano nazwy miasta sortujemy po wybranym wskaźniku
        if(name.isEmpty()){
            if (filter.contains("tempHighToLow")) {
                cities=cityService.cityByTemperatureHighToLow();
            } else if (filter.contains("tempLowToHigh")) {
                cities= cityService.cityByTemperatureLowToHigh();
            } else if (filter.contains("nameAtoZ")) {
                cities= cityService.cityByNameASC();
            } else if (filter.contains("nameZtoA")) {
                cities=cityService.cityByNameDESC();
            } else if (filter.contains("wind")) {
                cities=cityService.cityByWindSpeed();
            } else {
                cities=cityService.cityByNameASC();
            }
        } else {
            cities=cityService.cityByNameStartWith(name);
        }
        model.addAttribute("cities",cities);
        return "user/weather";
    }

    ////kontrolery kryptowalut
    @GetMapping("/cryptocurrency")
    public String cryptocurrencyGetForm(Model model){

        if(cryptoService.countAllCrypto()<1){
            cryptoService.addCryptoToDatabase();
        }
        model.addAttribute("cryptos",cryptoService.findByNameASC());

        return "user/cryptocurrency";
    }

    @PostMapping("/cryptocurrency")
    public String cryptocurrencyPostForm(Model model,
                                         @Param("filter") String filter,
                                         @Param("name")String name){
        List<Crypto> cryptos = new ArrayList<>();

        //jeżeli nie wpisano nazwy kryptowaluty sortujemy po wybranym wskaźniku
        if(name.isEmpty()){
            if (filter.contains("priceHighToLow")) {
                cryptos=cryptoService.findByPriceDESC();
            } else if (filter.contains("priceLowToHigh")) {
                cryptos=cryptoService.findByPriceASC();
            } else {
                cryptos=cryptoService.findByNameASC();
            }
        } else {

            cryptos=cryptoService.findByNameStartsWith(name);
        }
        model.addAttribute("cryptos",cryptos);

        return "user/cryptocurrency";
    }



    @GetMapping("/contact")
    public String getContacts(){
        return "user/contact";
    }


}

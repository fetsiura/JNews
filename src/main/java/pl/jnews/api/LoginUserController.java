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
import java.util.Locale;
import java.util.Optional;

@Secured("ROLE_USER")
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping()
public class LoginUserController {

    private final CityServiceImplement cityService;
    private final NewsServiceImplement newsService;
    private final UserServiceImplement userService;

    @GetMapping("/dashboard")
    public String getDashboard(Model model,
                               HttpSession session,
                               @CurrentSecurityContext(expression="authentication?.name")
                                           String username){

        model.addAttribute("news",newsService.getNewsWhenInputEmpty());

        ///imię usera zakładam do sesji
        if(session.getAttribute("userNameTimeSession")==null){
            session.setAttribute("userNameTimeSession",userService.findByEmail(username).getLogin().toUpperCase(Locale.ROOT));
        }
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

        return "user/dashboard";
    }

    @GetMapping("/favorite")
    public String getFavorite(Model model,
                              @CurrentSecurityContext(expression="authentication?.name")
                                          String username,
                              @Param("title") Optional<String> title,
                              @Param("url")Optional<String> url,
                              @Param("urlToImage")Optional<String> urlToImage,
                              @Param("description")Optional<String> description,
                              @Param("source") Optional<String> source){
        if(title.isPresent() && url.isPresent() && urlToImage.isPresent() && description.isPresent() && source.isPresent()){
            News news = new News();
            news.setTitle(title.get());
            news.setUrl(url.get());
            news.setUrlToImage(urlToImage.get());
            news.setDescription(description.get());
            news.setSource(source.get());
            news.setUserId(userService.findByEmail(username).getId());
            newsService.add(news);
        }

        model.addAttribute("news",newsService.getNewsFromId(userService.findByEmail(username).getId()));

        return "user/favorite";
    }


    ////kontrolery pogody
    @GetMapping("/weather")
    public String getWeather(Model model,
                             HttpSession session){

        List<City> cities = cityService.cityByNameASC();
        if(session.getAttribute("citiesLastUpdate")==null){
            session.setAttribute("citiesLastUpdate",cities.get(0).getUpdated());
        }
        model.addAttribute("cities",cities);
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

        if(cities.size()==0){
            model.addAttribute("nonCities","Our database does not contain such city.");
        }
        model.addAttribute("cities",cities);
        return "user/weather";
    }

}

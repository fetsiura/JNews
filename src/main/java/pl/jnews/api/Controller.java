package pl.jnews.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jnews.core.crypto.CryptoServiceImplement;
import pl.jnews.core.news.NewsServiceImplement;
import pl.jnews.core.weather.CityService;
import pl.jnews.core.weather.CityServiceImplement;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@org.springframework.stereotype.Controller
@RequiredArgsConstructor
@RequestMapping("/")
class Controller {

    private final NewsServiceImplement newsService;
    private final CryptoServiceImplement cryptoService;
    private final CityServiceImplement cityService;

    @GetMapping
    public String home(Model model){
            model.addAttribute("news",newsService.getNewsWhenInputEmpty());
            return "index";
    }


    @PostMapping
    public String homeWithCategory(Model model,
                                   @Param("category") String category){

        if(check(category)){
            model.addAttribute("news", newsService.getNewsWithCategory(category));
        } else {
            model.addAttribute("error","Bad request, please try to describe differently.");
        }
        return "index";
    }

    @GetMapping("/cryptocurrency")
    public String cryptocurrencyForm(Model model){
        if(cryptoService.getAllFromDatabase().size()==0){
            cryptoService.getCryptoList();
        }
        model.addAttribute("cryptos",cryptoService.getAllFromDatabase());

        return "cryptocurrency";
    }


    @GetMapping("/weather")
    public String getWeather(Model model){
        if(cityService.getAllCities().size()==0){
            cityService.addCityToDatabase();
        }
        model.addAttribute("cities",cityService.getAllCities());
        return "weather";
    }


    Boolean check(String word){
        String search ="";
        boolean flag = true;
        if(!word.isEmpty() || !word.isBlank()){
            search=word.replaceAll("[^a-zA-Z 0-9 - \\s]", "");
            if(search.isBlank() || search.isEmpty() || search.length()<2){
                flag=false;
            }
        }
        return flag;
        }


}

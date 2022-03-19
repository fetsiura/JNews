package pl.jnews.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jnews.core.weather.City;
import pl.jnews.core.weather.CityServiceImplement;

import java.util.ArrayList;
import java.util.List;

//@Secured("ROLE_USER")
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginUserController {

    private final CityServiceImplement cityService;


    @GetMapping("/dashboard")
    public String getDashboard(){

        return "user/dashboard";
    }


    @PostMapping("/dashboard")
    public String postDashboard(){

        return "user/dashboard";
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
}

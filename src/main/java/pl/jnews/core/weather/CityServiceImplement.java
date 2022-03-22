package pl.jnews.core.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.jnews.infrastructure.weatherdata.WeatherDataClient;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;


@Slf4j
@Service
@RequiredArgsConstructor
public class CityServiceImplement implements CityService{


    private final CityRepository cityRepository;
    private final WeatherDataClient weatherDataClient;

    @Override
    public void addCityToDatabase(HttpSession session) {
        List<City> cities = weatherDataClient.citiesWeatherHandler();
        cityRepository.saveAll(cities);
        session.setAttribute("citiesLastUpdate",cities.get(0).getUpdated());
        log.info("Cities download to database");
    }



    public List<City> cityByTemperatureLowToHigh(){
        return cityRepository.findCitiesByTemperatureLowToHigh();
    }
    public List<City> cityByTemperatureHighToLow(){
        return cityRepository.findCitiesByTemperatureHighToLow();
    }
    public List<City> cityByNameASC(){
        return cityRepository.findCitiesByNameAtoZ();
    }
    public List<City> cityByNameDESC(){
        return cityRepository.findCitiesByNameZtoA();
    }
    public List<City> cityByWindSpeed(){
        return cityRepository.findCitiesByWindSpeed();
    }

    public Integer countAllCity(){
        return cityRepository.countAllCity();
    }

    public List<City> cityByNameStartWith(String name){
        return cityRepository.findByNameStartsWith(name.toUpperCase(Locale.ROOT));
    }

}

package pl.jnews.core.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.jnews.infrastructure.weatherdata.WeatherDataClient;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class CityServiceImplement implements CityService{


    private final CityRepository cityRepository;
    private final WeatherDataClient weatherDataClient;

    @Override
    public void addCityToDatabase() {
        cityRepository.saveAll(weatherDataClient.citiesWeatherHandler());
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

//    public List<City> countCity(){
//        return cityRepository.countCity();
//    }

    public List<City> cityByNameStartWith(String name){
        return cityRepository.findCitiesByNameStartsWith(name);
    }

    @Override
    public List<City> getAllCities() {
       return cityRepository.findAll();
    }
}

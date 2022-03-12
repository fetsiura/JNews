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

    @Override
    public List<City> getAllCities() {
       return cityRepository.findAll();
    }
}

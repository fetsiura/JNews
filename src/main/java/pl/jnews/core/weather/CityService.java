package pl.jnews.core.weather;

import java.util.List;

public interface CityService {

    void addCityToDatabase();
    List<City> getAllCities();

}

package pl.jnews.core.city;

import java.util.List;

public interface CityService {

    void save(City city);
    List<City> getAllCity();
}

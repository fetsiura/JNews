package pl.jnews.infrastructure.weatherdata;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.jnews.core.weather.City;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherDataClient {

    private final String TOKEN_1 ="d6db19042ae8152539fe0a5eb96edf51";
    private final String TOKEN_2 ="c3d60a66719c359d03d4caf70fa4cda0";
    private final String TOKEN_3 ="08b79eb9131d8758f8b1d699f9e28534";
    private final String TOKEN_4 ="4fa7ddb13b7044e51c01ce51fc5c534a";
    private final String TOKEN_5 ="5c78c534180f7942c971ea1fd93021c5";
    private final String url_1 = "https://api.openweathermap.org/data/2.5/weather?lat=";
    private final String url_2 = "&lon=";
    private final String url_3 = "&APPID=";

    private int APICounter = 1;
    private final RestTemplate restTemplate;

    public List<City> citiesWeatherHandler(){
        String TOKENIZER = TOKEN_1;
        if(APICounter ==60){
            TOKENIZER =TOKEN_2;
        } else if(APICounter ==120){
            TOKENIZER =TOKEN_3;
        } else if(APICounter ==180){
            TOKENIZER =TOKEN_4;
        }else if(APICounter ==240){
            TOKENIZER =TOKEN_5;
        }
        Integer id = 1;
        List<City> cities = new ArrayList<>();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(" ","");
        HttpEntity entity = new HttpEntity(httpHeaders);

        List<String> capitals = readFromFile("capitals.txt");

        for (String capital: capitals){
            String[] split = capital.split(";");
            String url = url_1+split[2]+url_2+split[3]+url_3+TOKENIZER;
            ResponseEntity<ResponseWeatherHandler> exchange = restTemplate.exchange(url,
                    HttpMethod.GET,
                    entity,
                    ResponseWeatherHandler.class);
            ResponseWeatherHandler body = exchange.getBody();

            City city = new City();
            city.setId(id);
            city.setName(split[1]);
            city.setCountry(split[0]);
            city.setLatitude(split[2]);
            city.setLongitude(split[3]);
            city.setClouds(body.getWeather().get(0).getDescription());
            city.setHumidity(body.getMain().getHumidity());
            city.setFeelsLike((short) (body.getMain().getFeels_like()-273.15));
            city.setPressure(body.getMain().getPressure());
            city.setTemperature((short) (body.getMain().getTemp()-273.15));
            city.setWindSpeed(body.getWind().getSpeed());
            cities.add(city);
            APICounter++;
            id++;


        }

        return cities;

    }

    public static List<String> readFromFile(String fileName){
        List<String> list = new ArrayList<>();
        Path path = Paths.get(fileName);
        if(Files.exists(path)){
            try {
                list.addAll(Files.readAllLines(path));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return list;
    }
}

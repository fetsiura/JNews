package pl.jnews.core.city;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImplement implements CityService {

    private final CityRepository cityRepository;


    @Override
    public void save(City city) {
        cityRepository.save(city);
        log.info("Save city {}",city.getName());
    }

    @Override
    public List<City> getAllCity() {
        return null;
    }


    ///// metoda wyszukuje wszystkie województwa
    private List<String> getDistricts(){
        List<String> districts = new ArrayList<>();

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        String textDate = formatter.format(date);
        String interia = "https://pogoda.interia.pl";

        try{
            Document poland = Jsoup.connect("https://pogoda.interia.pl/polska").get();
            Elements elements = poland.getElementsByTag("area");

            for(Element element : elements){
                String place = element.attr("href");  /// bez lambdy
                districts.add(interia+place);
            }
            districts = elements.stream().map(element -> element.attr("href")).map(place -> interia + place).collect(Collectors.toList());

        }catch (Exception  e){
            e.printStackTrace();
        }
        return districts;
    }

}

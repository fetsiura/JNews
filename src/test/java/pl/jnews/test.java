package pl.jnews;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {


        List<String> districts = new ArrayList<>();

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        String textDate = formatter.format(date);
        String interia = "https://pogoda.interia.pl";

        try {
            Document poland = Jsoup.connect("https://pogoda.interia.pl/polska").get();
            Elements elements = poland.getElementsByTag("area");

            for (Element element : elements) {
                String place = element.attr("href");  /// bez lambdy
                districts.add(interia + place);
            }
            districts = elements.stream().map(element -> element.attr("href")).map(place -> interia + place).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

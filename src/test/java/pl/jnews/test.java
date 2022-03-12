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
        String world = "https://www.kaggle.com/nikitagrec/world-capitals-gps";

        try {
            Document poland = Jsoup.connect("https://www.kaggle.com/nikitagrec/world-capitals-gps").get();
            Element body = poland.body();





//            for (Element element : elementsByClass) {
//                String attr = element.attr("href");/// bez lambdy
//                System.out.println(attr);
//                Element a = element.select("a").first();
//                String href = a.attr("href");
//                System.out.println(href);
//                System.out.println(element);
//            }
//            districts = elements.stream().map(element -> element.attr("href")).map(place -> interia + place).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

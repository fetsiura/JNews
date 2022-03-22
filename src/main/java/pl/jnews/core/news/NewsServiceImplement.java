package pl.jnews.core.news;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.jnews.infrastructure.newsdata.NewsDataClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewsServiceImplement implements NewsService{

    private final String urlToCategoryNewsStart = "https://newsapi.org/v2/everything?q=";
    private final String urlToCategoryNewsEnd = "&sortBy=popularity&pageSize=100";
    private final String urlWhenInputEmpty = "https://newsapi.org/v2/top-headlines?category=general&country=us&pageSize=100";


    private final NewsRepository newsRepository;

    private final NewsDataClient newsDataClient;


    @Override
    public List<News> getNewsFromId(Long id) {
        return newsRepository.findAllByUserId(id);
    }

    @Override
    public List<News> getNewsWhenInputEmpty() {
        return newsDataClient.newsHandler(urlWhenInputEmpty);
    }

    @Override
    public List<News> getNewsWithCategory(String category) {
        return newsDataClient.newsHandler(urlToCategoryNewsStart.concat(category).concat(urlToCategoryNewsEnd));
    }


    @Override
    public void add(News news) {
        newsRepository.save(news);
        log.info("News o title {} added",news.getTitle());
    }

    @Override
    public void delete(Long id) {

    }

    public Boolean check(String word){
        String search ="";
        boolean flag = true;
        if(!word.isEmpty() || !word.isBlank()){
            search=word.replaceAll("[^a-zA-Z 0-9 - \\s]", "");
            if(search.isBlank() || search.isEmpty() || search.length()<2){
                flag=false;
            }
        }
        return flag;
    }
}

package pl.jnews.core.news;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jnews.infrastructure.newsdata.NewsDataClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImplement implements NewsService{

    private final NewsRepository newsRepository;

    private final NewsDataClient newsDataClient;


    @Override
    public List<News> getNewsFromDatabase() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> getNewsFromDataClient() {
        return newsDataClient.newsHandler();
    }

    @Override
    public void add(News news) {

    }

    @Override
    public void delete(Long id) {

    }
}

package pl.jnews.core.news;

import java.util.List;

interface NewsService {

    List<News> getNewsFromDatabase();
    List<News> getNewsFromDataClient();
    void add(News news);
    void delete(Long id);
}

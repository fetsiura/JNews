package pl.jnews.core.news;

import java.util.List;

interface NewsService {

    List<News> getNewsFromDatabase();
    List<News> getNewsWhenInputEmpty();
    List<News> getNewsWithCategory(String category);
    void add(News news);
    void delete(Long id);
}

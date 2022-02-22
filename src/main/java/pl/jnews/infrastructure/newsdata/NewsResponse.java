package pl.jnews.infrastructure.newsdata;

import lombok.Data;
import pl.jnews.core.news.News;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewsResponse {

    private String title;
    private String url;
    private String urlToImage;
    private String description;
    private Source source;



}

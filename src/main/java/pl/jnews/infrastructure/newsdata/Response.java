package pl.jnews.infrastructure.newsdata;

import lombok.Data;

import java.util.List;

@Data
class Response {

    private Long totalResults;
    private List<NewsResponse> articles;
}

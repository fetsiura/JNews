package pl.jnews.core.crypto;

import pl.jnews.core.news.News;

import java.util.List;

public interface CryptoService{

    String getListOfCrypto();
    List<Crypto> getAll();
    void add(Crypto crypto);
    void delete(Long id);
}

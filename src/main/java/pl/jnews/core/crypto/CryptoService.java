package pl.jnews.core.crypto;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CryptoService {
    List<Crypto> getAllFromDatabase();
    void getCryptoList();
    void save(Crypto crypto);

}

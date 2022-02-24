package pl.jnews.core.crypto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.jnews.infrastructure.weatherdata.CryptoDataClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoServiceImplement implements CryptoService{

    private final CryptoRepository cryptoRepository;
    private final CryptoDataClient cryptoDataClient;
    @Override
    public String getListOfCrypto(){
        return "ok";
    }

    @Override
    public List<Crypto> getAll() {
        return cryptoRepository.findAll();
    }

    @Override
    public void add(Crypto crypto) {
        cryptoRepository.save(crypto);
    }

    @Override
    public void delete(Long id) {
        cryptoRepository.deleteById(id);
    }
}

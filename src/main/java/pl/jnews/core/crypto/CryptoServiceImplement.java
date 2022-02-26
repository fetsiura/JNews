package pl.jnews.core.crypto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.jnews.infrastructure.cryptodata.CryptoDataClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoServiceImplement implements CryptoService{

    private final CryptoRepository cryptoRepository;
    private final CryptoDataClient cryptoDataClient;



    @Override
    public List<Crypto> getAllFromDatabase() {
        return cryptoRepository.findCryptoByNameAtoZ();
    }

    @Override
    public void getCryptoList(){
        cryptoDataClient.cryptoHandler().stream()
                .forEach(this::save);

    }

    @Override
    public void save(Crypto crypto) {
        cryptoRepository.save(crypto);
    }

}

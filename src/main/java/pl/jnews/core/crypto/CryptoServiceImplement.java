package pl.jnews.core.crypto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.jnews.infrastructure.cryptodata.CryptoDataClient;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoServiceImplement implements CryptoService{

    private final CryptoRepository cryptoRepository;
    private final CryptoDataClient cryptoDataClient;

    @Override
    public void addCryptoToDatabase(HttpSession session) {

        List<Crypto> cryptos = cryptoDataClient.cryptoHandler();
        cryptoRepository.saveAll(cryptos);
        session.setAttribute("cryptoLastUpdate",cryptos.get(0).getUpdated());
        log.info("Crypto download to database");
    }


    public Integer countAllCrypto(){
        return cryptoRepository.countAllCrypto();
    }

    public List<Crypto> findByNameASC(){
        return cryptoRepository.findCryptoByNameAtoZ();
    }


    public List<Crypto> findByPriceASC(){
        return cryptoRepository.findCryptoByPriceHighToLow();
    }
    public List<Crypto> findByPriceDESC(){
        return cryptoRepository.findCryptoByPriceLowToHigh();
    }

    public List<Crypto> findByNameStartsWith(String name){
        return cryptoRepository.findByNameStartsWith(name.toLowerCase(Locale.ROOT));
    }

}

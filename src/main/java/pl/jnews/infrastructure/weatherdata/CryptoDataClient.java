package pl.jnews.infrastructure.weatherdata;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CryptoDataClient {

    private final String urlCryptoList = "https://api.coingecko.com/api/v3/coins/list";
    private final RestTemplate restTemplate;

    public String cryptoList(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(" ","");
        HttpEntity entity = new HttpEntity(httpHeaders);

        ResponseEntity<CryptoListResponse> exchange = restTemplate.exchange(urlCryptoList,
                HttpMethod.GET,
                entity,
                CryptoListResponse.class);

        CryptoListResponse body = exchange.getBody();

        System.out.println(body.toString());
        return "ok";

    }
}

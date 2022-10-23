package ar.edu.unq.desapp.grupoj.desapp.client;

import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.CryptoValueDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BinanceClient {

    private final String binanceTickerPriceURL =  "https://api1.binance.com/api/v3/ticker/";

    public CryptoValueDto getPrice(String crypto) {
        return this.getPrices(List.of(crypto)).get(0);
    }

    public List<CryptoValueDto> getPrices(List<String> cryptoNames) {
        RestTemplate restTemplate = new RestTemplate();

        String stringValues = String.join("\",\"", cryptoNames);
        String url = binanceTickerPriceURL + "price?symbols=[\"" + stringValues + "\"]";

        ResponseEntity<List<CryptoValueDto>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }
}

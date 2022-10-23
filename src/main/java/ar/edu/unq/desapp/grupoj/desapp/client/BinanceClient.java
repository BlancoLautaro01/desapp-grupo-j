package ar.edu.unq.desapp.grupoj.desapp.client;

import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.CryptoValueDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BinanceClient {

    private final String binanceTickerPriceURL =  "https://api1.binance.com/api/v3/ticker/";

    public Double getPrice(String crypto) {
        return this.getPrices(List.of(crypto)).get(0).getPrice();
    }

    public List<CryptoValueDto> getPrices(List<String> cryptoNames) {
        RestTemplate restTemplate = new RestTemplate();

        String stringValues = String.join("\",\"", cryptoNames);
        String url = binanceTickerPriceURL + "price?symbols=[\"" + stringValues + "\"]";

        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);

        return response.getBody();
    }
}

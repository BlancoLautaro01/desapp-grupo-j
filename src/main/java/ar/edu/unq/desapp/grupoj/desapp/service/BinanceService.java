package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.CryptoValueDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BinanceService {

    private final String binanceTickerPriceURL =  "https://api1.binance.com/api/v3/ticker/";


    public Double getPrice(String crypto) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CryptoValueDto> response
                = restTemplate.getForEntity(binanceTickerPriceURL + "price?symbol=" + crypto, CryptoValueDto.class);

        return response.getBody().getPrice();
    }

    public List<CryptoValueDto> getPrices(List<String> cryptoNames) {
        System.out.println(cryptoNames);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> response
                = restTemplate.getForEntity(binanceTickerPriceURL + "price?symbols=" + cryptoNames, List.class);
//        Map<String, List<String>> params = new HashMap<String, List<String>>();
//        params.put("symbols", cryptoNames);
//        ResponseEntity<List> response
//                = restTemplate.getForEntity(binanceTickerPriceURL + "price", List.class, params);

        return response.getBody();

    }
}

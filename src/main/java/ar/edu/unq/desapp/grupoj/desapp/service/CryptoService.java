package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.client.BinanceClient;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.CryptoEnum;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.CryptoValueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoService {

    @Autowired
    private BinanceClient binanceClient;

    public List<CryptoValueDto> getAllPrices() {
        List<String> cryptoNames = CryptoEnum.stringValues();
        return binanceClient.getPrices(cryptoNames);
    }

    public Double getPrice(String crypto) {
        return binanceClient.getPrice(crypto).getPrice();
    }
}

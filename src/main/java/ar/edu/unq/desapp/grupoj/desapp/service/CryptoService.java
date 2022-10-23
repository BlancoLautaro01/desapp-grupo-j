package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.model.enums.CryptoEnum;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.CryptoValueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoService {

    @Autowired
    private BinanceService binanceService;

    public List<CryptoValueDto> getAllPrices() {
        List<String> cryptoNames = CryptoEnum.stringValues();
        return binanceService.getPrices(cryptoNames);
    }

    public Double getPrice(CryptoEnum cryptoEnum) {
        return binanceService.getPrice( cryptoEnum.getName());
    }
}

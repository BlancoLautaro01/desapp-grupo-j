package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.config.BinanceClient;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.CryptoEnum;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.CryptoValueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoService {

    @Autowired
    private BinanceClient binanceClient;

    public List<CryptoValueDto> getAllPrices() {
        List<String> cryptoNames = CryptoEnum.stringValues();
        /* TODO: Deberiamos llamar a binance para que nos de las cotizaciones de todos los cryptoactivos
        y mappear la lista a nuestro objeto List<CryptoValueDto>.
        */

        return new ArrayList<>();
    }
}

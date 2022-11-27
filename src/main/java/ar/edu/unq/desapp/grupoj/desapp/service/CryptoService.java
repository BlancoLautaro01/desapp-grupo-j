package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.client.BinanceClient;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Crypto;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.CryptoEnum;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.CryptoValueDto;
import ar.edu.unq.desapp.grupoj.desapp.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@EnableScheduling
public class CryptoService {

    @Autowired
    private BinanceClient binanceClient;

    @Autowired
    private CryptoRepository cryptoRepository;

    public List<CryptoValueDto> getAllPrices() {
        List<String> cryptoNames = CryptoEnum.stringValues();
        return binanceClient.getPrices(cryptoNames);
    }

    public Double getPrice(String crypto) {
        return binanceClient.getPrice(crypto).getPrice();
    }

    public List<Crypto> getAll24PricesBySymbol(String symbol) {
        return cryptoRepository.findAllCryptoFor(symbol);
    }

    private void saveAllCrypto() {
        List<CryptoValueDto> dtos = this.getAllPrices();
        List<Crypto> cryptos = new ArrayList<>();
        for(CryptoValueDto dto: dtos) {
            Crypto crypto = new Crypto();
            crypto.setSymbol(dto.getSymbol());
            crypto.setPrice(dto.getPrice());
            crypto.setUpdateTime(LocalDateTime.now());

            cryptos.add(crypto);
        }

        cryptoRepository.saveAll(cryptos);
    }

    private void deleteCryptoPast24hr() {
        cryptoRepository.deleteCryptoPast24hr(LocalDateTime.now().minusHours(24));
    }

    @Async
    @Scheduled(cron = "0 0 */1 * * *")
    public void updateCryptoData() {
        this.saveAllCrypto();
        this.deleteCryptoPast24hr();
    }
}

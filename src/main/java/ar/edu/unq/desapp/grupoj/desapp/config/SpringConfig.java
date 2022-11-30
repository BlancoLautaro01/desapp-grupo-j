package ar.edu.unq.desapp.grupoj.desapp.config;

import ar.edu.unq.desapp.grupoj.desapp.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Autowired
    private CryptoService cryptoService;

    @Scheduled(cron = "0 0 * * * *")
    public void updateCryptoData() {
        cryptoService.saveAllCrypto();
        cryptoService.deleteCryptoPast24hr();
    }
}
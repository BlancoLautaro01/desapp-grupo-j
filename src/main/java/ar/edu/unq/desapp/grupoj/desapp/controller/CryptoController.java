package ar.edu.unq.desapp.grupoj.desapp.controller;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.Crypto;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.dto.CryptoValueDto;
import ar.edu.unq.desapp.grupoj.desapp.service.CryptoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crypto")
@Api(value = "", tags={"Crypto Controller"})
@Tag(name = "Crypto Controller", description = "Crypto Methods")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/getPrices")
    public List<CryptoValueDto> getCryptoPrices() {
        return cryptoService.getAllPrices();
    }

    @GetMapping("/getPrices/{symbol}/24hs")
    public List<Crypto> getCryptoPrices(@PathVariable String symbol) {
        return cryptoService.getAll24PricesBySymbol(symbol);
    }
}

package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.config.BinanceClient;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.InvalidOfferRequestException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.CryptoEnum;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType;
import ar.edu.unq.desapp.grupoj.desapp.model.inout.request.OfferRequest;
import ar.edu.unq.desapp.grupoj.desapp.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service 
public class OfferService {

    @Value("${dolar.ars.value}")
    private Integer dolarArsValue;

    @Autowired
    private BinanceClient binanceClient;

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> findAll() {
        return (List<Offer>) offerRepository.findAll();
    }

    public Offer createOffer(OfferRequest offerRequest) throws InvalidOfferRequestException {
        this.validateRequest(offerRequest);

        // TODO: Tenemos que ver como sacar el user loggeado desde el token de autorizacion.
        User user = new User();

        // TODO: Este precio hay que buscarlo en Binance con el request.getCrypto().
        // Double cryptocurrencyPrice = binanceClient.getPrice(request.getCrypto());
        Double cryptocurrencyPrice = 1.0;

        this.setMissingProperties(offerRequest, cryptocurrencyPrice);
        Integer typeId = OfferType.valueOf(offerRequest.getType()).getOfferTypeID();

        Offer offer = new Offer(
                null,
                offerRequest.getCrypto(),
                offerRequest.getCryptoAmount(),
                cryptocurrencyPrice,
                offerRequest.getArsAmount(),
                user,
                typeId,
                1
        );

        return offerRepository.save(offer);
    }

    private void validateRequest(OfferRequest offerRequest) throws InvalidOfferRequestException {
        if(!CryptoEnum.stringValues().contains(offerRequest.getCrypto())) {
            throw new InvalidOfferRequestException(
                    "Invalid Crypto. Available values are: " + CryptoEnum.concatenatedStringValues());
        }
        if(!Objects.equals(offerRequest.getType(), "BUY") && !Objects.equals(offerRequest.getType(), "SELL")) {
            throw new InvalidOfferRequestException(
                    "Invalid Type. Available values are: BUY/SELL.");
        }
        if((offerRequest.getCryptoAmount() == null && offerRequest.getArsAmount() == null) ||
            (offerRequest.getCryptoAmount() != null && offerRequest.getArsAmount() != null)) {
            throw new InvalidOfferRequestException(
                    "CryptoAmount and ArsAmount can't be both setted or both nulls.");
        }
    }

    private void setMissingProperties(OfferRequest offerRequest, Double cryptocurrencyPrice) {
        if(offerRequest.getArsAmount() == null) {
            Double arsAmount = (cryptocurrencyPrice * dolarArsValue) * offerRequest.getCryptoAmount();
            offerRequest.setArsAmount(arsAmount);
        } else {
            Double cryptoAmount = offerRequest.getArsAmount() / (cryptocurrencyPrice * dolarArsValue);
            offerRequest.setArsAmount(cryptoAmount);
        }
    }
}

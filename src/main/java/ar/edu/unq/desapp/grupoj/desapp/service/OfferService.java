package ar.edu.unq.desapp.grupoj.desapp.service;

import ar.edu.unq.desapp.grupoj.desapp.exception.cases.InvalidOfferRequestException;
import ar.edu.unq.desapp.grupoj.desapp.exception.cases.UserNotFoundException;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.CryptoEnum;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferTypeEnum;
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
    private Integer dollarArsValue;

    @Autowired
    private CryptoService cryptoService;

    @Autowired
    private UserService userService;

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> findAll() {
        return offerRepository.findAllByStateId(1);
    }

    public Offer createOffer(OfferRequest offerRequest) throws InvalidOfferRequestException, UserNotFoundException {
        this.validateRequest(offerRequest);

        User user = userService.getLoggedUser();

        Double cryptocurrencyPrice = cryptoService.getPrice(offerRequest.getCrypto());

        this.setMissingProperties(offerRequest, cryptocurrencyPrice);

        Integer typeId = OfferTypeEnum.valueOf(offerRequest.getType()).getOfferTypeID();

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
            Double arsAmount = (cryptocurrencyPrice * dollarArsValue) * offerRequest.getCryptoAmount();
            offerRequest.setArsAmount(arsAmount);
        } else {
            Double cryptoAmount = offerRequest.getArsAmount() / (cryptocurrencyPrice * dollarArsValue);
            offerRequest.setCryptoAmount(cryptoAmount);
        }
    }
}

package ar.edu.unq.desapp.grupoj.desapp.model;

import ar.edu.unq.desapp.grupoj.desapp.factories.OfferFactory;
import ar.edu.unq.desapp.grupoj.desapp.factories.UserFactory;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferTypeEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferStateEnum.FINISHED;
import static ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferTypeEnum.BUY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OfferTest {

    private Validator validator;

    @BeforeAll
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void offerConstructorIsAutoGenerated() throws Exception {
        Integer userId = 1;
        OfferTypeEnum buyOfferType = BUY;

        Integer offerId = 1;
        String cryptocurrency = "cryptocurrency";
        Double cryptocurrencyAmount = 2d;
        Double cryptocurrencyPrice = 10d;
        Double arsAmount = 300d;
        User user = UserFactory.anyUserWithId(userId);
        Integer typeId = buyOfferType.getOfferTypeID();
        Integer stateId = FINISHED.getOfferStateID();


        Offer offer = OfferFactory.createOffer(offerId, cryptocurrency, cryptocurrencyAmount, cryptocurrencyPrice, arsAmount, user, typeId, stateId);


        assertEquals(offer.getOfferId(), offerId);
        assertEquals(offer.getCryptocurrency(), cryptocurrency);
        assertEquals(offer.getCryptocurrencyAmount(), cryptocurrencyAmount);
        assertEquals(offer.getCryptocurrencyPrice(), cryptocurrencyPrice);
        assertEquals(offer.getArsAmount(), arsAmount);
        assertEquals(offer.getUser().getUserId(), userId);
        assertEquals(offer.getTypeId(), typeId);
        assertEquals(offer.getStateId(), stateId);
        assertEquals(offer.getOfferType(), buyOfferType);
    }
}

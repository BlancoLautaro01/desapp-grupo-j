package ar.edu.unq.desapp.grupoj.desapp.model;

import ar.edu.unq.desapp.grupoj.desapp.factories.OfferFactory;
import ar.edu.unq.desapp.grupoj.desapp.factories.UserFactory;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferState.FINISHED;
import static ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType.BUY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OfferTest {

    @Test
    public void offerConstructorIsAutoGenerated() throws Exception {
        Integer userId = 1;
        OfferType buyOfferType = BUY;

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
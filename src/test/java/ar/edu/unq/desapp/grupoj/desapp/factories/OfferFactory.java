package ar.edu.unq.desapp.grupoj.desapp.factories;


import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;

public class OfferFactory {

    public static Offer createOffer(Integer offerId, String cryptocurrency, Double cryptocurrencyAmount, Double cryptocurrencyPrice, Double arsAmount, User user, Integer typeId, Integer stateId) {
        Offer offer = new Offer(offerId, cryptocurrency, cryptocurrencyAmount, cryptocurrencyPrice, arsAmount, user, typeId, stateId);
        return offer;
    }
}

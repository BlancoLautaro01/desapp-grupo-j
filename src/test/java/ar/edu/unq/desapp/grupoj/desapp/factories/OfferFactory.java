package ar.edu.unq.desapp.grupoj.desapp.factories;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;

public class OfferFactory {

    public static Offer anyOfferWithId(Integer id) {
        Offer offer = new Offer();
        offer.setOfferId(id);
        return offer;
    }

    public static Offer anyOfferWithCryptocurrency(String crypto) {
        Offer offer = new Offer();
        offer.setCryptocurrency(crypto);
        return offer;
    }

    public static Offer anyOfferWithCryptocurrencyAmount(Double amount) {
        Offer offer = new Offer();
        offer.setCryptocurrencyAmount(amount);
        return offer;
    }

    public static Offer anyOfferWithCryptocurrencyPrice(Double price) {
        Offer offer = new Offer();
        offer.setCryptocurrencyPrice(price);
        return offer;
    }

    public static Offer anyOfferWithArsAmount(Double amount) {
        Offer offer = new Offer();
        offer.setArsAmount(amount);
        return offer;
    }

    public static Offer anyOfferWithTypeId(Integer typeId) {
        Offer offer = new Offer();
        offer.setTypeId(typeId);
        return offer;
    }

    public static Offer anyOfferWithStateId(Integer stateId) {
        Offer offer = new Offer();
        offer.setStateId(stateId);
        return offer;
    }
}

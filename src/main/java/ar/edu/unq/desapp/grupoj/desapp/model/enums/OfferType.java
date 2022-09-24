package ar.edu.unq.desapp.grupoj.desapp.model.enums;


public enum OfferType {

    SELL(1),
    BUY(2);

    private final Integer offerTypeID;

    OfferType(Integer offerTypeID){
        this.offerTypeID = offerTypeID;
    }

    public Integer getOfferTypeID(){
        return this.offerTypeID;
    }

    public static OfferType fromId(Integer offerTypeID) throws Exception {
        switch (offerTypeID) {
            case 1: return OfferType.SELL;
            case 2: return OfferType.BUY;
            default:
                throw new Exception();
        }
    }
}

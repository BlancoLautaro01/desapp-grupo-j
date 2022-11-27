package ar.edu.unq.desapp.grupoj.desapp.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum OfferTypeEnum {

    SELL(1),
    BUY(2);

    private final Integer offerTypeID;

    OfferTypeEnum(Integer offerTypeID){
        this.offerTypeID = offerTypeID;
    }

    public Integer getOfferTypeID(){
        return this.offerTypeID;
    }

    public static OfferTypeEnum fromId(Integer offerTypeID) throws Exception {
        switch (offerTypeID) {
            case 1: return OfferTypeEnum.SELL;
            case 2: return OfferTypeEnum.BUY;
            default:
                throw new Exception();
        }
    }

    public static List<Integer> ids() {
        List<Integer> ids = new ArrayList<>();
        for(OfferTypeEnum type: OfferTypeEnum.values()) {
            ids.add(type.getOfferTypeID());
        }

        return ids;
    }
}

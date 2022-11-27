package ar.edu.unq.desapp.grupoj.desapp.model.enums;

public enum OfferStateEnum {
    ACTIVE(1),
    IN_PROGRESS(2),
    FINISHED(3),
    CANCEL(4);

    private final Integer offerStateID;

    OfferStateEnum(Integer offerStateID){
        this.offerStateID = offerStateID;
    }

    public Integer getOfferStateID(){
        return this.offerStateID;
    }

    public OfferStateEnum fromId(Integer offerStateID) throws Exception {
        switch (offerStateID) {
            case 1: return OfferStateEnum.ACTIVE;
            case 2: return OfferStateEnum.FINISHED;
            case 3: return OfferStateEnum.CANCEL;
            default:
                throw new Exception();
        }
    }
}

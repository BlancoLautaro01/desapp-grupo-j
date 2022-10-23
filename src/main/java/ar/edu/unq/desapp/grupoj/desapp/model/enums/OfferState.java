package ar.edu.unq.desapp.grupoj.desapp.model.enums;

public enum OfferState {
    ACTIVE(1),
    IN_PROGRESS(2),
    FINISHED(3),
    CANCEL(4);

    private final Integer offerStateID;

    OfferState(Integer offerStateID){
        this.offerStateID = offerStateID;
    }

    public Integer getOfferStateID(){
        return this.offerStateID;
    }

    public OfferState fromId(Integer offerStateID) throws Exception {
        switch (offerStateID) {
            case 1: return OfferState.ACTIVE;
            case 2: return OfferState.FINISHED;
            case 3: return OfferState.CANCEL;
            default:
                throw new Exception();
        }
    }
}

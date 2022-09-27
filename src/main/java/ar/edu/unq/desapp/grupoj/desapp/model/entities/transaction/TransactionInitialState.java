package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType;

public class TransactionInitialState implements TransactionState {

    private Transaction transaction;

    public TransactionInitialState(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String getAction() {
        return null;
    }

    @Override
    public String getDepositAddress() throws Exception {
        if(transaction.getOffer().getOfferType() == OfferType.SELL) {
            return transaction.getOffer().getUser().getCvu();
        } else {
            return transaction.getUser().getCvu();
        }
    }
}

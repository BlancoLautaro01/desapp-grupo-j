package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType;

public class TransactionPaymentDoneState implements TransactionState {

    private Transaction transaction;

    public TransactionPaymentDoneState(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String getAction() {
        return "Crypto Payment should released to the deposit address.";
    }

    @Override
    public String getDepositAddress() throws Exception {
        if(transaction.getOffer().getOfferType() == OfferType.SELL) {
            return transaction.getUser().getCryptoWallet();
        } else {
            return transaction.getOffer().getUser().getCryptoWallet();
        }
    }
}

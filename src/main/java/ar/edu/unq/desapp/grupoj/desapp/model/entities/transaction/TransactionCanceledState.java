package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

public class TransactionCanceledState implements TransactionState {
    @Override
    public String getAction() {
        return null;
    }

    @Override
    public String getDepositAddress() {
        return "Transaction Canceled.";
    }
}

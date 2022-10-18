package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

public class TransactionCanceledState implements TransactionState {
    @Override
    public String getAction() {
        return "Transaction Canceled.";
    }

    @Override
    public String getDepositAddress() {
        return "Transaction Canceled.";
    }
}

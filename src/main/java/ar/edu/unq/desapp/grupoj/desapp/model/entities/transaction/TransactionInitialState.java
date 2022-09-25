package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

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
    public String getDepositAddress() {
        return null;
    }
}

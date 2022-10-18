package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

public class TransactionFinishedState implements TransactionState {
    @Override
    public String getAction() {
        return "Transaction Completed.";
    }

    @Override
    public String getDepositAddress() {
        return "Transaction Completed.";
    }
}

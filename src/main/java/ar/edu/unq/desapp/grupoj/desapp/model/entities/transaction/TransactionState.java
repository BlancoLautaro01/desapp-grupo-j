package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

public interface TransactionState {
    public String getAction();
    public String getDepositAddress() throws Exception;
}

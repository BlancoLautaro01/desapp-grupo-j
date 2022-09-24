package ar.edu.unq.desapp.grupoj.desapp.model.enums;

public enum TransactionState {

    INITIATED(1),
    PAYMENT_DONE(2),
    FINISHED(3),
    CANCEL(4);

    private final Integer transactionStateID;

    TransactionState(Integer transactionStateID){
        this.transactionStateID = transactionStateID;
    }

    public Integer getTransactionStateID(){
        return this.transactionStateID;
    }

    public TransactionState fromId(Integer transactionStateID) throws Exception {
        switch (transactionStateID) {
            case 1: return TransactionState.INITIATED;
            case 2: return TransactionState.PAYMENT_DONE;
            case 4: return TransactionState.FINISHED;
            case 3: return TransactionState.CANCEL;
            default:
                throw new Exception();
        }
    }
}

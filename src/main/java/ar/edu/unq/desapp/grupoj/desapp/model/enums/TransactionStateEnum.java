package ar.edu.unq.desapp.grupoj.desapp.model.enums;

public enum TransactionStateEnum {

    INITIATED(1),
    PAYMENT_DONE(2),
    FINISHED(3),
    CANCELED(4);

    private final Integer transactionStateID;

    TransactionStateEnum(Integer transactionStateID){
        this.transactionStateID = transactionStateID;
    }

    public Integer getTransactionStateID(){
        return this.transactionStateID;
    }

    public TransactionStateEnum fromId(Integer transactionStateID) throws Exception {
        switch (transactionStateID) {
            case 1: return TransactionStateEnum.INITIATED;
            case 2: return TransactionStateEnum.PAYMENT_DONE;
            case 4: return TransactionStateEnum.FINISHED;
            case 3: return TransactionStateEnum.CANCELED;
            default:
                throw new Exception();
        }
    }
}

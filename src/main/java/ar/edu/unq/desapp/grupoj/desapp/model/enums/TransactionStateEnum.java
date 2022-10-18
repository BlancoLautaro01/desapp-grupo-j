package ar.edu.unq.desapp.grupoj.desapp.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum TransactionStateEnum {

    INITIATED(1, "INITIATED"),
    PAYMENT_DONE(2, "PAYMENT_DONE"),
    FINISHED(3, "FINISHED"),
    CANCELED(4, "CANCELED");

    private final Integer transactionStateID;
    private final String name;

    TransactionStateEnum(Integer transactionStateID, String name) {
        this.transactionStateID = transactionStateID;
        this.name = name;
    }

    public Integer getTransactionStateID(){
        return this.transactionStateID;
    }
    public String getName(){
        return this.name;
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

    public static List<String> stringValues() {
        List<String> stringValues = new ArrayList<>();
        for(TransactionStateEnum state: TransactionStateEnum.values()) {
            stringValues.add(state.getName());
        }

        return stringValues;
    }
}

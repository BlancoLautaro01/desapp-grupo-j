package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.TransactionStateEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    private Integer transactionId;

    @JoinColumn
    @ManyToOne
    private Offer offer;

    @JoinColumn
    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Integer stateId;

    @Transient
    private TransactionState state = this.getTransactionState();

    public String getAction() {
        return this.getState().getAction();
    }

    public String getDepositAddress() throws Exception {
        return this.getState().getDepositAddress();
    }

    private TransactionState getTransactionState() {
        return switch (this.getStateId()) {
            case 1 -> new TransactionInitialState(this);
            case 2 -> new TransactionPaymentDoneState(this);
            case 3 -> new TransactionFinishedState();
            default -> new TransactionCanceledState();
        };
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
        this.state = this.getTransactionState();
    }

}

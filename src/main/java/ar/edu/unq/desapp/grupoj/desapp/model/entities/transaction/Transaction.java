package ar.edu.unq.desapp.grupoj.desapp.model.entities.transaction;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType;
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
    private TransactionState state = new TransactionInitialState(this);

    public String getAction() {
        return this.state.getAction();
    }

    public String getDepositAddress() {
        return this.state.getDepositAddress();
    }

}

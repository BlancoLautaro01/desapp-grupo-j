package ar.edu.unq.desapp.grupoj.desapp.model.entities;

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

//    public String getDepositAddress() throws Exception {
//        if(offer.getOfferType() == OfferType.BUY) {
//            return user.getCvu();
//        } else {
//            return offer.getUser().getCvu();
//        }
//    }

}

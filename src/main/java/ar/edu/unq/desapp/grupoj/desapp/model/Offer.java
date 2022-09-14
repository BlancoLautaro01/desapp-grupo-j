package ar.edu.unq.desapp.grupoj.desapp.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "offer")
public class Offer {

    @Id
    private Integer offerId;

    @NotNull
    @Column
    private Criptocurrency criptocurrency;

    @NotNull
    @Column
    @Min(0)
    private Double amount;

    @NotNull
    @Column
    @Min(0)
    private Double price;

    @JoinColumn
    @ManyToOne
    private User user;

    @Column
    private OfferType type;

    @Column
    private OfferState state;

    public Double getArgValue() {
//        return this.criptocurrency.getPrice() * this.amount;
        return 0.0;
    }

    public String getUser() {
        return user.getName() + " " + user.getSurname();
    }
}

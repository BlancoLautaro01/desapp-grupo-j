package ar.edu.unq.desapp.grupoj.desapp.model.entities;

import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType;
import ar.edu.unq.desapp.grupoj.desapp.validation.ValidCrypto;
import ar.edu.unq.desapp.grupoj.desapp.validation.ValidOfferType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "offer")
public class Offer {

    @Id
    private Integer offerId;

    @Column(nullable = false)
    @ValidCrypto
    private String cryptocurrency;

    @Column(nullable = false)
    @Min(0)
    private Double cryptocurrencyAmount;

    @Column(nullable = false)
    @Min(0)
    private Double cryptocurrencyPrice;

    @Column(nullable = false)
    @Min(0)
    private Double arsAmount;

    @JoinColumn
    @ManyToOne
    private User user;

    @Column(nullable = false)
    @ValidOfferType
    private Integer typeId;

    @Column(nullable = false)
    private Integer stateId;

    public OfferType getOfferType() throws Exception {
        return OfferType.fromId(this.getTypeId());
    }
}

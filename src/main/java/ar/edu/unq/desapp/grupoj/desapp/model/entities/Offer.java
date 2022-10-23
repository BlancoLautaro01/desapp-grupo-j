package ar.edu.unq.desapp.grupoj.desapp.model.entities;

import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer offerId;

    @Column(nullable = false)
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
    private Integer typeId;

    @Column(nullable = false)
    private Integer stateId;

    public OfferType getOfferType() throws Exception {
        return OfferType.fromId(this.getTypeId());
    }
}
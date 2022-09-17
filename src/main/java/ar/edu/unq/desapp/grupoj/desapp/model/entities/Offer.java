package ar.edu.unq.desapp.grupoj.desapp.model.entities;

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
    private String cryptocurrency;

    @NotNull
    @Column
    @Min(0)
    private Double cryptocurrencyAmount;

    @NotNull
    @Column
    @Min(0)
    private Double cryptocurrencyPrice;

    @NotNull
    @Column
    @Min(0)
    private Double arsAmount;

    @JoinColumn
    @ManyToOne
    private User user;

    @Column
    private Integer typeId;

    @Column
    private Integer stateId;

    public String getUser() {
        return user.getName() + " " + user.getSurname();
    }
}

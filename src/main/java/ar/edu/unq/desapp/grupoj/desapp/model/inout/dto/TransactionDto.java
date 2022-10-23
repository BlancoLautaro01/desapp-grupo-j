package ar.edu.unq.desapp.grupoj.desapp.model.inout.dto;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private Integer transactionId;
    private String creationDate;
    private Offer offer;
    private User loggedUser;
    private String action;
    private String actualAddress;
}

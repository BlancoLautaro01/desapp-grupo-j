package ar.edu.unq.desapp.grupoj.desapp.model.inout.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequest {

    private String crypto;
    private String type;
    private Double cryptoAmount;
    private Double arsAmount;
}

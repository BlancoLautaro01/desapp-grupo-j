package ar.edu.unq.desapp.grupoj.desapp.model.inout;

import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferListDto {

    private List<Offer> offer;
}

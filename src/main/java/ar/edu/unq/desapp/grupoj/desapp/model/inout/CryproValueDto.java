package ar.edu.unq.desapp.grupoj.desapp.model.inout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryproValueDto {

    private String crypto;
    private Double price;
}
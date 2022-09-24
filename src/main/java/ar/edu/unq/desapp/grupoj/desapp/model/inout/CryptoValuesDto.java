package ar.edu.unq.desapp.grupoj.desapp.model.inout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoValuesDto {

    private List<CryproValueDto> prices;
}

package ar.edu.unq.desapp.grupoj.desapp.model.inout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyValuesDto {

    private String cryptocurrency;
    private List<HourPriceDto> dailyValues;
}
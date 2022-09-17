package ar.edu.unq.desapp.grupoj.desapp.model.inout;

import lombok.Data;

import java.util.Date;

@Data
public class DailyValueDto {

    private String cryptocurrency;
    private Date date;
    private Double value;
}

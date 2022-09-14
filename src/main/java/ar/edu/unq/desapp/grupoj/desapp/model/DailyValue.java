package ar.edu.unq.desapp.grupoj.desapp.model;

import lombok.Data;

import java.util.Date;

@Data
public class DailyValue {

    private Criptocurrency criptocurrency;
    private Date date;
    private Double value;
}

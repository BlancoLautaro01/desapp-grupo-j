package ar.edu.unq.desapp.grupoj.desapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cryptos")
public class Crypto {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String symbol;
    @Column
    private Double price;
    @Column
    private LocalDateTime updateTime;
}
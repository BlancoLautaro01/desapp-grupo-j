package ar.edu.unq.desapp.grupoj.desapp.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Integer userId;

    @NotNull
    @Column
    @Length(min = 3, max = 30)
    private String name;

    @NotNull
    @Column
    @Length(min = 3, max = 30)
    private String surname;

    @NotNull
    @Column
    @Email
    private String email;

    @NotNull
    @Column
    @Length(min = 3, max = 30)
    private String address;

    @NotNull
    @Column
    @Length(min = 22, max = 22)
    private String cvu;

    @NotNull
    @Column(unique = true)
    @Length(min = 8, max = 8)
    private String cripto;

}

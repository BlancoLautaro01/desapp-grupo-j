package ar.edu.unq.desapp.grupoj.desapp.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Integer userId;

    @NotNull
    @Column
    @Length(min = 3, max = 30, message = "The name must have a minimum of 3 and a maximum of 30 characters")
    private String name;

    @NotNull
    @Column
    @Length(min = 3, max = 30, message = "The surname must have a minimum of 3 and a maximum of 30 characters")
    private String surname;

    @NotNull
    @Column
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\-]]).{6,}$", message = "Password must contain at least 1 lowercase, 1 uppercase, 1 special character and a minimum of 6 characters")
    private String password;

    @NotNull
    @Column
    @Email(message = "Invalid email")
    private String email;

    @NotNull
    @Column
    @Length(min = 10, max = 30, message = "The address must have a minimum of 10 and a maximum of 30 characters")
    private String address;

    @NotNull
    @Column
    @Pattern(regexp = "^\\d{22}", message = "Mercado Pago CVU length must be of 22 digits")
    private String cvu;

    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "^\\d{8}", message = "Crypto Wallet Address length must be of 8 digits")
    private String crypto;

}

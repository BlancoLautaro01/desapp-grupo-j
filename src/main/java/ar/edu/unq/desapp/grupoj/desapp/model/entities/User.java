package ar.edu.unq.desapp.grupoj.desapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    @Length(min = 3, max = 30, message = "The name must have a minimum of 3 and a maximum of 30 characters")
    private String name;

    @Column(nullable = false)
    @Length(min = 3, max = 30, message = "The surname must have a minimum of 3 and a maximum of 30 characters")
    private String surname;

    @Column(nullable = false)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\-]]).{6,}$", message = "Password must contain at least 1 lowercase, 1 uppercase, 1 special character and a minimum of 6 characters")
    private String password;

    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email")
    private String email;

    @Column(nullable = false)
    @Length(min = 10, max = 30, message = "The address must have a minimum of 10 and a maximum of 30 characters")
    private String address;

    @Column(nullable = false)
    @Pattern(regexp = "^\\d{22}", message = "Mercado Pago CVU length must be of 22 digits")
    private String cvu;

    @Column(unique = true, nullable = false)
    @Pattern(regexp = "^\\d{8}", message = "Crypto Wallet Address length must be of 8 digits")
    private String cryptoWallet;

    @Column(nullable = false)
    private Integer operationAmount = 0;

    @Column(nullable = false)
    private Integer score = 0;

    public Double getReputation() {
        return (this.operationAmount == 0
                ? 0
                : ((double) this.score / this.operationAmount));
    }

    public void sumScore(Integer sum) {
        this.score += sum;
    }

    public void substractScore(Integer sub) {
        this.score += sub;
    }

    public void sumOperation() { this.operationAmount += 1; }
}

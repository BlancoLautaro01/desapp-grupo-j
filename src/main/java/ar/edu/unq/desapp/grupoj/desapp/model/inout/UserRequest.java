package ar.edu.unq.desapp.grupoj.desapp.model.inout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String surname;
    private String password;
    private String email;
    private String address;
    private String cvu;
    private String cryptoWallet;
}

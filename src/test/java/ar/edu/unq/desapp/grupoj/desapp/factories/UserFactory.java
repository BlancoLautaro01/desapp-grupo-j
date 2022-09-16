package ar.edu.unq.desapp.grupoj.desapp.factories;

import ar.edu.unq.desapp.grupoj.desapp.model.User;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserFactory {

    private Integer defaultUserId;

    private String defaultName;

    private String defaultSurname;

    private String defaultPassword;

    private String defaultEmail;

    private String defaultAddress;

    private String defaultCVU;

    private String defaultCrypto;

    private User createUser( Integer defaultUserId, String defaultName, String defaultSurname, String defaultPassword, String defaultEmail, String defaultAddress, String defaultCVU, String defaultCrypto){
        return new User()
    }

    static User anyUserWithName
}

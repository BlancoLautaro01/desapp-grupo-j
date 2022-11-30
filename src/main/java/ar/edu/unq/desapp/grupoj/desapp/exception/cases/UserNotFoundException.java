package ar.edu.unq.desapp.grupoj.desapp.exception.cases;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotFoundException extends Exception {

    private String message;

    public String getMessage() {
        return this.message;
    }
}

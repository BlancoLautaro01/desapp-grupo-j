package ar.edu.unq.desapp.grupoj.desapp.exception.cases;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InvalidJWTException extends Exception {

    private String message;

    public String getMessage() {
        return this.message;
    }
}

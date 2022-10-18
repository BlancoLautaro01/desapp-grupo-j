package ar.edu.unq.desapp.grupoj.desapp.exception.cases;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class TransactionNotFoundException extends Exception {

    private String message;

    public String getMessage() {
        return this.message;
    }
}

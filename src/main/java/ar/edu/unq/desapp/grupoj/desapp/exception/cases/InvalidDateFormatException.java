package ar.edu.unq.desapp.grupoj.desapp.exception.cases;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class InvalidDateFormatException extends Exception {

    public String getMessage() {
        return "Invalid date format. Should be yyyy-mm-dd.";
    }
}

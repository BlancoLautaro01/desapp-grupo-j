package ar.edu.unq.desapp.grupoj.desapp.exception.cases;

public class InvalidDateFormatException extends Exception {

    public String getMessage() {
        return "Invalid date format. Should be yyyy-mm-dd.";
    }
}

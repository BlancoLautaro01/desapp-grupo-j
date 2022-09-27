package ar.edu.unq.desapp.grupoj.desapp.model;

import ar.edu.unq.desapp.grupoj.desapp.factories.OfferFactory;
import ar.edu.unq.desapp.grupoj.desapp.model.entities.Offer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OfferTest {
    private Validator validator;

    @BeforeAll
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void anOfferHaveAnId() {
        Integer id = 1;
        Offer offer = OfferFactory.anyOfferWithId(id);

        assertEquals(offer.getOfferId(), id);
    }

    private void assertIsNotValidOfferWith(String expectedErrorMessage, Offer offer) {
        Set<ConstraintViolation<Offer>> violations = validator.validate(offer);

        StringBuilder errorMessage = new StringBuilder();
        for (ConstraintViolation<Offer> violation: violations) {
            errorMessage.append(violation.getMessage());
        }
        assertEquals(expectedErrorMessage, errorMessage.toString());
    }

    private void assertIsValidOffer(Offer offer) {
        Set<ConstraintViolation<Offer>> violations = validator.validate(offer);

        assertTrue(violations.isEmpty());
    }
}

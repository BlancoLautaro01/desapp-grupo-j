package ar.edu.unq.desapp.grupoj.desapp.validation;

import ar.edu.unq.desapp.grupoj.desapp.model.enums.OfferType;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OfferTypeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidOfferType {
    String message() default "OfferType id not found.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class OfferTypeValidator implements ConstraintValidator<ValidOfferType, Integer> {

    @Override
    public void initialize(ValidOfferType status) {
    }

    @Override
    public boolean isValid(Integer offerType, ConstraintValidatorContext ctx) {
        return OfferType.ids().contains(offerType);
    }
}
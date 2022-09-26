package ar.edu.unq.desapp.grupoj.desapp.validation;

import ar.edu.unq.desapp.grupoj.desapp.model.enums.CryptoEnum;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CryptoValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCrypto {
    String message() default "Crypto name not found.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class CryptoValidator implements ConstraintValidator<ValidCrypto, String> {

    @Override
    public void initialize(ValidCrypto status) {
    }

    @Override
    public boolean isValid(String crypto, ConstraintValidatorContext ctx) {
        return CryptoEnum.stringValues().contains(crypto);
    }
}
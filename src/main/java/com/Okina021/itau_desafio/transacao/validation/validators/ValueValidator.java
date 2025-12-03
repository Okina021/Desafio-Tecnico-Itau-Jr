package com.Okina021.itau_desafio.transacao.validation.validators;

import com.Okina021.itau_desafio.transacao.validation.annotations.ValueValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValueValidator implements ConstraintValidator<ValueValidation, Double> {

    private boolean notNull;
    private boolean notNegative;
    private int scale;

    @Override
    public void initialize(ValueValidation annotation) {
        this.notNull = annotation.notNull();
        this.notNegative = annotation.notNegative();
        this.scale = annotation.scale();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {

        if (value == null) {
            if (notNull) {
                setMessage(context, "O valor não pode ser nulo");
                return false;
            }
            return true;
        }

        if (notNegative && value < 0) {
            setMessage(context, "O valor não pode ser negativo");
            return false;
        }

        return true;
    }

    private void setMessage(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}

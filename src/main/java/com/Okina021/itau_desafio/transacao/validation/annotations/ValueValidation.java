package com.Okina021.itau_desafio.transacao.validation.annotations;

import com.Okina021.itau_desafio.transacao.validation.validators.ValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValueValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.RECORD_COMPONENT })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueValidation {

    boolean notNull() default true;
    boolean notNegative() default true;
    int scale() default 2;

    String message() default "";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
package com.hb.platform.notemanager.services;

;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ModelValidator {

    private final Validator validator;

    public ModelValidator(Validator validator) {
        this.validator = validator;
    }

    public <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolationSet = validator.validate(obj);
        if (!constraintViolationSet.isEmpty()) {
            throw new ConstraintViolationException(constraintViolationSet);
        }
    }
}

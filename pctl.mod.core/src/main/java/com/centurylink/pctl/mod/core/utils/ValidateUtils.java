package com.centurylink.pctl.mod.core.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidateUtils<T> {

    T t;

    public Response<T> validateBean(T object) {
        Response<T> response = null;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        if (object != null) {
            Set<ConstraintViolation<T>> violations = validator.validate(object);
            if (violations != null && !violations.isEmpty()) {
                response = new Response();
                response.setStatus(StatusCode.E400);
                for (ConstraintViolation constraintViolation : violations)
                    response.addMessage(constraintViolation.getMessage());
                response.setContent(object);
            }
        } else {
            response = new Response();
            response.setStatus(StatusCode.E400);
        }
        return response;
    }
}

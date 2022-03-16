package com.alexandrepossari.springproject.adapter.in.web.user.v1;

import com.alexandrepossari.springproject.adapter.in.web.user.v1.request.UserRequest;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.alexandrepossari.springproject.application.exception.ErrorReason.*;

@Component
public class UserControllerRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequest request = (UserRequest) target;

        if (!StringUtils.hasLength(request.getEmail()) || !EmailValidator.getInstance().isValid(request.getEmail())) {
            errors.reject(INVALID_EMAIL.getCode(), INVALID_EMAIL.getMessage());
        }

        if (!StringUtils.hasText(request.getNome())) {
            errors.reject(INVALID_NAME.getCode(), INVALID_NAME.getMessage());
        }

        if (!StringUtils.hasText(request.getPassword())) {
            errors.reject(INVALID_PASSWORD.getCode(), INVALID_PASSWORD.getMessage());
        }
    }
}

package com.alexandrepossari.springproject.adapter.in.web.post.v1;

import com.alexandrepossari.springproject.adapter.in.web.post.v1.request.PostRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.alexandrepossari.springproject.application.exception.ErrorReason.INVALID_CONTENT;
import static com.alexandrepossari.springproject.application.exception.ErrorReason.INVALID_USER_ID;

@Component
public class PostControllerRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PostRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostRequest request = (PostRequest) target;

        if (!StringUtils.hasText(request.getContent())) {
            errors.reject(INVALID_CONTENT.getCode(), INVALID_CONTENT.getMessage());
        }

        if (ObjectUtils.isEmpty(request.getUserId())) {
            errors.reject(INVALID_USER_ID.getCode(), INVALID_USER_ID.getMessage());
        }
    }
}

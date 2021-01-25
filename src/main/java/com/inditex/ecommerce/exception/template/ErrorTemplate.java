package com.inditex.ecommerce.exception.template;

import org.springframework.http.HttpStatus;

public interface ErrorTemplate {

    String getErrorId();

    String getMessageTemplate();

    String getHowToSolve();

    HttpStatus getHttpStatus();

    boolean isBadRequest();

    boolean isRetryable();
}

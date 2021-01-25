package com.inditex.ecommerce.exception;

import java.io.Serializable;

import com.inditex.ecommerce.exception.model.ExceptionMessageBuilder;
import com.inditex.ecommerce.exception.template.ErrorParameters;
import com.inditex.ecommerce.exception.template.ErrorTemplate;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1971136787239741648L;

    private final ErrorTemplate template;
    private final ErrorParameters parameters;

    public ServiceException(Throwable cause, ErrorTemplate template, ErrorParameters parameters) {
        if (cause != null) {
            this.initCause(cause);
        }
        this.template = template;
        this.parameters = parameters;
    }

    @Override
    public String getMessage() {
        if (template != null) {
            return ExceptionMessageBuilder.build(template.getMessageTemplate(), parameters);
        } else {
            return super.getMessage();
        }
    }
}

package com.inditex.ecommerce.exception.model;


import org.apache.commons.text.StringSubstitutor;

import com.inditex.ecommerce.exception.template.ErrorParameters;

public final class ExceptionMessageBuilder {
    private ExceptionMessageBuilder() {
    }

    public static String build(String messageTemplate, ErrorParameters parameters) {
        if (parameters == null) {
            return messageTemplate;
        }
        StringSubstitutor ss = new StringSubstitutor(parameters.getParameters());
        return ss.replace(messageTemplate);
    }
}

package com.inditex.ecommerce.exception.template;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Getter
@Builder
@SuppressWarnings("cast")
public class ErrorParameters {

    @Singular
    private Map<String, String> parameters;
}

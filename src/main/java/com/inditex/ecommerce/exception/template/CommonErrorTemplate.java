package com.inditex.ecommerce.exception.template;


import org.apache.commons.text.CaseUtils;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommonErrorTemplate implements ErrorTemplate {

    PRICE_NOT_FOUND("Price not found for this parameters: application date: ${applicationDate}, brand id: ${brandId}, product id: ${productId}",
        CommonErrorTemplate.PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND, false, true),
    UNPARSEABLE_DATE("We can't parse the date: ${date}",
        CommonErrorTemplate.PRODUCT_NOT_FOUND, HttpStatus.UNPROCESSABLE_ENTITY, true, true);

    private final String messageTemplate;
    private final String howToSolve;
    private final HttpStatus httpStatus;
    private final boolean isBadRequest;
    private final boolean isRetryable;

    private static final String PRODUCT_NOT_FOUND = "Try with another product.";

    /**
     * Returns the ErrorId from the enumeration element (it is the camelCase name).
     *
     * @return the camelCase name of the enumeration element.
     */
    @Override public String getErrorId() {
        return CaseUtils.toCamelCase(this.name(), false, '_');
    }

}

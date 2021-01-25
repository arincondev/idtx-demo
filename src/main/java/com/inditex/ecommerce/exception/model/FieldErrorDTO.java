package com.inditex.ecommerce.exception.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description of an error caused by field validation
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldErrorDTO implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -5767906253263497432L;

    /**
     * The field error code
     */
    @ApiModelProperty(value = "The field error code")
    private String code;

    /**
     * The name of the field with the error
     */
    @ApiModelProperty(value = "The name of the field with the error")
    private String field;

    /**
     * The field error message
     */
    @ApiModelProperty(value = "The field error message")
    private String message;
}

package com.inditex.ecommerce.exception.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -5767906253263397432L;

    @ApiModelProperty(value = "Time and date the error was thrown", example = "2032-07-05T10:11:53.629")
    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();

    @ApiModelProperty(value = "Error code", example = "serviceUnavailable")
    private String code;

    @ApiModelProperty(value = "URL where the error is documented", example = "http://service.name.domain.ext/api/1.0/errors/serviceUnavailable")
    private String url;

    @ApiModelProperty(value = "Detailed error message", example = "Your request cannot be processed at this moment")
    private String message;

    @ApiModelProperty(value = "The name of the service that threw this error", example = "hotelconnect-content-api")
    private String serviceName;

    @ApiModelProperty(value = "The error is caused by a bad request from the client, it's not due to an internal service")
    @Builder.Default
    private Boolean isBadRequest = Boolean.FALSE;

    @ApiModelProperty(value = "If the error can be recovered by retrying the request")
    @Builder.Default
    private Boolean canRetryOnError = Boolean.FALSE;

    @ApiModelProperty(value = "HTTP request trace ID", example = "94cd45f7dc0a412f")
    private String traceId;

    @ApiModelProperty(value = "List of errors caused by field validations")
    @Builder.Default
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    @ApiModelProperty(value = "Any nested error causing this one")
    private ErrorDTO nestedError;
}

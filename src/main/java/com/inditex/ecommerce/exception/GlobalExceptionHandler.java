package com.inditex.ecommerce.exception;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inditex.ecommerce.exception.model.ErrorDTO;
import com.inditex.ecommerce.exception.model.ExceptionMessageBuilder;
import com.inditex.ecommerce.exception.template.ErrorParameters;
import com.inditex.ecommerce.exception.template.ErrorTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles the error response depending on every handled exception
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String X_TRACE_ID = "X_TRACE_ID";
    private static final String XB3_TRACE_ID = "X-B3-TraceId";
    private static final String SERVICE_NAME = "INDITEX";

    /**
     * Gestiona las excepciones propias del servicio devolviendo diferentes tipos de error
     * en función del {@link ErrorTemplate}
     * indicado en {@link ServiceException}
     *
     * @param request   the request
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    private ResponseEntity<ErrorDTO> handleServiceException(
        final HttpServletRequest request,
        final ServiceException exception) {

        log.error(exception.getMessage(), exception);

        return buildErrorResponse(request, exception.getTemplate(), exception.getParameters());
    }

    public static ErrorDTO buildErrorDTO(HttpServletRequest request, ServiceException e) {
        return ErrorDTO.builder()
            .code(e.getTemplate().getErrorId())
            .message(ExceptionMessageBuilder.build(e.getTemplate().getMessageTemplate(), e.getParameters()))
            .serviceName(SERVICE_NAME)
            .isBadRequest(e.getTemplate().isBadRequest())
            .traceId(MDC.get(XB3_TRACE_ID))
            .build();
    }


    private ErrorDTO buildErrorDTO(HttpServletRequest request, String code, String message, boolean isBadRequest, final ErrorDTO nestedError) {
        return ErrorDTO.builder()
            .code(code)
            .message(message)
            .isBadRequest(isBadRequest)
            .traceId(MDC.get(XB3_TRACE_ID))
            .nestedError(nestedError)
            .build();
    }

    private ResponseEntity<ErrorDTO> buildErrorResponse(HttpServletRequest request, final ErrorTemplate template, final ErrorParameters parameters) {
        ResponseEntity<ErrorDTO> response = new ResponseEntity<>(
            buildErrorDTO(request,
                template.getErrorId(),
                ExceptionMessageBuilder.build(template.getMessageTemplate(), parameters),
                template.isBadRequest(),
                null),
            getXTRaceHeader(),
            template.getHttpStatus());

        log.info("Creating response with ErrorDTO: {}", response.toString());

        return response;
    }

    /**
     * Gets the X Trace header.
     *
     * @return the X Trace header.
     */
    private HttpHeaders getXTRaceHeader() {
        final HttpHeaders headers = new HttpHeaders();

        final String traceId = MDC.get(XB3_TRACE_ID);
        if (StringUtils.isNotEmpty(traceId)) {
            headers.add(X_TRACE_ID, traceId);
        }
        return headers;
    }
}

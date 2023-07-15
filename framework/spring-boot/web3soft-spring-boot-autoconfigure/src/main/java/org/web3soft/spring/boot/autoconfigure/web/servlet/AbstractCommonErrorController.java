package org.web3soft.spring.boot.autoconfigure.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.web3soft.commons.dictionary.consts.AppEnvConsts;

import java.util.Collections;
import java.util.Map;

/**
 * @author linus
 */
@Slf4j
public abstract class AbstractCommonErrorController extends AbstractErrorController {

    protected final ErrorProperties errorProperties;

    public AbstractCommonErrorController(final ErrorAttributes errorAttributes,
                                         final ErrorProperties errorProperties) {
        super(errorAttributes);
        this.errorProperties = errorProperties;
    }

    protected Map<String, Object> getViewModel(final HttpServletRequest request, final HttpServletResponse response) {
        final HttpStatus status = this.getStatus(request);
        response.setStatus(status.value());
        return this.getErrorModel(request);
    }

    protected ResponseEntity<Map<String, Object>> getResponseEntity(final HttpServletRequest request) {
        final HttpStatus status = this.getStatus(request);
        final Map<String, Object> model = this.getErrorModel(request);
        return new ResponseEntity<>(model, status);
    }

    protected Map<String, Object> getErrorModel(final HttpServletRequest request) {
        final HttpStatus status = this.getStatus(request);
        final Map<String, Object> model = Collections.unmodifiableMap(this.getErrorAttributes(request, this.isIncludeStackTrace(request)));
        log.error("app:{},path:{},status:{},trace:{}", AppEnvConsts.APP_NAME, model.get("path"), status.value(), model.get("trace"));
        return model;
    }

    protected ErrorAttributeOptions isIncludeStackTrace(final HttpServletRequest request) {
        final ErrorProperties.IncludeAttribute include = this.errorProperties.getIncludeStacktrace();
        if (include == ErrorProperties.IncludeAttribute.ALWAYS) {
            return ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE);
        }
        if (include == ErrorProperties.IncludeAttribute.ON_PARAM) {
            ErrorAttributeOptions.of(this.getTraceParameter(request) ? ErrorAttributeOptions.Include.STACK_TRACE : ErrorAttributeOptions.Include.MESSAGE);
        }
        return ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE);
    }
}

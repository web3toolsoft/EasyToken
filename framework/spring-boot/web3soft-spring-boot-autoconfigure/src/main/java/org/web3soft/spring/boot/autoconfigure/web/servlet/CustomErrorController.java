package org.web3soft.spring.boot.autoconfigure.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3soft.commons.support.enums.HttpStatusCode;
import org.web3soft.commons.support.model.ResultEntity;
import org.web3soft.commons.support.util.ResultUtils;

import java.util.Map;

/**
 * @author web3soft-team
 */
@Slf4j
@Primary
@RestController
@RequestMapping("/customError")
@ConditionalOnProperty(prefix = "web3soft.web.custom-error", name = "enabled", matchIfMissing = true)
public class CustomErrorController extends AbstractCommonErrorController {

    public CustomErrorController(final ErrorAttributes errorAttributes,
                                 final ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @Override
    protected HttpStatus getStatus(final HttpServletRequest request) {
        final Integer statusCode = (Integer) request.getAttribute("spring.security.auth.status_code");
        if (statusCode == null) {
            return super.getStatus(request);
        }
        return HttpStatus.UNAUTHORIZED;
    }

    @Override
    protected Map<String, Object> getErrorAttributes(final HttpServletRequest request, final ErrorAttributeOptions options) {
        final Map<String, Object> model = super.getErrorAttributes(request, options);
        final Object path = request.getAttribute("spring.security.auth.request_uri");
        if (path != null) {
            model.put("path", path);
            model.put("status", this.getStatus(request).value());
        }
        return model;
    }

    @RequestMapping(value = "/401")
    public ResultEntity<?> error401(final HttpServletRequest request) {
        return ResultUtils.failure(HttpStatusCode.UNAUTHORIZED, null);
    }

    @RequestMapping(value = "/403")
    public ResultEntity<?> error403(final HttpServletRequest request) {
        return ResultUtils.failure(HttpStatusCode.FORBIDDEN, null);
    }

    @RequestMapping(value = "/404")
    public ResultEntity<?> error404(final HttpServletRequest request) {
        return ResultUtils.failure(HttpStatusCode.NOT_FOUND, null);
    }

    @RequestMapping
    public ResultEntity<?> error(final HttpServletRequest request) {
        final ResponseEntity<Map<String, Object>> responseEntity = this.getResponseEntity(request);
        return ResultUtils.failure(
                HttpStatusCode.valueOf(responseEntity.getStatusCode().value()), null
        );
    }
}

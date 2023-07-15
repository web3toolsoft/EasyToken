package org.web3soft.spring.boot.autoconfigure.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.web3soft.commons.support.enums.HttpStatusCode;
import org.web3soft.commons.support.model.ResultEntity;
import org.web3soft.commons.support.util.ResultUtils;

import java.util.Map;

/**
 * @author web3soft-team
 */
@Slf4j
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CommonErrorController extends AbstractCommonErrorController {

    public CommonErrorController(final ErrorAttributes errorAttributes,
                                 final ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @ResponseBody
    @RequestMapping(value = "/401")
    public ResultEntity<?> error401(final HttpServletRequest request) {
        return ResultUtils.failure(HttpStatusCode.UNAUTHORIZED, null);
    }

    @RequestMapping(value = "/401", produces = "text/html")
    public ModelAndView error401Html(final HttpServletRequest request,
                                     final HttpServletResponse response) {
        final Map<String, Object> model = this.getViewModel(request, response);
        return new ModelAndView("error/401", model);
    }

    @ResponseBody
    @RequestMapping(value = "/403")
    public ResultEntity<?> error403(final HttpServletRequest request) {
        return ResultUtils.failure(HttpStatusCode.FORBIDDEN, null);
    }

    @RequestMapping(value = "/403", produces = "text/html")
    public ModelAndView error403Html(final HttpServletRequest request,
                                     final HttpServletResponse response) {
        final Map<String, Object> model = this.getViewModel(request, response);
        return new ModelAndView("error/403", model);
    }

    @ResponseBody
    @RequestMapping(value = "/404")
    public ResultEntity<?> error404(final HttpServletRequest request) {
        return ResultUtils.failure(HttpStatusCode.NOT_FOUND, null);
    }

    @RequestMapping(value = "/404", produces = "text/html")
    public ModelAndView error404Html(final HttpServletRequest request,
                                     final HttpServletResponse response) {
        final Map<String, Object> model = this.getViewModel(request, response);
        return new ModelAndView("error/404", model);
    }

    @ResponseBody
    @RequestMapping
    public ResultEntity<?> error(final HttpServletRequest request) {
        final ResponseEntity<Map<String, Object>> responseEntity = this.getResponseEntity(request);
        return ResultUtils.failure(
                HttpStatusCode.valueOf(responseEntity.getStatusCode().value()), null
        );
    }

    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(final HttpServletRequest request,
                                  final HttpServletResponse response) {
        final Map<String, Object> model = this.getViewModel(request, response);
        return new ModelAndView("error/global", model);
    }
}


package io.github.yibird.starter.web.autoconfigure.response;

import com.feiniaojin.gracefulresponse.advice.lifecycle.exception.BeforeControllerAdviceProcess;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @Description 控制器响应前默认处理类
 * @Author zchengfeng
 * @Datetime 2025/3/26 23:53
 */
public class DefaultBeforeControllerAdviceProcessImpl implements BeforeControllerAdviceProcess {

    private final GlobalResponseProperties globalResponseProperties;

    public DefaultBeforeControllerAdviceProcessImpl(GlobalResponseProperties globalResponseProperties) {
        this.globalResponseProperties = globalResponseProperties;
    }

    @Override
    public void call(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (globalResponseProperties.isPrintExceptionInGlobalAdvice()) {
            System.out.println("method:" + request.getMethod() + ",uri:" + request.getRequestURI() + "ex:" + ex);
        }
    }
}

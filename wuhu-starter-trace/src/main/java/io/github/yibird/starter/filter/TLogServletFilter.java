package io.github.yibird.starter.filter;

import cn.hutool.core.text.CharSequenceUtil;
import io.github.yibird.starter.autoconfigure.TraceProperties;
import io.github.yibird.starter.handler.TLogWebCommon;
import com.yomahub.tlog.context.TLogContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Description tlog Servlet过滤器
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:29
 */
public class TLogServletFilter implements Filter {

    private final TraceProperties traceProperties;

    public TLogServletFilter(TraceProperties traceProperties) {
        this.traceProperties = traceProperties;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        if (req instanceof HttpServletRequest httpServletRequest && resp instanceof HttpServletResponse httpServletResponse) {
            try {
                TLogWebCommon.loadInstance().preHandle(httpServletRequest);
                // 把 traceId 放入 response 的 header，为了方便有些人有这样的需求，从前端拿整条链路的 traceId
                String traceIdName = traceProperties.getTraceIdName();
                if (CharSequenceUtil.isNotBlank(traceIdName)) {
                    httpServletResponse.addHeader(traceIdName, TLogContext.getTraceId());
                }
                filterChain.doFilter(req, resp);
            } finally {
                TLogWebCommon.loadInstance().afterCompletion();
            }
            return;
        }
        filterChain.doFilter(req, resp);
    }
}

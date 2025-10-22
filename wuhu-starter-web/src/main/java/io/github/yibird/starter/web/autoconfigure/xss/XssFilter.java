package io.github.yibird.starter.web.autoconfigure.xss;

import cn.hutool.core.collection.CollUtil;
import io.github.yibird.starter.web.utils.SpringWebUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author zchengfeng
 * @DateTime 2025/3/17 1:31
 */
public class XssFilter implements Filter {

    private final XssProperties xssProperties;

    public XssFilter(XssProperties xssProperties) {
        this.xssProperties = xssProperties;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 非HttpServletRequest 或 未开启 XSS 过滤,则直接跳过
        if (!(servletRequest instanceof HttpServletRequest) || !xssProperties.isEnabled()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 放行路由:忽略 XSS 过滤
        List<String> excludePatterns = xssProperties.getExcludePatterns();

        String servletPath = ((HttpServletRequest) servletRequest).getServletPath();
        if (CollUtil.isNotEmpty(excludePatterns) && SpringWebUtils.isMatch(servletPath, excludePatterns)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 拦截路由:执行 XSS 过滤
        List<String> includePatterns = xssProperties.getIncludePatterns();
        if (CollUtil.isNotEmpty(includePatterns)) {
            if (SpringWebUtils.isMatch(servletPath, includePatterns)) {
                filterChain.doFilter(new XssServletRequestWrapper((HttpServletRequest) servletRequest, xssProperties), servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
}

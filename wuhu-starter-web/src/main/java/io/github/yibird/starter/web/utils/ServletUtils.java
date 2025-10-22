package io.github.yibird.starter.web.utils;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import io.github.yibird.starter.core.constant.StringConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UriUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

/**
 * @Description Servlet工具类
 * @Author zchengfeng
 * @Datetime 2025/3/18 2:27
 */
public class ServletUtils extends JakartaServletUtil {
    public ServletUtils() {
    }


    /**
     * 获取浏览器及其版本信息
     *
     * @param request 请求对象
     * @return 浏览器及其版本信息
     */
    public static String getBrowser(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        return getBrowser(request.getHeader("User-Agent"));
    }


    /**
     * 获取浏览器及其版本信息
     *
     * @param userAgentString User-Agent 字符串
     * @return 浏览器及其版本信息
     */
    public static String getBrowser(String userAgentString) {
        UserAgent userAgent = UserAgentUtil.parse(userAgentString);
        return userAgent.getBrowser().getName() + StringConstants.SPACE + userAgent.getVersion();
    }

    /**
     * 获取操作系统
     *
     * @param request 请求对象
     * @return 操作系统
     */
    public static String getOs(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        return getOs(request.getHeader("User-Agent"));
    }

    /**
     * 获取操作系统
     *
     * @param userAgentString User-Agent 字符串
     * @return 操作系统
     */
    public static String getOs(String userAgentString) {
        UserAgent userAgent = UserAgentUtil.parse(userAgentString);
        return userAgent.getOs().getName();
    }

    /**
     * 获取请求方法
     *
     * @return 请求方法
     */
    public static String getRequestMethod() {
        HttpServletRequest request = getRequest();
        return request != null ? request.getMethod() : null;
    }

    /**
     * 获取请求参数
     *
     * @param name 参数名
     * @return {@link String }
     */
    public static String getRequestParameter(String name) {
        HttpServletRequest request = getRequest();
        return request != null ? request.getParameter(name) : null;
    }


    /**
     * 获取请求 Ip
     *
     * @return {@link String }
     */
    public static String getRequestIp() {
        HttpServletRequest request = getRequest();
        return request != null ? getClientIP(request) : null;
    }

    /**
     * 获取请求头信息
     *
     * @return {@link Map }<{@link String }, {@link String }>
     * @since 2.11.0
     */
    public static Map<String, String> getRequestHeaders() {
        HttpServletRequest request = getRequest();
        return request != null ? getHeaderMap(request) : Collections.emptyMap();
    }

    /**
     * 获取请求 URL（包含 query 参数）
     * <p>{@code http://localhost:8000/system/user?page=1&size=10}</p>
     */
    public static URI getRequestUrl() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        String queryString = request.getQueryString();
        if (CharSequenceUtil.isBlank(queryString)) {
            return URI.create(request.getRequestURL().toString());
        }
        try {
            StringBuilder urlBuilder = appendQueryString(queryString);
            return new URI(urlBuilder.toString());
        } catch (URISyntaxException e) {
            String encoded = UriUtils.encodeQuery(queryString, StandardCharsets.UTF_8);
            StringBuilder urlBuilder = appendQueryString(encoded);
            return URI.create(urlBuilder.toString());
        }
    }

    /**
     * 获取 HTTP Session
     *
     * @return HttpSession
     */
    public static HttpSession getSession() {
        HttpServletRequest request = getRequest();
        return request != null ? request.getSession() : null;
    }

//    /**
//     * 获取响应 body 参数
//     *
//     * @return {@link String }
//     * @since 2.11.0
//     */
//    public static String getResponseBody() {
//        HttpServletResponse response = getResponse();
//        if (response instanceof RepeatReadResponseWrapper wrapper && !wrapper.isStreamingResponse()) {
//            String body = wrapper.getResponseContent();
//            return JSONUtils.isTypeJSON(body) ? body : null;
//        }
//        return null;
//    }
//
//    /**
//     * 获取响应参数
//     *
//     * @return {@link Map }<{@link String }, {@link Object }>
//     * @since 2.11.0
//     */
//    public static Map<String, Object> getResponseParams() {
//        String body = getResponseBody();
//        return CharSequenceUtil.isNotBlank(body) && JSONUtils.isTypeJSON(body)
//                ? JSONUtils.toBean(body, Map.class)
//                : null;
//    }

    /**
     * 获取 HTTP Request
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return attributes.getRequest();
    }

    public static String getRequestBody() {
        HttpServletRequest request = getRequest();
//        if (request instanceof RepeatReadRequestWrapper wrapper && !wrapper.isMultipartContent(request)) {
//            String body = JakartaServletUtil.getBody(request);
//            return JSONUtils.isTypeJSON(body) ? body : null;
//        }
        return null;
    }

    public static Map<String, Object> getRequestParams() {
        String body = getRequestBody();
//        return CharSequenceUtil.isNotBlank(body) && JSONUtils.isTypeJSON(body)
//                ? JSONUtils.toBean(body, Map.class)
//                : Collections.unmodifiableMap(JakartaServletUtil.getParamMap(Objects.requireNonNull(getRequest())));
        return null;
    }

    /**
     * 获取 HTTP Response
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return attributes.getResponse();
    }

    /**
     * 获取请求属性
     *
     * @return {@link ServletRequestAttributes }
     */
    public static ServletRequestAttributes getRequestAttributes() {
        try {
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            return (ServletRequestAttributes) attributes;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 追加查询字符串
     *
     * @param queryString 查询字符串
     * @return {@link StringBuilder }
     */
    private static StringBuilder appendQueryString(String queryString) {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return new StringBuilder();
        }
        return new StringBuilder().append(request.getRequestURL())
                .append(StringConstants.QUESTION_MARK)
                .append(queryString);
    }
}

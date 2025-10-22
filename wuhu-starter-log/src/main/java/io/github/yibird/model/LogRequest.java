package io.github.yibird.model;

import io.github.yibird.enums.Include;
import io.github.yibird.starter.web.utils.ServletUtils;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * @Description 日志请求类, 改类包含了请求的日志信息
 * @Author zchengfeng
 * @Datetime 2025/4/11 14:23
 */
public class LogRequest {

    /**
     * 请求url
     */
    private URI url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求ip
     */
    private String ip;
    /**
     * 请求ip归属地
     */
    private String ipAddr;
    /**
     * 请求头
     */
    private Map<String, String> headers;
    /**
     * 请求体
     */
    private String body;
    /**
     * 请求参数
     */
    private Map<String, Object> param;
    /**
     * 请求浏览器信息
     */
    private String browser;
    /**
     * 请求系统信息
     */
    private String os;
    /**
     * 请求使用的token
     */
    private String token;

    public LogRequest(Set<Include> includes) {
        this.method = ServletUtils.getRequestMethod();
        this.url = ServletUtils.getRequestUrl();
        this.headers = includes.contains(Include.REQUEST_HEADERS) ? ServletUtils.getRequestHeaders() : null;
        if (this.method.equals("POST") && includes.contains(Include.REQUEST_BODY)) {
            this.body = ServletUtils.getBody(null);
        }
        if(this.method.equals("GET") && includes.contains(Include.REQUEST_BODY)) {
            this.param = ServletUtils.getRequestParams();
        }

        if(this.headers == null){
            return;
        }
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

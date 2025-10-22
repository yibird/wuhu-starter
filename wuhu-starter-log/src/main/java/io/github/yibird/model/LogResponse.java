package io.github.yibird.model;

import java.util.Map;

/**
 * @Description 日志响应信息类
 * @Author zchengfeng
 * @Datetime 2025/4/11 14:43
 */
public class LogResponse {

    /**
     * 响应头
     */
    private Integer status;
    /**
     * 响应头
     */
    private Map<String,String> headers;
    /**
     * 响应体
     */
    private String body;
    /**
     * 响应参数
     */
    private Map<String, Object> params;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}

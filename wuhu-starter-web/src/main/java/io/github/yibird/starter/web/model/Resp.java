package io.github.yibird.starter.web.model;

import cn.hutool.extra.spring.SpringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.feiniaojin.gracefulresponse.api.ResponseStatusFactory;
import com.feiniaojin.gracefulresponse.data.Response;
import com.feiniaojin.gracefulresponse.data.ResponseStatus;
import com.feiniaojin.gracefulresponse.defaults.DefaultResponseStatus;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @Description 统一响应类
 * @Author zchengfeng
 * @Datetime 2025/3/18 2:32
 */
public class Resp<T> implements Response {

    private static final ResponseStatusFactory RESPONSE_STATUS_FACTORY = SpringUtil
            .getBean(ResponseStatusFactory.class);
    private static final ResponseStatus DEFAULT_STATUS_SUCCESS = RESPONSE_STATUS_FACTORY.defaultSuccess();
    private static final ResponseStatus DEFAULT_STATUS_ERROR = RESPONSE_STATUS_FACTORY.defaultError();

    @Schema(description = "状态码", example = "0")
    private int code;
    @Schema(description = "状态信息", example = "ok")
    private String message;
    @Schema(description = "响应数据")
    private T data;

    private ResponseStatus status = new DefaultResponseStatus();

    public Resp() {
    }

    public Resp(ResponseStatus status) {
        this.status = status;
    }

    public Resp(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Resp(ResponseStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public Resp(ResponseStatus status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Resp(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    @JsonIgnore
    public ResponseStatus getStatus() {
        return status;
    }

    @Override
    public void setPayload(Object payload) {
        this.data = (T) payload;
    }

    @Override
    @JsonIgnore
    public Object getPayload() {
        return data;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public static <T> Resp<T> ok() {
        return new Resp<>(DEFAULT_STATUS_SUCCESS);
    }

    public static <T> Resp<T> ok(T data) {
        return new Resp<>(DEFAULT_STATUS_SUCCESS, data);
    }

    public static <T> Resp<T> ok(T data, String message) {
        return new Resp<>(DEFAULT_STATUS_SUCCESS, data, message);
    }

    public static <T> Resp<T> err() {
        return new Resp<>(DEFAULT_STATUS_ERROR);
    }

    public static <T> Resp<T> err(int code, String message) {
        return new Resp<>(code, message);
    }

    public static <T> Resp<T> of(int code, T data, String message) {
        return new Resp<>(code, data, message);
    }

    public static <T> Resp<T> of(ResponseStatus status, T data, String message) {
        return new Resp<>(status, data, message);
    }
}

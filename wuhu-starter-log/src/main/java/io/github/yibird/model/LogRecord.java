package io.github.yibird.model;

import java.time.Duration;
import java.time.Instant;

/**
 * @Description 日志记录类
 * @Author zchengfeng
 * @Datetime 2025/4/11 14:18
 */
public class LogRecord {
    /**
     * 描述
     */
    private String description;
    /**
     * 所属模块
     */
    private String module;
    /**
     * 请求信息
     */
    private LogRequest request;
    /**
     * 响应信息
     */
    private LogResponse response;
    /**
     * 耗时
     */
    private Duration takeTime;

    /**
     * 时间戳
     */
    private Instant timestamp;

    /**
     * 错误信息
     */
    private String errorMessage;

}

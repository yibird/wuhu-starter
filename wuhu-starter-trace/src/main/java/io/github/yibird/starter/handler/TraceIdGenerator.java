package io.github.yibird.starter.handler;

import com.yomahub.tlog.id.TLogIdGenerator;
import com.yomahub.tlog.id.snowflake.UniqueIdGenerator;

/**
 * @Description 链路追踪Id生成器
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:27
 */
public class TraceIdGenerator extends TLogIdGenerator {

    /**
     * 生成链路追踪Id
     * @return 链路追踪Id
     */
    @Override
    public String generateTraceId() {
        return String.valueOf(UniqueIdGenerator.generateId());
    }
}

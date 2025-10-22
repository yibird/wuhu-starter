package io.github.yibird.starter.core.autoconfigure.executor;

import cn.hutool.core.util.ArrayUtil;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.core.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.concurrent.Executor;

/**
 * @Description 异步任务自动配置类
 * @Author zchengfeng
 * @Datetime 2024/5/5 15:10
 */
@Lazy
@AutoConfiguration
@EnableAsync(proxyTargetClass = true)
@ConditionalOnProperty(prefix = "spring.task.execution.extension", name = PropertiesConstants.ENABLED, havingValue = "true", matchIfMissing = true)
public class AsyncAutoConfiguration implements AsyncConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(AsyncAutoConfiguration.class);

    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public AsyncAutoConfiguration(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    /**
     * 异步任务线程池配置
     */
    @Override
    public Executor getAsyncExecutor() {
        return threadPoolTaskExecutor;
    }

    /**
     * 异步任务执行时的异常处理
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception message: ")
                    .append(throwable.getMessage())
                    .append(", Method name: ")
                    .append(method.getName());
            if (ArrayUtil.isNotEmpty(objects)) {
                sb.append(", Parameter value: ").append(Arrays.toString(objects));
            }
            throw new BaseException(sb.toString());
        };
    }
}

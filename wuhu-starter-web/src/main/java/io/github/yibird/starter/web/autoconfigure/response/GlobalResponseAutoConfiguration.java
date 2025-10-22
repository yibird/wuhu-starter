package io.github.yibird.starter.web.autoconfigure.response;

import com.feiniaojin.gracefulresponse.ExceptionAliasRegister;
import com.feiniaojin.gracefulresponse.advice.*;
import com.feiniaojin.gracefulresponse.advice.lifecycle.exception.BeforeControllerAdviceProcess;
import com.feiniaojin.gracefulresponse.advice.lifecycle.exception.ControllerAdvicePredicate;
import com.feiniaojin.gracefulresponse.advice.lifecycle.exception.RejectStrategy;
import com.feiniaojin.gracefulresponse.api.ResponseFactory;
import com.feiniaojin.gracefulresponse.api.ResponseStatusFactory;
import com.feiniaojin.gracefulresponse.defaults.DefaultResponseFactory;
import com.feiniaojin.gracefulresponse.defaults.DefaultResponseStatusFactoryImpl;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.core.factory.GeneralPropertySourceFactory;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.parsers.ReturnTypeParser;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description 全局响应自动配置类
 * @Author zchengfeng
 * @Datetime 2025/3/17 2:06
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(GlobalResponseProperties.class)
@PropertySource(value = "classpath:web-default.yml", factory = GeneralPropertySourceFactory.class)
public class GlobalResponseAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(GlobalResponseAutoConfiguration.class);
    private final GlobalResponseProperties globalResponseProperties;

    public GlobalResponseAutoConfiguration(GlobalResponseProperties globalResponseProperties) {
        this.globalResponseProperties = globalResponseProperties;
    }

    /**
     * 全局响应体处理(非 void)
     */
    @Bean
    @ConditionalOnMissingBean
    public GrNotVoidResponseBodyAdvice grNotVoidResponseBodyAdvice() {
        return new GrNotVoidResponseBodyAdvice();
    }

    /**
     * 全局响应体处理（void）
     */
    @Bean
    @ConditionalOnMissingBean
    public GrVoidResponseBodyAdvice grVoidResponseBodyAdvice() {
        return new GrVoidResponseBodyAdvice();
    }

    /**
     * 处理前回调（目前仅打印异常日志）
     */
    @Bean
    @ConditionalOnMissingBean
    public BeforeControllerAdviceProcess beforeControllerAdviceProcess() {
        return new DefaultBeforeControllerAdviceProcessImpl(globalResponseProperties);
    }


    /**
     * 框架异常处理器
     */
    @Bean
    public FrameworkExceptionAdvice frameworkExceptionAdvice(BeforeControllerAdviceProcess beforeControllerAdviceProcess,
                                                             @Lazy RejectStrategy rejectStrategy) {
        FrameworkExceptionAdvice frameworkExceptionAdvice = new FrameworkExceptionAdvice();
        frameworkExceptionAdvice.setRejectStrategy(rejectStrategy);
        frameworkExceptionAdvice.setControllerAdviceProcessor(frameworkExceptionAdvice);
        frameworkExceptionAdvice.setBeforeControllerAdviceProcess(beforeControllerAdviceProcess);
        frameworkExceptionAdvice.setControllerAdviceHttpProcessor(frameworkExceptionAdvice);
        return frameworkExceptionAdvice;
    }

    /**
     * 数据校验异常处理器
     */
    @Bean
    public DataExceptionAdvice dataExceptionAdvice(BeforeControllerAdviceProcess beforeControllerAdviceProcess,
                                                   @Lazy RejectStrategy rejectStrategy) {
        DataExceptionAdvice dataExceptionAdvice = new DataExceptionAdvice();
        dataExceptionAdvice.setRejectStrategy(rejectStrategy);
        dataExceptionAdvice.setControllerAdviceProcessor(dataExceptionAdvice);
        dataExceptionAdvice.setBeforeControllerAdviceProcess(beforeControllerAdviceProcess);
        dataExceptionAdvice.setControllerAdviceHttpProcessor(dataExceptionAdvice);
        return dataExceptionAdvice;
    }

    /**
     * 默认全局异常处理器
     */
    @Bean
    public DefaultGlobalExceptionAdvice defaultGlobalExceptionAdvice(BeforeControllerAdviceProcess beforeControllerAdviceProcess,
                                                                     @Lazy RejectStrategy rejectStrategy) {
        DefaultGlobalExceptionAdvice advice = new DefaultGlobalExceptionAdvice();
        advice.setRejectStrategy(rejectStrategy);
        CopyOnWriteArrayList<ControllerAdvicePredicate> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(advice);
        advice.setPredicates(copyOnWriteArrayList);
        advice.setControllerAdviceProcessor(advice);
        advice.setBeforeControllerAdviceProcess(beforeControllerAdviceProcess);
        advice.setControllerAdviceHttpProcessor(advice);
        return advice;
    }

    /**
     * 默认参数校验异常处理器
     */
    @Bean
    public DefaultValidationExceptionAdvice defaultValidationExceptionAdvice(BeforeControllerAdviceProcess beforeControllerAdviceProcess,
                                                                             @Lazy RejectStrategy rejectStrategy) {
        DefaultValidationExceptionAdvice advice = new DefaultValidationExceptionAdvice();
        advice.setRejectStrategy(rejectStrategy);
        advice.setControllerAdviceProcessor(advice);
        advice.setBeforeControllerAdviceProcess(beforeControllerAdviceProcess);
        // 设置默认参数校验异常http处理器
        advice.setControllerAdviceHttpProcessor(advice);
        return advice;
    }


    /**
     * 拒绝策略
     */
    @Bean
    public RejectStrategy rejectStrategy() {
        return new DefaultRejectStrategyImpl();
    }

    /**
     * 释放异常处理器
     */
    @Bean
    public ExceptionHandlerExceptionResolver releaseExceptionHandlerExceptionResolver() {
        return new ReleaseExceptionHandlerExceptionResolver();
    }

    /**
     * 国际化支持
     */
    @Bean
    @ConditionalOnProperty(prefix = PropertiesConstants.WEB_RESPONSE, name = "i18n", havingValue = "true")
    public GrI18nResponseBodyAdvice grI18nResponseBodyAdvice() {
        return new GrI18nResponseBodyAdvice();
    }

    /**
     * 国际化配置
     */
    @Bean
    @ConditionalOnProperty(prefix = PropertiesConstants.WEB_RESPONSE, name = "i18n", havingValue = "true")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("i18n", "i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(Locale.CHINA);
        return messageSource;
    }

    /**
     * 响应工厂
     */
    @Bean
    @ConditionalOnMissingBean
    public ResponseFactory responseBeanFactory() {
        return new DefaultResponseFactory();
    }

    /**
     * 响应状态工厂
     */
    @Bean
    @ConditionalOnMissingBean
    public ResponseStatusFactory responseStatusFactory() {
        return new DefaultResponseStatusFactoryImpl();
    }

    /**
     * 异常别名注册
     */
    @Bean
    public ExceptionAliasRegister exceptionAliasRegister() {
        return new ExceptionAliasRegister();
    }

    /**
     * 响应支持
     */
    @Bean
    public AdviceSupport adviceSupport() {
        return new AdviceSupport();
    }

    /**
     * SpringDoc 全局响应处理器
     *
     * @return ApiDocGlobalResponseHandler
     */
    @Bean
    @ConditionalOnClass(ReturnTypeParser.class)
    @ConditionalOnMissingBean
    public ApiDocGlobalResponseHandler apiDocGlobalResponseHandler() {
        return new ApiDocGlobalResponseHandler(globalResponseProperties);
    }

    @PostConstruct
    public void init() {
    }
}

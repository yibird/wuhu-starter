package io.github.yibird.starter.core.constant;

/**
 * @Description 属性常量类
 * @Author zchengfeng
 * @Datetime 2024/5/5 15:04
 */
public class PropertiesConstants {
    public static final String STARTER_NAME = "wuhu-starter";
    public static final String STARTER_NAME_UPPER = "Wuhu Starter";

    public static final String ENABLED = "enabled";


    /**
     * 线程池常量
     */
    public static final String THREAD_POOL_PREFIX = "thread-pool";
    public static final String SCHEDULE_POOL_PREFIX = "schedule-pool";
    public static final String THREAD_POOL = STARTER_NAME + StringConstants.DOT + "thread-pool";


    /**
     * web配置
     */
    public static final String WEB = STARTER_NAME + StringConstants.DOT + "web";
    /**
     * cors跨域配置
     */
    public static final String WEB_CORS = WEB + StringConstants.DOT + "cors";
    /**
     * xss配置
     */
    public static final String WEB_XSS = WEB + StringConstants.DOT + "xss";
    /**
     * 链路追踪配置
     */
    public static final String WEB_TRACE = WEB + StringConstants.DOT + "trace";
    /**
     * 全局响应
     */
    public static final String WEB_RESPONSE = WEB + StringConstants.DOT + "response";

    /**
     * 链路追踪
     */
    public static final String TRACE = STARTER_NAME + StringConstants.DOT + "trace";

    /**
     * 限流
     */
    public static final String RATE_LIMITER = STARTER_NAME + StringConstants.DOT + "rate-limiter";

    /**
     * CURD
     */
    public static final String CURD = STARTER_NAME + StringConstants.DOT + "crud";

    /**
     * 多租户
     */
    public static final String TENANT = "tenant";

    /**
     * 数据权限
     */
    public static final String DATA_PERMISSION = "data-permission";

    /**
     * 日志
     */
    public static final String LOG = STARTER_NAME + StringConstants.DOT + "log";

    /**
     * 幂等性
     */
    public static final String IDEMPOTENT = STARTER_NAME + StringConstants.DOT + "idempotent";

    /**
     * 安全
     */
    public static final String SECURITY = STARTER_NAME + StringConstants.DOT + "security";

    /**
     * 加解密
     */
    public static final String SECURITY_CRYPTO = SECURITY + StringConstants.DOT + "crypto";
}

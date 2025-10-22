package io.github.yibird.starter.web.autoconfigure.response;

import com.feiniaojin.gracefulresponse.GracefulResponseProperties;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description 全局响应配置属性, 继承自GracefulResponseProperties类
 * @Author zchengfeng
 * @Datetime 2025/3/17 2:06
 */
@ConfigurationProperties(PropertiesConstants.WEB_RESPONSE)
public class GlobalResponseProperties extends GracefulResponseProperties {

}
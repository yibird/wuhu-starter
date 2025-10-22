package io.github.yibird.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description WebSocket自动配置类
 * @Author zchengfeng
 * @Datetime 2025/4/12 11:17
 */
@AutoConfiguration
@EnableWebSocket
public class WebSocketAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(WebSocketAutoConfiguration.class);

    @Bean
    public WebSocketConfigurer webSocketConfigurer() {
        return registry -> {
//            registry.addHandler()
        };
    }
}

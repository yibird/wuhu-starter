package io.github.yibird.autoconfigure;

import io.github.yibird.starter.core.constant.StringConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description WebSocket属性类
 * @Author zchengfeng
 * @Datetime 2025/4/12 11:13
 */
public class WebSocketProperties {

    private static final List<String> ALL = Collections.singletonList(StringConstants.ASTERISK);
    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * 路径
     */
    private String path = StringConstants.FORWARD_SLASH + "websocket";

    /**
     * 允许跨域的域名
     */
    private List<String> allowedOrigins = new ArrayList<>(ALL);

}

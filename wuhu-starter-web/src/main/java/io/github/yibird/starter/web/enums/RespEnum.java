package io.github.yibird.starter.web.enums;

import io.github.yibird.starter.web.constant.RespCodeConstants;
import io.github.yibird.starter.web.constant.RespCodeMessageConstants;

/**
 * @Description 响应枚举类
 * @Author zchengfeng
 * @Datetime 2025/8/6 16:14
 */
public enum RespEnum {

    OK(Integer.parseInt(RespCodeConstants.OK), RespCodeMessageConstants.OK_MESSAGE),
    ERROR(Integer.parseInt(RespCodeConstants.ERROR), RespCodeMessageConstants.ERROR_MESSAGE),
    UNAUTHORIZED(Integer.parseInt(RespCodeConstants.UNAUTHORIZED), RespCodeMessageConstants.UNAUTHORIZED_MESSAGE);

    private final int code;
    private final String message;

    RespEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

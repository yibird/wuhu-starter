package io.github.yibird.starter.web.exception;

import com.feiniaojin.gracefulresponse.api.ExceptionMapper;
import io.github.yibird.starter.web.constant.RespCodeConstants;
import io.github.yibird.starter.web.constant.RespCodeMessageConstants;

/**
 * @Description 未认证异常
 * @Author zchengfeng
 * @Datetime 2025/8/6 15:34
 */
@ExceptionMapper(code = RespCodeConstants.UNAUTHORIZED, msg = RespCodeMessageConstants.UNAUTHORIZED_MESSAGE)
public final class UnauthorizedException extends RuntimeException {

}

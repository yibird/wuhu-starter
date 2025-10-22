package io.github.yibird.starter.web.autoconfigure.response;

import cn.dev33.satoken.exception.NotLoginException;
import com.feiniaojin.gracefulresponse.data.Response;
import io.github.yibird.starter.web.constant.RespCodeConstants;
import io.github.yibird.starter.web.constant.RespCodeMessageConstants;
import io.github.yibird.starter.web.model.Resp;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/8/6 15:48
 */
@Order(100)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotLoginException.class)
    public Response handleNotLoginException(NotLoginException e) {
        return Resp.err(Integer.parseInt(RespCodeConstants.UNAUTHORIZED), RespCodeMessageConstants.UNAUTHORIZED_MESSAGE);
    }
}

package io.github.yibird.starter.extension.curd.core.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * @Description id请求参数模型类
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:36
 */
public class IdReq implements Serializable {

    // id
    @Schema(description = "ID", example = "1")
    @NotNull(message = "ID 不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IdReq() {
    }

    public IdReq(Long id) {
        this.id = id;
    }
}

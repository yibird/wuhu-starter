package io.github.yibird.starter.extension.curd.core.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Description id集合请求参数模型类
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:36
 */
public class IdsReq implements Serializable {

    /**
     * id 集合
     */
    @Schema(description = "ID", example = "[1,2]")
    @NotEmpty(message = "ID 不能为空")
    private Collection<Long> ids;

    public Collection<Long> getIds() {
        return ids;
    }

    public void setIds(Collection<Long> ids) {
        this.ids = ids;
    }

    public IdsReq() {
    }

    public IdsReq(Collection<Long> ids) {
    }
}

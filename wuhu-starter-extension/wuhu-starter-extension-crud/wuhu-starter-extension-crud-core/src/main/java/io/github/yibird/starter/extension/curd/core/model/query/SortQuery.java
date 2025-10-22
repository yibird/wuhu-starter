package io.github.yibird.starter.extension.curd.core.model.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:43
 */
@Schema(description = "排序查询条件")
public class SortQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 排序条件
     */
    @Schema(description = "排序条件", example = "createTime,desc")
    private String[] sort;
}

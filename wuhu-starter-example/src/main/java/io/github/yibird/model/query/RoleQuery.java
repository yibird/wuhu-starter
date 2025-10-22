package io.github.yibird.model.query;


import io.github.yibird.starter.extension.curd.core.model.query.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/25 10:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleQuery extends BaseQuery {
    private String roleName;
}

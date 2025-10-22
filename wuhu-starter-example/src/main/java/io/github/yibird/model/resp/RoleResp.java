package io.github.yibird.model.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/6/12 14:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResp {
    private String roleName;
    private int dataScope;
    private int dataStatus;
    private String remark;
}

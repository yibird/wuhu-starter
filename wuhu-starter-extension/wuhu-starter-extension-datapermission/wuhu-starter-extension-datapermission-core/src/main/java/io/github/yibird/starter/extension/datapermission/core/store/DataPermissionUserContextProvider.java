package io.github.yibird.starter.extension.datapermission.core.store;

import io.github.yibird.starter.extension.datapermission.core.model.UserContext;

/**
 * @Description 数据权限用户上下文接口
 * @Author zchengfeng
 * @Datetime 2025/4/29 09:57
 */
public interface DataPermissionUserContextProvider {
    /**
     * 是否过滤
     * 返回true表示过滤,返回false表示不过滤
     * @return boolean
     */
    boolean isFilter();

    /**
     * 获取用户上下文
     *
     * @return 用户上下文
     */
    UserContext getUserContext();
}

package io.github.yibird.model.entity;

import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

/**
 * @Description role实体模型
 * @Author zchengfeng
 * @Datetime 2025/4/24 10:07
 */
@Entity
@Table(name = "sys_role")
public interface RoleEntity {
    String roleName();
    int dataScope();

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    /**
     * 数据状态(0禁用,1启用)
     */
    int dataStatus();

    /**
     * 备注
     */
    @Nullable
    String remark();

    /**
     * 版本号
     */
    long version();

    /**
     * 排序序号
     */
    @Nullable
    Integer sort();

    /**
     * 删除标志(0未删除,1已删除)
     */
    @Default("0")
    @LogicalDeleted("1")
    int deleted();

    /**
     * 关联id,一般用于第三放扩展
     */
    @Nullable
    Long unionId();

    /**
     * 创建人
     */
    @Nullable
    Long createBy();

    /**
     * 创建时间
     */
    @Nullable
    LocalDateTime createTime();

    /**
     * 修改人
     */
    @Nullable
    Long updateBy();

    /**
     * 修改时间
     */
    @Nullable
    LocalDateTime updateTime();

    /**
     * 删除人
     */
    @Nullable
    Long deleteBy();

    /**
     * 修改时间
     */
    @Nullable
    LocalDateTime deleteTime();
}

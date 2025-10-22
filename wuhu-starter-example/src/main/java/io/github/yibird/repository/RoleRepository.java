package io.github.yibird.repository;

import io.github.yibird.model.entity.RoleEntity;
import io.github.yibird.model.entity.RoleEntityTable;
import io.github.yibird.model.query.RoleQuery;
import io.github.yibird.starter.extension.crud.jimmer.repository.BaseRepository;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.table.spi.TableProxy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/25 10:40
 */
@Repository
public class RoleRepository extends BaseRepository<RoleEntity, RoleQuery> {

    private final JSqlClient sqlClient;
    final RoleEntityTable table = RoleEntityTable.$;

    public RoleRepository(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @Override
    protected TableProxy<RoleEntity> getTable() {
        return table;
    }

    @Override
    public Page<RoleEntity> getPageList(RoleQuery query) {
        return sqlClient.createQuery(table)
                .where(
                        Predicate.or(
                                table.roleName().ilikeIf(StringUtils.hasText(query.getRoleName()), query.getRoleName())
                        )
                )
                .orderBy(table.createTime().desc())
                .select(table)
                .fetchPage(query.getCurrent() - 1, query.getPageSize());
    }
}

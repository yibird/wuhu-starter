package io.github.yibird.starter.extension.crud.jimmer.repository;

import cn.hutool.core.util.TypeUtil;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.mutation.DeleteMode;
import org.babyfish.jimmer.sql.ast.table.spi.TableProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @param <E> Entity模型泛型
 * @param <Q> Query模型泛型
 *
 * @Description 持久层基类
 * @Author zchengfeng
 * @Datetime 2025/4/24 16:14
 */
@Repository
public abstract class BaseRepository<E, Q> {

    @Autowired
    private JSqlClient sqlClient;

    private Class<E> classType;

    protected abstract TableProxy<E> getTable();

    public boolean save(E entity) {
        return sqlClient.saveCommand(entity).execute().getTotalAffectedRowCount() > 0;
    }

    public boolean del(Long id) {
        return sqlClient.deleteByIds(this.getClassType(), Collections.singleton(id), DeleteMode.LOGICAL).getTotalAffectedRowCount() > 0;
    }

    public boolean batchDel(Collection<Long> ids) {
        return sqlClient.deleteByIds(this.getClassType(), ids, DeleteMode.LOGICAL).getTotalAffectedRowCount() == ids.size();
    }

    public boolean update(E entity) {
        return sqlClient.createUpdate(getTable()).execute() > 0;
    }

    public List<E> getList() {
        return sqlClient.createQuery(getTable()).select(getTable()).execute();
    }

    public abstract Page<E> getPageList(Q query);

    public E getRecord(long id) {
        return sqlClient.findById(this.getClassType(), id);
    }

    @SuppressWarnings("unchecked")
    public Class<E> getClassType() {
        if (classType != null) {
            return classType;
        }
        Type type = TypeUtil.getTypeArgument(this.getClass());
        if (type instanceof Class<?>) {
            classType = (Class<E>) type;
            return classType;
        }
        throw new IllegalStateException("type is not class");
    }
}

package io.github.yibird.starter.data.jimmer.filter;

import io.github.yibird.starter.data.jimmer.model.TenantAware;
import org.babyfish.jimmer.sql.event.EntityEvent;
import org.babyfish.jimmer.sql.filter.CacheableFilter;
import org.babyfish.jimmer.sql.filter.FilterArgs;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/24 15:52
 */
public class TenantFilter implements CacheableFilter<TenantAware> {

    @Override
    public SortedMap<String, Object> getParameters() {
//        Long tenantId = TenantHolder.get();
//        if (tenantId == null) {
//            return null;
//        }
//        SortedMap<String, Object> map = new TreeMap<>();
//        map.put("tenant_id", tenantId);
//        return map;
        return null;
    }

    @Override
    public boolean isAffectedBy(EntityEvent<?> e) {
        return false;
    }

    @Override
    public void filter(FilterArgs<TenantAware> args) {
//        Long tenantId = TenantHolder.get();
//        if (tenantId != null) {
//            args.where(args.getTable().tenantId().eq(tenantId));
//        }
    }
}

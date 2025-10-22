package io.github.yibird.service.impl;


import io.github.yibird.convert.RoleConvert;
import io.github.yibird.model.entity.RoleEntity;
import io.github.yibird.model.query.RoleQuery;
import io.github.yibird.model.req.RoleReq;
import io.github.yibird.model.resp.RoleResp;
import io.github.yibird.repository.RoleRepository;
import io.github.yibird.service.RoleService;
import io.github.yibird.starter.extension.crud.jimmer.service.impl.BaseServiceImpl;
import io.github.yibird.starter.extension.curd.core.model.resp.PageResp;
import org.springframework.stereotype.Service;


/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/25 11:04
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleRepository, RoleConvert, RoleEntity, RoleResp, RoleQuery, RoleReq> implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }


    @Override
    public PageResp<RoleResp> getPageList(RoleQuery query) {
        return PageResp.wrap(
                repository.getPageList(query),
                page -> RoleConvert.INSTANCE.toResps(page.getRows()),
                query.getCurrent(),
                query.getCurrent()
        );
    }
}
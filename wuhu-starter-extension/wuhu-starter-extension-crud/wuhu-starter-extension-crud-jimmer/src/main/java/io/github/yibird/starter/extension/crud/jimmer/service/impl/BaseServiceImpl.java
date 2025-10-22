package io.github.yibird.starter.extension.crud.jimmer.service.impl;

import io.github.yibird.starter.extension.crud.jimmer.repository.BaseRepository;
import io.github.yibird.starter.extension.curd.core.convert.BaseConvert;
import io.github.yibird.starter.extension.curd.core.model.resp.PageResp;
import io.github.yibird.starter.extension.curd.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @param <M> 持久层泛型
 * @param <C> 转换器泛型
 * @param <E> 实体模型泛型
 * @param <P> 响应模型泛型
 * @param <Q> 查询模型泛型
 * @param <R> 请求模型泛型
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/25 11:07
 */
public abstract class BaseServiceImpl<M extends BaseRepository<E, Q>, C extends BaseConvert<E, P, R>, E, P, Q, R> implements BaseService<P, Q, R> {

    @Autowired
    private M repository;

    @Autowired
    private C convert;

    @Override
    public List<P> getList() {
        List<E> list = repository.getList();
        return convert.toResps(list);
    }

    @Override
    public PageResp<P> getPageList(Q query) {
//        Page<E> page = repository.getPageList(query);
//        return new PageResp<>(convert.toResps(page.getRows()),
//                page.getTotalPageCount(),
//                page.getTotalPageCount(),
//                query.getCurrent(),
//                query.getPageSize()
//        );
        return null;
    }

    @Override
    public P getRecord(Long id) {
        return convert.toResp(repository.getRecord(id));
    }

    @Transactional
    @Override
    public boolean create(R req) {
        E entity = convert.toEntity(req);
        return repository.save(entity);
    }

    @Transactional
    @Override
    public long batchCreate(List<R> reqs) {
        return 0;
    }

    @Transactional
    @Override
    public boolean del(Long id) {
        return repository.del(id);
    }

    @Transactional
    @Override
    public boolean batchDel(Collection<Long> ids) {
        return repository.batchDel(ids);
    }

    @Transactional
    @Override
    public boolean update(R req) {
        E entity = convert.toEntity(req);
        return repository.update(entity);
    }
}

package io.github.yibird.starter.extension.curd.core.service;


import io.github.yibird.starter.extension.curd.core.model.resp.PageResp;

import java.util.Collection;
import java.util.List;

/**
 * @param <P> Resp模型泛型
 * @param <Q> 查询模型泛型
 * @param <R> Req模型泛型
 * @Description 服务基类, 该类提供了业务服务类通用的方法
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:32
 */
public interface BaseService<P, Q, R> {

    /**
     * 获取列表
     *
     * @return 返回一个List集合
     */
    List<P> getList();

    /**
     * 获取分页列表
     *
     * @param query 查询模型
     * @return 返回一个BasePageResp对象
     */
    PageResp<P> getPageList(Q query);

    /**
     * 根据id获取记录
     *
     * @param id id
     * @return 返回id对应的记录
     */
    P getRecord(Long id);

    /**
     * 创建记录
     *
     * @param req 请求模型
     * @return 返回一个布尔值, true表示创建成功, 否则创建失败
     */
    boolean create(R req);

    /**
     * 批量创建记录
     *
     * @param reqs 请求模型集合
     * @return 返回创建成功的记录数
     */
    long batchCreate(List<R> reqs);

    /**
     * 根据id删除记录
     *
     * @param id id
     * @return 返回一个布尔值, true表示删除成功, 否则删除失败
     */
    boolean del(Long id);

    /**
     * 根据id集合删除记录
     *
     * @param ids id集合
     * @return 返回一个布尔值, true表示删除成功, 否则删除失败
     */
    boolean batchDel(Collection<Long> ids);

    /**
     * 修改记录
     *
     * @param req 请求模型
     * @return 返回一个布尔值, true表示修改成功, 否则修改失败
     */
    boolean update(R req);
}

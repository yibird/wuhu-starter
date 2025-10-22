package io.github.yibird.starter.extension.curd.core.convert;

import java.util.List;

/**
 * @Description 抽象转换器
 * @Author zchengfeng
 * @Datetime 2025/4/25 11:22
 */
public interface BaseConvert<E, P, R> {

    /**
     * 实体模型转响应模型
     *
     * @param entity 实体模型
     * @return P 响应模型
     */
    P toResp(E entity);

    /**
     * 实体模型List转响应模型List
     *
     * @param entitys 实体模型List
     * @return List<P> 响应模型List
     */
    List<P> toResps(List<E> entitys);

    /**
     * 请求模型转实体模型
     *
     * @param req 创建请求模型
     * @return E 实体模型
     */
    E toEntity(R req);

}

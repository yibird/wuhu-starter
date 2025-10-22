package io.github.yibird.convert;

import io.github.yibird.model.entity.RoleEntity;
import io.github.yibird.model.req.RoleReq;
import io.github.yibird.model.resp.RoleResp;
import io.github.yibird.starter.extension.curd.core.convert.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/25 11:52
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleConvert extends BaseConvert<RoleEntity, RoleResp, RoleReq> {
    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);
}

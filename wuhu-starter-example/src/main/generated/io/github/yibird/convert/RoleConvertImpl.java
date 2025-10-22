package io.github.yibird.convert;

import io.github.yibird.model.entity.RoleEntity;
import io.github.yibird.model.entity.RoleEntityDraft;
import io.github.yibird.model.req.RoleReq;
import io.github.yibird.model.resp.RoleResp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T17:06:00+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class RoleConvertImpl implements RoleConvert {

    @Override
    public RoleResp toResp(RoleEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RoleResp roleResp = new RoleResp();

        return roleResp;
    }

    @Override
    public List<RoleResp> toResps(List<RoleEntity> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<RoleResp> list = new ArrayList<RoleResp>( arg0.size() );
        for ( RoleEntity roleEntity : arg0 ) {
            list.add( toResp( roleEntity ) );
        }

        return list;
    }

    @Override
    public RoleEntity toEntity(RoleReq arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RoleEntityDraft.Builder roleEntity = new RoleEntityDraft.Builder();

        return roleEntity.build();
    }
}

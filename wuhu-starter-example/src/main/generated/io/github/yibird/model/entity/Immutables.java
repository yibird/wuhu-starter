package io.github.yibird.model.entity;

import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.internal.GeneratedBy;

@GeneratedBy
public interface Immutables {
    static RoleEntity createRoleEntity(DraftConsumer<RoleEntityDraft> block) {
        return RoleEntityDraft.$.produce(block);
    }

    static RoleEntity createRoleEntity(RoleEntity base, DraftConsumer<RoleEntityDraft> block) {
        return RoleEntityDraft.$.produce(base, block);
    }
}

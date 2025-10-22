package io.github.yibird.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;
import org.babyfish.jimmer.CircularReferenceException;
import org.babyfish.jimmer.Draft;
import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.UnloadedException;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.jackson.ImmutableModuleRequiredException;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutablePropCategory;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.PropId;
import org.babyfish.jimmer.runtime.DraftContext;
import org.babyfish.jimmer.runtime.DraftSpi;
import org.babyfish.jimmer.runtime.ImmutableSpi;
import org.babyfish.jimmer.runtime.Internal;
import org.babyfish.jimmer.runtime.Visibility;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;

@GeneratedBy(
        type = RoleEntity.class
)
public interface RoleEntityDraft extends RoleEntity, Draft {
    RoleEntityDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    RoleEntityDraft setId(long id);

    @OldChain
    RoleEntityDraft setRoleName(String roleName);

    @OldChain
    RoleEntityDraft setDataScope(int dataScope);

    @OldChain
    RoleEntityDraft setDataStatus(int dataStatus);

    @OldChain
    RoleEntityDraft setRemark(String remark);

    @OldChain
    RoleEntityDraft setVersion(long version);

    @OldChain
    RoleEntityDraft setSort(Integer sort);

    @OldChain
    RoleEntityDraft setDeleted(int deleted);

    @OldChain
    RoleEntityDraft setUnionId(Long unionId);

    @OldChain
    RoleEntityDraft setCreateBy(Long createBy);

    @OldChain
    RoleEntityDraft setCreateTime(LocalDateTime createTime);

    @OldChain
    RoleEntityDraft setUpdateBy(Long updateBy);

    @OldChain
    RoleEntityDraft setUpdateTime(LocalDateTime updateTime);

    @OldChain
    RoleEntityDraft setDeleteBy(Long deleteBy);

    @OldChain
    RoleEntityDraft setDeleteTime(LocalDateTime deleteTime);

    @GeneratedBy(
            type = RoleEntity.class
    )
    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ID = 0;

        public static final int SLOT_ROLE_NAME = 1;

        public static final int SLOT_DATA_SCOPE = 2;

        public static final int SLOT_DATA_STATUS = 3;

        public static final int SLOT_REMARK = 4;

        public static final int SLOT_VERSION = 5;

        public static final int SLOT_SORT = 6;

        public static final int SLOT_DELETED = 7;

        public static final int SLOT_UNION_ID = 8;

        public static final int SLOT_CREATE_BY = 9;

        public static final int SLOT_CREATE_TIME = 10;

        public static final int SLOT_UPDATE_BY = 11;

        public static final int SLOT_UPDATE_TIME = 12;

        public static final int SLOT_DELETE_BY = 13;

        public static final int SLOT_DELETE_TIME = 14;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.9.90",
                RoleEntity.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (RoleEntity)base)
            )
            .id(SLOT_ID, "id", long.class)
            .add(SLOT_ROLE_NAME, "roleName", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_DATA_SCOPE, "dataScope", ImmutablePropCategory.SCALAR, int.class, false)
            .add(SLOT_DATA_STATUS, "dataStatus", ImmutablePropCategory.SCALAR, int.class, false)
            .add(SLOT_REMARK, "remark", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_VERSION, "version", ImmutablePropCategory.SCALAR, long.class, false)
            .add(SLOT_SORT, "sort", ImmutablePropCategory.SCALAR, Integer.class, true)
            .logicalDeleted(SLOT_DELETED, "deleted", int.class, false)
            .add(SLOT_UNION_ID, "unionId", ImmutablePropCategory.SCALAR, Long.class, true)
            .add(SLOT_CREATE_BY, "createBy", ImmutablePropCategory.SCALAR, Long.class, true)
            .add(SLOT_CREATE_TIME, "createTime", ImmutablePropCategory.SCALAR, LocalDateTime.class, true)
            .add(SLOT_UPDATE_BY, "updateBy", ImmutablePropCategory.SCALAR, Long.class, true)
            .add(SLOT_UPDATE_TIME, "updateTime", ImmutablePropCategory.SCALAR, LocalDateTime.class, true)
            .add(SLOT_DELETE_BY, "deleteBy", ImmutablePropCategory.SCALAR, Long.class, true)
            .add(SLOT_DELETE_TIME, "deleteTime", ImmutablePropCategory.SCALAR, LocalDateTime.class, true)
            .build();

        private Producer() {
        }

        public RoleEntity produce(DraftConsumer<RoleEntityDraft> block) {
            return produce(null, block);
        }

        public RoleEntity produce(RoleEntity base, DraftConsumer<RoleEntityDraft> block) {
            return (RoleEntity)Internal.produce(TYPE, base, block);
        }

        /**
         * Class, not interface, for free-marker
         */
        @GeneratedBy(
                type = RoleEntity.class
        )
        @JsonPropertyOrder({"dummyPropForJacksonError__", "id", "roleName", "dataScope", "dataStatus", "remark", "version", "sort", "deleted", "unionId", "createBy", "createTime", "updateBy", "updateTime", "deleteBy", "deleteTime"})
        public abstract static class Implementor implements RoleEntity, ImmutableSpi {
            @Override
            public final Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_ID:
                    		return (Long)id();
                    case SLOT_ROLE_NAME:
                    		return roleName();
                    case SLOT_DATA_SCOPE:
                    		return (Integer)dataScope();
                    case SLOT_DATA_STATUS:
                    		return (Integer)dataStatus();
                    case SLOT_REMARK:
                    		return remark();
                    case SLOT_VERSION:
                    		return (Long)version();
                    case SLOT_SORT:
                    		return sort();
                    case SLOT_DELETED:
                    		return (Integer)deleted();
                    case SLOT_UNION_ID:
                    		return unionId();
                    case SLOT_CREATE_BY:
                    		return createBy();
                    case SLOT_CREATE_TIME:
                    		return createTime();
                    case SLOT_UPDATE_BY:
                    		return updateBy();
                    case SLOT_UPDATE_TIME:
                    		return updateTime();
                    case SLOT_DELETE_BY:
                    		return deleteBy();
                    case SLOT_DELETE_TIME:
                    		return deleteTime();
                    default: throw new IllegalArgumentException("Illegal property name for \"io.github.yibird.model.entity.RoleEntity\": \"" + prop + "\"");
                }
            }

            @Override
            public final Object __get(String prop) {
                switch (prop) {
                    case "id":
                    		return (Long)id();
                    case "roleName":
                    		return roleName();
                    case "dataScope":
                    		return (Integer)dataScope();
                    case "dataStatus":
                    		return (Integer)dataStatus();
                    case "remark":
                    		return remark();
                    case "version":
                    		return (Long)version();
                    case "sort":
                    		return sort();
                    case "deleted":
                    		return (Integer)deleted();
                    case "unionId":
                    		return unionId();
                    case "createBy":
                    		return createBy();
                    case "createTime":
                    		return createTime();
                    case "updateBy":
                    		return updateBy();
                    case "updateTime":
                    		return updateTime();
                    case "deleteBy":
                    		return deleteBy();
                    case "deleteTime":
                    		return deleteTime();
                    default: throw new IllegalArgumentException("Illegal property name for \"io.github.yibird.model.entity.RoleEntity\": \"" + prop + "\"");
                }
            }

            public final long getId() {
                return id();
            }

            public final String getRoleName() {
                return roleName();
            }

            public final int getDataScope() {
                return dataScope();
            }

            public final int getDataStatus() {
                return dataStatus();
            }

            @Nullable
            public final String getRemark() {
                return remark();
            }

            public final long getVersion() {
                return version();
            }

            @Nullable
            public final Integer getSort() {
                return sort();
            }

            public final int getDeleted() {
                return deleted();
            }

            @Nullable
            public final Long getUnionId() {
                return unionId();
            }

            @Nullable
            public final Long getCreateBy() {
                return createBy();
            }

            @Nullable
            public final LocalDateTime getCreateTime() {
                return createTime();
            }

            @Nullable
            public final Long getUpdateBy() {
                return updateBy();
            }

            @Nullable
            public final LocalDateTime getUpdateTime() {
                return updateTime();
            }

            @Nullable
            public final Long getDeleteBy() {
                return deleteBy();
            }

            @Nullable
            public final LocalDateTime getDeleteTime() {
                return deleteTime();
            }

            @Override
            public final ImmutableType __type() {
                return TYPE;
            }

            public final int getDummyPropForJacksonError__() {
                throw new ImmutableModuleRequiredException();
            }
        }

        @GeneratedBy(
                type = RoleEntity.class
        )
        private static class Impl extends Implementor implements Cloneable, Serializable {
            private Visibility __visibility;

            long __idValue;

            boolean __idLoaded = false;

            String __roleNameValue;

            int __dataScopeValue;

            boolean __dataScopeLoaded = false;

            int __dataStatusValue;

            boolean __dataStatusLoaded = false;

            String __remarkValue;

            boolean __remarkLoaded = false;

            long __versionValue;

            boolean __versionLoaded = false;

            Integer __sortValue;

            boolean __sortLoaded = false;

            int __deletedValue;

            boolean __deletedLoaded = false;

            Long __unionIdValue;

            boolean __unionIdLoaded = false;

            Long __createByValue;

            boolean __createByLoaded = false;

            LocalDateTime __createTimeValue;

            boolean __createTimeLoaded = false;

            Long __updateByValue;

            boolean __updateByLoaded = false;

            LocalDateTime __updateTimeValue;

            boolean __updateTimeLoaded = false;

            Long __deleteByValue;

            boolean __deleteByLoaded = false;

            LocalDateTime __deleteTimeValue;

            boolean __deleteTimeLoaded = false;

            @Override
            @JsonIgnore
            @Description("id")
            public long id() {
                if (!__idLoaded) {
                    throw new UnloadedException(RoleEntity.class, "id");
                }
                return __idValue;
            }

            @Override
            @JsonIgnore
            public String roleName() {
                if (__roleNameValue == null) {
                    throw new UnloadedException(RoleEntity.class, "roleName");
                }
                return __roleNameValue;
            }

            @Override
            @JsonIgnore
            public int dataScope() {
                if (!__dataScopeLoaded) {
                    throw new UnloadedException(RoleEntity.class, "dataScope");
                }
                return __dataScopeValue;
            }

            @Override
            @JsonIgnore
            @Description("数据状态(0禁用,1启用)")
            public int dataStatus() {
                if (!__dataStatusLoaded) {
                    throw new UnloadedException(RoleEntity.class, "dataStatus");
                }
                return __dataStatusValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("备注")
            public String remark() {
                if (!__remarkLoaded) {
                    throw new UnloadedException(RoleEntity.class, "remark");
                }
                return __remarkValue;
            }

            @Override
            @JsonIgnore
            @Description("版本号")
            public long version() {
                if (!__versionLoaded) {
                    throw new UnloadedException(RoleEntity.class, "version");
                }
                return __versionValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("排序序号")
            public Integer sort() {
                if (!__sortLoaded) {
                    throw new UnloadedException(RoleEntity.class, "sort");
                }
                return __sortValue;
            }

            @Override
            @JsonIgnore
            @Description("删除标志(0未删除,1已删除)")
            public int deleted() {
                if (!__deletedLoaded) {
                    throw new UnloadedException(RoleEntity.class, "deleted");
                }
                return __deletedValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("关联id,一般用于第三放扩展")
            public Long unionId() {
                if (!__unionIdLoaded) {
                    throw new UnloadedException(RoleEntity.class, "unionId");
                }
                return __unionIdValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("创建人")
            public Long createBy() {
                if (!__createByLoaded) {
                    throw new UnloadedException(RoleEntity.class, "createBy");
                }
                return __createByValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("创建时间")
            public LocalDateTime createTime() {
                if (!__createTimeLoaded) {
                    throw new UnloadedException(RoleEntity.class, "createTime");
                }
                return __createTimeValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("修改人")
            public Long updateBy() {
                if (!__updateByLoaded) {
                    throw new UnloadedException(RoleEntity.class, "updateBy");
                }
                return __updateByValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("修改时间")
            public LocalDateTime updateTime() {
                if (!__updateTimeLoaded) {
                    throw new UnloadedException(RoleEntity.class, "updateTime");
                }
                return __updateTimeValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("删除人")
            public Long deleteBy() {
                if (!__deleteByLoaded) {
                    throw new UnloadedException(RoleEntity.class, "deleteBy");
                }
                return __deleteByValue;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            @Description("修改时间")
            public LocalDateTime deleteTime() {
                if (!__deleteTimeLoaded) {
                    throw new UnloadedException(RoleEntity.class, "deleteTime");
                }
                return __deleteTimeValue;
            }

            @Override
            public Impl clone() {
                try {
                    return (Impl)super.clone();
                } catch(CloneNotSupportedException ex) {
                    throw new AssertionError(ex);
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isLoaded(prop.asName());
                    case SLOT_ID:
                    		return __idLoaded;
                    case SLOT_ROLE_NAME:
                    		return __roleNameValue != null;
                    case SLOT_DATA_SCOPE:
                    		return __dataScopeLoaded;
                    case SLOT_DATA_STATUS:
                    		return __dataStatusLoaded;
                    case SLOT_REMARK:
                    		return __remarkLoaded;
                    case SLOT_VERSION:
                    		return __versionLoaded;
                    case SLOT_SORT:
                    		return __sortLoaded;
                    case SLOT_DELETED:
                    		return __deletedLoaded;
                    case SLOT_UNION_ID:
                    		return __unionIdLoaded;
                    case SLOT_CREATE_BY:
                    		return __createByLoaded;
                    case SLOT_CREATE_TIME:
                    		return __createTimeLoaded;
                    case SLOT_UPDATE_BY:
                    		return __updateByLoaded;
                    case SLOT_UPDATE_TIME:
                    		return __updateTimeLoaded;
                    case SLOT_DELETE_BY:
                    		return __deleteByLoaded;
                    case SLOT_DELETE_TIME:
                    		return __deleteTimeLoaded;
                    default: throw new IllegalArgumentException("Illegal property name for \"io.github.yibird.model.entity.RoleEntity\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "id":
                    		return __idLoaded;
                    case "roleName":
                    		return __roleNameValue != null;
                    case "dataScope":
                    		return __dataScopeLoaded;
                    case "dataStatus":
                    		return __dataStatusLoaded;
                    case "remark":
                    		return __remarkLoaded;
                    case "version":
                    		return __versionLoaded;
                    case "sort":
                    		return __sortLoaded;
                    case "deleted":
                    		return __deletedLoaded;
                    case "unionId":
                    		return __unionIdLoaded;
                    case "createBy":
                    		return __createByLoaded;
                    case "createTime":
                    		return __createTimeLoaded;
                    case "updateBy":
                    		return __updateByLoaded;
                    case "updateTime":
                    		return __updateTimeLoaded;
                    case "deleteBy":
                    		return __deleteByLoaded;
                    case "deleteTime":
                    		return __deleteTimeLoaded;
                    default: throw new IllegalArgumentException("Illegal property name for \"io.github.yibird.model.entity.RoleEntity\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isVisible(PropId prop) {
                if (__visibility == null) {
                    return true;
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isVisible(prop.asName());
                    case SLOT_ID:
                    		return __visibility.visible(SLOT_ID);
                    case SLOT_ROLE_NAME:
                    		return __visibility.visible(SLOT_ROLE_NAME);
                    case SLOT_DATA_SCOPE:
                    		return __visibility.visible(SLOT_DATA_SCOPE);
                    case SLOT_DATA_STATUS:
                    		return __visibility.visible(SLOT_DATA_STATUS);
                    case SLOT_REMARK:
                    		return __visibility.visible(SLOT_REMARK);
                    case SLOT_VERSION:
                    		return __visibility.visible(SLOT_VERSION);
                    case SLOT_SORT:
                    		return __visibility.visible(SLOT_SORT);
                    case SLOT_DELETED:
                    		return __visibility.visible(SLOT_DELETED);
                    case SLOT_UNION_ID:
                    		return __visibility.visible(SLOT_UNION_ID);
                    case SLOT_CREATE_BY:
                    		return __visibility.visible(SLOT_CREATE_BY);
                    case SLOT_CREATE_TIME:
                    		return __visibility.visible(SLOT_CREATE_TIME);
                    case SLOT_UPDATE_BY:
                    		return __visibility.visible(SLOT_UPDATE_BY);
                    case SLOT_UPDATE_TIME:
                    		return __visibility.visible(SLOT_UPDATE_TIME);
                    case SLOT_DELETE_BY:
                    		return __visibility.visible(SLOT_DELETE_BY);
                    case SLOT_DELETE_TIME:
                    		return __visibility.visible(SLOT_DELETE_TIME);
                    default: return true;
                }
            }

            @Override
            public boolean __isVisible(String prop) {
                if (__visibility == null) {
                    return true;
                }
                switch (prop) {
                    case "id":
                    		return __visibility.visible(SLOT_ID);
                    case "roleName":
                    		return __visibility.visible(SLOT_ROLE_NAME);
                    case "dataScope":
                    		return __visibility.visible(SLOT_DATA_SCOPE);
                    case "dataStatus":
                    		return __visibility.visible(SLOT_DATA_STATUS);
                    case "remark":
                    		return __visibility.visible(SLOT_REMARK);
                    case "version":
                    		return __visibility.visible(SLOT_VERSION);
                    case "sort":
                    		return __visibility.visible(SLOT_SORT);
                    case "deleted":
                    		return __visibility.visible(SLOT_DELETED);
                    case "unionId":
                    		return __visibility.visible(SLOT_UNION_ID);
                    case "createBy":
                    		return __visibility.visible(SLOT_CREATE_BY);
                    case "createTime":
                    		return __visibility.visible(SLOT_CREATE_TIME);
                    case "updateBy":
                    		return __visibility.visible(SLOT_UPDATE_BY);
                    case "updateTime":
                    		return __visibility.visible(SLOT_UPDATE_TIME);
                    case "deleteBy":
                    		return __visibility.visible(SLOT_DELETE_BY);
                    case "deleteTime":
                    		return __visibility.visible(SLOT_DELETE_TIME);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                    // If entity-id is loaded, return directly
                    return hash;
                }
                if (__roleNameValue != null) {
                    hash = 31 * hash + __roleNameValue.hashCode();
                }
                if (__dataScopeLoaded) {
                    hash = 31 * hash + Integer.hashCode(__dataScopeValue);
                }
                if (__dataStatusLoaded) {
                    hash = 31 * hash + Integer.hashCode(__dataStatusValue);
                }
                if (__remarkLoaded && __remarkValue != null) {
                    hash = 31 * hash + __remarkValue.hashCode();
                }
                if (__versionLoaded) {
                    hash = 31 * hash + Long.hashCode(__versionValue);
                }
                if (__sortLoaded && __sortValue != null) {
                    hash = 31 * hash + __sortValue.hashCode();
                }
                if (__deletedLoaded) {
                    hash = 31 * hash + Integer.hashCode(__deletedValue);
                }
                if (__unionIdLoaded && __unionIdValue != null) {
                    hash = 31 * hash + __unionIdValue.hashCode();
                }
                if (__createByLoaded && __createByValue != null) {
                    hash = 31 * hash + __createByValue.hashCode();
                }
                if (__createTimeLoaded && __createTimeValue != null) {
                    hash = 31 * hash + __createTimeValue.hashCode();
                }
                if (__updateByLoaded && __updateByValue != null) {
                    hash = 31 * hash + __updateByValue.hashCode();
                }
                if (__updateTimeLoaded && __updateTimeValue != null) {
                    hash = 31 * hash + __updateTimeValue.hashCode();
                }
                if (__deleteByLoaded && __deleteByValue != null) {
                    hash = 31 * hash + __deleteByValue.hashCode();
                }
                if (__deleteTimeLoaded && __deleteTimeValue != null) {
                    hash = 31 * hash + __deleteTimeValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                }
                if (__roleNameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__roleNameValue);
                }
                if (__dataScopeLoaded) {
                    hash = 31 * hash + Integer.hashCode(__dataScopeValue);
                }
                if (__dataStatusLoaded) {
                    hash = 31 * hash + Integer.hashCode(__dataStatusValue);
                }
                if (__remarkLoaded) {
                    hash = 31 * hash + System.identityHashCode(__remarkValue);
                }
                if (__versionLoaded) {
                    hash = 31 * hash + Long.hashCode(__versionValue);
                }
                if (__sortLoaded) {
                    hash = 31 * hash + System.identityHashCode(__sortValue);
                }
                if (__deletedLoaded) {
                    hash = 31 * hash + Integer.hashCode(__deletedValue);
                }
                if (__unionIdLoaded) {
                    hash = 31 * hash + System.identityHashCode(__unionIdValue);
                }
                if (__createByLoaded) {
                    hash = 31 * hash + System.identityHashCode(__createByValue);
                }
                if (__createTimeLoaded) {
                    hash = 31 * hash + System.identityHashCode(__createTimeValue);
                }
                if (__updateByLoaded) {
                    hash = 31 * hash + System.identityHashCode(__updateByValue);
                }
                if (__updateTimeLoaded) {
                    hash = 31 * hash + System.identityHashCode(__updateTimeValue);
                }
                if (__deleteByLoaded) {
                    hash = 31 * hash + System.identityHashCode(__deleteByValue);
                }
                if (__deleteTimeLoaded) {
                    hash = 31 * hash + System.identityHashCode(__deleteTimeValue);
                }
                return hash;
            }

            @Override
            public int __hashCode(boolean shallow) {
                return shallow ? __shallowHashCode() : hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded) {
                    // If entity-id is loaded, return directly
                    return __idValue == __other.id();
                }
                if (__isVisible(PropId.byIndex(SLOT_ROLE_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_NAME))) {
                    return false;
                }
                boolean __roleNameLoaded = __roleNameValue != null;
                if (__roleNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_NAME))) {
                    return false;
                }
                if (__roleNameLoaded && !Objects.equals(__roleNameValue, __other.roleName())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DATA_SCOPE)) != __other.__isVisible(PropId.byIndex(SLOT_DATA_SCOPE))) {
                    return false;
                }
                boolean __dataScopeLoaded = this.__dataScopeLoaded;
                if (__dataScopeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DATA_SCOPE))) {
                    return false;
                }
                if (__dataScopeLoaded && __dataScopeValue != __other.dataScope()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DATA_STATUS)) != __other.__isVisible(PropId.byIndex(SLOT_DATA_STATUS))) {
                    return false;
                }
                boolean __dataStatusLoaded = this.__dataStatusLoaded;
                if (__dataStatusLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DATA_STATUS))) {
                    return false;
                }
                if (__dataStatusLoaded && __dataStatusValue != __other.dataStatus()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_REMARK)) != __other.__isVisible(PropId.byIndex(SLOT_REMARK))) {
                    return false;
                }
                boolean __remarkLoaded = this.__remarkLoaded;
                if (__remarkLoaded != __other.__isLoaded(PropId.byIndex(SLOT_REMARK))) {
                    return false;
                }
                if (__remarkLoaded && !Objects.equals(__remarkValue, __other.remark())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_VERSION)) != __other.__isVisible(PropId.byIndex(SLOT_VERSION))) {
                    return false;
                }
                boolean __versionLoaded = this.__versionLoaded;
                if (__versionLoaded != __other.__isLoaded(PropId.byIndex(SLOT_VERSION))) {
                    return false;
                }
                if (__versionLoaded && __versionValue != __other.version()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_SORT)) != __other.__isVisible(PropId.byIndex(SLOT_SORT))) {
                    return false;
                }
                boolean __sortLoaded = this.__sortLoaded;
                if (__sortLoaded != __other.__isLoaded(PropId.byIndex(SLOT_SORT))) {
                    return false;
                }
                if (__sortLoaded && !Objects.equals(__sortValue, __other.sort())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DELETED)) != __other.__isVisible(PropId.byIndex(SLOT_DELETED))) {
                    return false;
                }
                boolean __deletedLoaded = this.__deletedLoaded;
                if (__deletedLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DELETED))) {
                    return false;
                }
                if (__deletedLoaded && __deletedValue != __other.deleted()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UNION_ID)) != __other.__isVisible(PropId.byIndex(SLOT_UNION_ID))) {
                    return false;
                }
                boolean __unionIdLoaded = this.__unionIdLoaded;
                if (__unionIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UNION_ID))) {
                    return false;
                }
                if (__unionIdLoaded && !Objects.equals(__unionIdValue, __other.unionId())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_CREATE_BY))) {
                    return false;
                }
                boolean __createByLoaded = this.__createByLoaded;
                if (__createByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_BY))) {
                    return false;
                }
                if (__createByLoaded && !Objects.equals(__createByValue, __other.createBy())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                boolean __createTimeLoaded = this.__createTimeLoaded;
                if (__createTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                if (__createTimeLoaded && !Objects.equals(__createTimeValue, __other.createTime())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_BY))) {
                    return false;
                }
                boolean __updateByLoaded = this.__updateByLoaded;
                if (__updateByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UPDATE_BY))) {
                    return false;
                }
                if (__updateByLoaded && !Objects.equals(__updateByValue, __other.updateBy())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                boolean __updateTimeLoaded = this.__updateTimeLoaded;
                if (__updateTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                if (__updateTimeLoaded && !Objects.equals(__updateTimeValue, __other.updateTime())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DELETE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_DELETE_BY))) {
                    return false;
                }
                boolean __deleteByLoaded = this.__deleteByLoaded;
                if (__deleteByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DELETE_BY))) {
                    return false;
                }
                if (__deleteByLoaded && !Objects.equals(__deleteByValue, __other.deleteBy())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DELETE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_DELETE_TIME))) {
                    return false;
                }
                boolean __deleteTimeLoaded = this.__deleteTimeLoaded;
                if (__deleteTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DELETE_TIME))) {
                    return false;
                }
                if (__deleteTimeLoaded && !Objects.equals(__deleteTimeValue, __other.deleteTime())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded && __idValue != __other.id()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ROLE_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_NAME))) {
                    return false;
                }
                boolean __roleNameLoaded = __roleNameValue != null;
                if (__roleNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_NAME))) {
                    return false;
                }
                if (__roleNameLoaded && __roleNameValue != __other.roleName()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DATA_SCOPE)) != __other.__isVisible(PropId.byIndex(SLOT_DATA_SCOPE))) {
                    return false;
                }
                boolean __dataScopeLoaded = this.__dataScopeLoaded;
                if (__dataScopeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DATA_SCOPE))) {
                    return false;
                }
                if (__dataScopeLoaded && __dataScopeValue != __other.dataScope()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DATA_STATUS)) != __other.__isVisible(PropId.byIndex(SLOT_DATA_STATUS))) {
                    return false;
                }
                boolean __dataStatusLoaded = this.__dataStatusLoaded;
                if (__dataStatusLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DATA_STATUS))) {
                    return false;
                }
                if (__dataStatusLoaded && __dataStatusValue != __other.dataStatus()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_REMARK)) != __other.__isVisible(PropId.byIndex(SLOT_REMARK))) {
                    return false;
                }
                boolean __remarkLoaded = this.__remarkLoaded;
                if (__remarkLoaded != __other.__isLoaded(PropId.byIndex(SLOT_REMARK))) {
                    return false;
                }
                if (__remarkLoaded && __remarkValue != __other.remark()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_VERSION)) != __other.__isVisible(PropId.byIndex(SLOT_VERSION))) {
                    return false;
                }
                boolean __versionLoaded = this.__versionLoaded;
                if (__versionLoaded != __other.__isLoaded(PropId.byIndex(SLOT_VERSION))) {
                    return false;
                }
                if (__versionLoaded && __versionValue != __other.version()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_SORT)) != __other.__isVisible(PropId.byIndex(SLOT_SORT))) {
                    return false;
                }
                boolean __sortLoaded = this.__sortLoaded;
                if (__sortLoaded != __other.__isLoaded(PropId.byIndex(SLOT_SORT))) {
                    return false;
                }
                if (__sortLoaded && __sortValue != __other.sort()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DELETED)) != __other.__isVisible(PropId.byIndex(SLOT_DELETED))) {
                    return false;
                }
                boolean __deletedLoaded = this.__deletedLoaded;
                if (__deletedLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DELETED))) {
                    return false;
                }
                if (__deletedLoaded && __deletedValue != __other.deleted()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UNION_ID)) != __other.__isVisible(PropId.byIndex(SLOT_UNION_ID))) {
                    return false;
                }
                boolean __unionIdLoaded = this.__unionIdLoaded;
                if (__unionIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UNION_ID))) {
                    return false;
                }
                if (__unionIdLoaded && __unionIdValue != __other.unionId()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_CREATE_BY))) {
                    return false;
                }
                boolean __createByLoaded = this.__createByLoaded;
                if (__createByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_BY))) {
                    return false;
                }
                if (__createByLoaded && __createByValue != __other.createBy()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                boolean __createTimeLoaded = this.__createTimeLoaded;
                if (__createTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                if (__createTimeLoaded && __createTimeValue != __other.createTime()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_BY))) {
                    return false;
                }
                boolean __updateByLoaded = this.__updateByLoaded;
                if (__updateByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UPDATE_BY))) {
                    return false;
                }
                if (__updateByLoaded && __updateByValue != __other.updateBy()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                boolean __updateTimeLoaded = this.__updateTimeLoaded;
                if (__updateTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                if (__updateTimeLoaded && __updateTimeValue != __other.updateTime()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DELETE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_DELETE_BY))) {
                    return false;
                }
                boolean __deleteByLoaded = this.__deleteByLoaded;
                if (__deleteByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DELETE_BY))) {
                    return false;
                }
                if (__deleteByLoaded && __deleteByValue != __other.deleteBy()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DELETE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_DELETE_TIME))) {
                    return false;
                }
                boolean __deleteTimeLoaded = this.__deleteTimeLoaded;
                if (__deleteTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DELETE_TIME))) {
                    return false;
                }
                if (__deleteTimeLoaded && __deleteTimeValue != __other.deleteTime()) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return shallow ? __shallowEquals(obj) : equals(obj);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }
        }

        @GeneratedBy(
                type = RoleEntity.class
        )
        private static class DraftImpl extends Implementor implements DraftSpi, RoleEntityDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            private RoleEntity __resolved;

            DraftImpl(DraftContext ctx, RoleEntity base) {
                __ctx = ctx;
                if (base != null) {
                    __base = (Impl)base;
                }
                else {
                    __modified = new Impl();
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isLoaded(String prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isVisible(PropId prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public boolean __isVisible(String prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public int hashCode() {
                return (__modified!= null ? __modified : __base).hashCode();
            }

            @Override
            public int __hashCode(boolean shallow) {
                return (__modified!= null ? __modified : __base).__hashCode(shallow);
            }

            @Override
            public boolean equals(Object obj) {
                return (__modified!= null ? __modified : __base).equals(obj);
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return (__modified!= null ? __modified : __base).__equals(obj, shallow);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }

            @Override
            @JsonIgnore
            public long id() {
                return (__modified!= null ? __modified : __base).id();
            }

            @Override
            public RoleEntityDraft setId(long id) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__idValue = id;
                __tmpModified.__idLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String roleName() {
                return (__modified!= null ? __modified : __base).roleName();
            }

            @Override
            public RoleEntityDraft setRoleName(String roleName) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (roleName == null) {
                    throw new IllegalArgumentException(
                        "'roleName' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__roleNameValue = roleName;
                return this;
            }

            @Override
            @JsonIgnore
            public int dataScope() {
                return (__modified!= null ? __modified : __base).dataScope();
            }

            @Override
            public RoleEntityDraft setDataScope(int dataScope) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__dataScopeValue = dataScope;
                __tmpModified.__dataScopeLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public int dataStatus() {
                return (__modified!= null ? __modified : __base).dataStatus();
            }

            @Override
            public RoleEntityDraft setDataStatus(int dataStatus) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__dataStatusValue = dataStatus;
                __tmpModified.__dataStatusLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public String remark() {
                return (__modified!= null ? __modified : __base).remark();
            }

            @Override
            public RoleEntityDraft setRemark(String remark) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__remarkValue = remark;
                __tmpModified.__remarkLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public long version() {
                return (__modified!= null ? __modified : __base).version();
            }

            @Override
            public RoleEntityDraft setVersion(long version) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__versionValue = version;
                __tmpModified.__versionLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public Integer sort() {
                return (__modified!= null ? __modified : __base).sort();
            }

            @Override
            public RoleEntityDraft setSort(Integer sort) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__sortValue = sort;
                __tmpModified.__sortLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public int deleted() {
                return (__modified!= null ? __modified : __base).deleted();
            }

            @Override
            public RoleEntityDraft setDeleted(int deleted) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__deletedValue = deleted;
                __tmpModified.__deletedLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public Long unionId() {
                return (__modified!= null ? __modified : __base).unionId();
            }

            @Override
            public RoleEntityDraft setUnionId(Long unionId) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__unionIdValue = unionId;
                __tmpModified.__unionIdLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public Long createBy() {
                return (__modified!= null ? __modified : __base).createBy();
            }

            @Override
            public RoleEntityDraft setCreateBy(Long createBy) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__createByValue = createBy;
                __tmpModified.__createByLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public LocalDateTime createTime() {
                return (__modified!= null ? __modified : __base).createTime();
            }

            @Override
            public RoleEntityDraft setCreateTime(LocalDateTime createTime) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__createTimeValue = createTime;
                __tmpModified.__createTimeLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public Long updateBy() {
                return (__modified!= null ? __modified : __base).updateBy();
            }

            @Override
            public RoleEntityDraft setUpdateBy(Long updateBy) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__updateByValue = updateBy;
                __tmpModified.__updateByLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public LocalDateTime updateTime() {
                return (__modified!= null ? __modified : __base).updateTime();
            }

            @Override
            public RoleEntityDraft setUpdateTime(LocalDateTime updateTime) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__updateTimeValue = updateTime;
                __tmpModified.__updateTimeLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public Long deleteBy() {
                return (__modified!= null ? __modified : __base).deleteBy();
            }

            @Override
            public RoleEntityDraft setDeleteBy(Long deleteBy) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__deleteByValue = deleteBy;
                __tmpModified.__deleteByLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jetbrains.annotations.Nullable
            public LocalDateTime deleteTime() {
                return (__modified!= null ? __modified : __base).deleteTime();
            }

            @Override
            public RoleEntityDraft setDeleteTime(LocalDateTime deleteTime) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__deleteTimeValue = deleteTime;
                __tmpModified.__deleteTimeLoaded = true;
                return this;
            }

            @SuppressWarnings("all")
            @Override
            public void __set(PropId prop, Object value) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__set(prop.asName(), value);
                    return;
                    case SLOT_ID:
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case SLOT_ROLE_NAME:
                    		setRoleName((String)value);break;
                    case SLOT_DATA_SCOPE:
                    		if (value == null) throw new IllegalArgumentException("'dataScope' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setDataScope((Integer)value);
                            break;
                    case SLOT_DATA_STATUS:
                    		if (value == null) throw new IllegalArgumentException("'dataStatus' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setDataStatus((Integer)value);
                            break;
                    case SLOT_REMARK:
                    		setRemark((String)value);break;
                    case SLOT_VERSION:
                    		if (value == null) throw new IllegalArgumentException("'version' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setVersion((Long)value);
                            break;
                    case SLOT_SORT:
                    		setSort((Integer)value);break;
                    case SLOT_DELETED:
                    		if (value == null) throw new IllegalArgumentException("'deleted' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setDeleted((Integer)value);
                            break;
                    case SLOT_UNION_ID:
                    		setUnionId((Long)value);break;
                    case SLOT_CREATE_BY:
                    		setCreateBy((Long)value);break;
                    case SLOT_CREATE_TIME:
                    		setCreateTime((LocalDateTime)value);break;
                    case SLOT_UPDATE_BY:
                    		setUpdateBy((Long)value);break;
                    case SLOT_UPDATE_TIME:
                    		setUpdateTime((LocalDateTime)value);break;
                    case SLOT_DELETE_BY:
                    		setDeleteBy((Long)value);break;
                    case SLOT_DELETE_TIME:
                    		setDeleteTime((LocalDateTime)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"io.github.yibird.model.entity.RoleEntity\": \"" + prop + "\"");
                }
            }

            @SuppressWarnings("all")
            @Override
            public void __set(String prop, Object value) {
                switch (prop) {
                    case "id":
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case "roleName":
                    		setRoleName((String)value);break;
                    case "dataScope":
                    		if (value == null) throw new IllegalArgumentException("'dataScope' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setDataScope((Integer)value);
                            break;
                    case "dataStatus":
                    		if (value == null) throw new IllegalArgumentException("'dataStatus' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setDataStatus((Integer)value);
                            break;
                    case "remark":
                    		setRemark((String)value);break;
                    case "version":
                    		if (value == null) throw new IllegalArgumentException("'version' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setVersion((Long)value);
                            break;
                    case "sort":
                    		setSort((Integer)value);break;
                    case "deleted":
                    		if (value == null) throw new IllegalArgumentException("'deleted' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setDeleted((Integer)value);
                            break;
                    case "unionId":
                    		setUnionId((Long)value);break;
                    case "createBy":
                    		setCreateBy((Long)value);break;
                    case "createTime":
                    		setCreateTime((LocalDateTime)value);break;
                    case "updateBy":
                    		setUpdateBy((Long)value);break;
                    case "updateTime":
                    		setUpdateTime((LocalDateTime)value);break;
                    case "deleteBy":
                    		setDeleteBy((Long)value);break;
                    case "deleteTime":
                    		setDeleteTime((LocalDateTime)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"io.github.yibird.model.entity.RoleEntity\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(15);
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__show(prop.asName(), visible);
                    return;
                    case SLOT_ID:
                    		__visibility.show(SLOT_ID, visible);break;
                    case SLOT_ROLE_NAME:
                    		__visibility.show(SLOT_ROLE_NAME, visible);break;
                    case SLOT_DATA_SCOPE:
                    		__visibility.show(SLOT_DATA_SCOPE, visible);break;
                    case SLOT_DATA_STATUS:
                    		__visibility.show(SLOT_DATA_STATUS, visible);break;
                    case SLOT_REMARK:
                    		__visibility.show(SLOT_REMARK, visible);break;
                    case SLOT_VERSION:
                    		__visibility.show(SLOT_VERSION, visible);break;
                    case SLOT_SORT:
                    		__visibility.show(SLOT_SORT, visible);break;
                    case SLOT_DELETED:
                    		__visibility.show(SLOT_DELETED, visible);break;
                    case SLOT_UNION_ID:
                    		__visibility.show(SLOT_UNION_ID, visible);break;
                    case SLOT_CREATE_BY:
                    		__visibility.show(SLOT_CREATE_BY, visible);break;
                    case SLOT_CREATE_TIME:
                    		__visibility.show(SLOT_CREATE_TIME, visible);break;
                    case SLOT_UPDATE_BY:
                    		__visibility.show(SLOT_UPDATE_BY, visible);break;
                    case SLOT_UPDATE_TIME:
                    		__visibility.show(SLOT_UPDATE_TIME, visible);break;
                    case SLOT_DELETE_BY:
                    		__visibility.show(SLOT_DELETE_BY, visible);break;
                    case SLOT_DELETE_TIME:
                    		__visibility.show(SLOT_DELETE_TIME, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"io.github.yibird.model.entity.RoleEntity\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __show(String prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(15);
                }
                switch (prop) {
                    case "id":
                    		__visibility.show(SLOT_ID, visible);break;
                    case "roleName":
                    		__visibility.show(SLOT_ROLE_NAME, visible);break;
                    case "dataScope":
                    		__visibility.show(SLOT_DATA_SCOPE, visible);break;
                    case "dataStatus":
                    		__visibility.show(SLOT_DATA_STATUS, visible);break;
                    case "remark":
                    		__visibility.show(SLOT_REMARK, visible);break;
                    case "version":
                    		__visibility.show(SLOT_VERSION, visible);break;
                    case "sort":
                    		__visibility.show(SLOT_SORT, visible);break;
                    case "deleted":
                    		__visibility.show(SLOT_DELETED, visible);break;
                    case "unionId":
                    		__visibility.show(SLOT_UNION_ID, visible);break;
                    case "createBy":
                    		__visibility.show(SLOT_CREATE_BY, visible);break;
                    case "createTime":
                    		__visibility.show(SLOT_CREATE_TIME, visible);break;
                    case "updateBy":
                    		__visibility.show(SLOT_UPDATE_BY, visible);break;
                    case "updateTime":
                    		__visibility.show(SLOT_UPDATE_TIME, visible);break;
                    case "deleteBy":
                    		__visibility.show(SLOT_DELETE_BY, visible);break;
                    case "deleteTime":
                    		__visibility.show(SLOT_DELETE_TIME, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"io.github.yibird.model.entity.RoleEntity\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __unload(PropId prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__unload(prop.asName());
                    return;
                    case SLOT_ID:
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case SLOT_ROLE_NAME:
                    		__modified().__roleNameValue = null;break;
                    case SLOT_DATA_SCOPE:
                    		__modified().__dataScopeValue = 0;
                    __modified().__dataScopeLoaded = false;break;
                    case SLOT_DATA_STATUS:
                    		__modified().__dataStatusValue = 0;
                    __modified().__dataStatusLoaded = false;break;
                    case SLOT_REMARK:
                    		__modified().__remarkValue = null;
                    __modified().__remarkLoaded = false;break;
                    case SLOT_VERSION:
                    		__modified().__versionValue = 0;
                    __modified().__versionLoaded = false;break;
                    case SLOT_SORT:
                    		__modified().__sortValue = null;
                    __modified().__sortLoaded = false;break;
                    case SLOT_DELETED:
                    		__modified().__deletedValue = 0;
                    __modified().__deletedLoaded = false;break;
                    case SLOT_UNION_ID:
                    		__modified().__unionIdValue = null;
                    __modified().__unionIdLoaded = false;break;
                    case SLOT_CREATE_BY:
                    		__modified().__createByValue = null;
                    __modified().__createByLoaded = false;break;
                    case SLOT_CREATE_TIME:
                    		__modified().__createTimeValue = null;
                    __modified().__createTimeLoaded = false;break;
                    case SLOT_UPDATE_BY:
                    		__modified().__updateByValue = null;
                    __modified().__updateByLoaded = false;break;
                    case SLOT_UPDATE_TIME:
                    		__modified().__updateTimeValue = null;
                    __modified().__updateTimeLoaded = false;break;
                    case SLOT_DELETE_BY:
                    		__modified().__deleteByValue = null;
                    __modified().__deleteByLoaded = false;break;
                    case SLOT_DELETE_TIME:
                    		__modified().__deleteTimeValue = null;
                    __modified().__deleteTimeLoaded = false;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"io.github.yibird.model.entity.RoleEntity\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                switch (prop) {
                    case "id":
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case "roleName":
                    		__modified().__roleNameValue = null;break;
                    case "dataScope":
                    		__modified().__dataScopeValue = 0;
                    __modified().__dataScopeLoaded = false;break;
                    case "dataStatus":
                    		__modified().__dataStatusValue = 0;
                    __modified().__dataStatusLoaded = false;break;
                    case "remark":
                    		__modified().__remarkValue = null;
                    __modified().__remarkLoaded = false;break;
                    case "version":
                    		__modified().__versionValue = 0;
                    __modified().__versionLoaded = false;break;
                    case "sort":
                    		__modified().__sortValue = null;
                    __modified().__sortLoaded = false;break;
                    case "deleted":
                    		__modified().__deletedValue = 0;
                    __modified().__deletedLoaded = false;break;
                    case "unionId":
                    		__modified().__unionIdValue = null;
                    __modified().__unionIdLoaded = false;break;
                    case "createBy":
                    		__modified().__createByValue = null;
                    __modified().__createByLoaded = false;break;
                    case "createTime":
                    		__modified().__createTimeValue = null;
                    __modified().__createTimeLoaded = false;break;
                    case "updateBy":
                    		__modified().__updateByValue = null;
                    __modified().__updateByLoaded = false;break;
                    case "updateTime":
                    		__modified().__updateTimeValue = null;
                    __modified().__updateTimeLoaded = false;break;
                    case "deleteBy":
                    		__modified().__deleteByValue = null;
                    __modified().__deleteByLoaded = false;break;
                    case "deleteTime":
                    		__modified().__deleteTimeValue = null;
                    __modified().__deleteTimeLoaded = false;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"io.github.yibird.model.entity.RoleEntity\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public DraftContext __draftContext() {
                return __ctx;
            }

            @Override
            public Object __resolve() {
                if (__resolved != null) {
                    return __resolved;
                }
                if (__resolving) {
                    throw new CircularReferenceException();
                }
                __resolving = true;
                try {
                    Implementor base = __base;
                    Impl __tmpModified = __modified;
                    if (__base != null && __tmpModified == null) {
                        this.__resolved = base;
                        return base;
                    }
                    this.__resolved = __tmpModified;
                    return __tmpModified;
                }
                finally {
                    __resolving = false;
                }
            }

            @Override
            public boolean __isResolved() {
                return __resolved != null;
            }

            Impl __modified() {
                Impl __tmpModified = __modified;
                if (__tmpModified == null) {
                    __tmpModified = __base.clone();
                    __modified = __tmpModified;
                }
                return __tmpModified;
            }
        }
    }

    @GeneratedBy(
            type = RoleEntity.class
    )
    class Builder {
        private final Producer.DraftImpl __draft;

        public Builder() {
            this(null);
        }

        public Builder(@org.jetbrains.annotations.Nullable RoleEntity base) {
            __draft = new Producer.DraftImpl(null, base);
        }

        public Builder id(@NotNull Long id) {
            if (id != null) {
                __draft.setId(id);
            }
            return this;
        }

        public Builder roleName(@NotNull String roleName) {
            if (roleName != null) {
                __draft.setRoleName(roleName);
            }
            return this;
        }

        public Builder dataScope(@NotNull Integer dataScope) {
            if (dataScope != null) {
                __draft.setDataScope(dataScope);
            }
            return this;
        }

        public Builder dataStatus(@NotNull Integer dataStatus) {
            if (dataStatus != null) {
                __draft.setDataStatus(dataStatus);
            }
            return this;
        }

        public Builder remark(@org.jetbrains.annotations.Nullable String remark) {
            __draft.setRemark(remark);
            return this;
        }

        public Builder version(@NotNull Long version) {
            if (version != null) {
                __draft.setVersion(version);
            }
            return this;
        }

        public Builder sort(@org.jetbrains.annotations.Nullable Integer sort) {
            __draft.setSort(sort);
            return this;
        }

        public Builder deleted(@NotNull Integer deleted) {
            if (deleted != null) {
                __draft.setDeleted(deleted);
            }
            return this;
        }

        public Builder unionId(@org.jetbrains.annotations.Nullable Long unionId) {
            __draft.setUnionId(unionId);
            return this;
        }

        public Builder createBy(@org.jetbrains.annotations.Nullable Long createBy) {
            __draft.setCreateBy(createBy);
            return this;
        }

        public Builder createTime(@org.jetbrains.annotations.Nullable LocalDateTime createTime) {
            __draft.setCreateTime(createTime);
            return this;
        }

        public Builder updateBy(@org.jetbrains.annotations.Nullable Long updateBy) {
            __draft.setUpdateBy(updateBy);
            return this;
        }

        public Builder updateTime(@org.jetbrains.annotations.Nullable LocalDateTime updateTime) {
            __draft.setUpdateTime(updateTime);
            return this;
        }

        public Builder deleteBy(@org.jetbrains.annotations.Nullable Long deleteBy) {
            __draft.setDeleteBy(deleteBy);
            return this;
        }

        public Builder deleteTime(@org.jetbrains.annotations.Nullable LocalDateTime deleteTime) {
            __draft.setDeleteTime(deleteTime);
            return this;
        }

        public RoleEntity build() {
            return (RoleEntity)__draft.__modified();
        }
    }
}

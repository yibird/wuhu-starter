package io.github.yibird.starter.extension.curd.core.autoconfigure;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.lang.NonNull;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPatternParser;

import io.github.yibird.starter.extension.curd.core.annotation.CrudApi;
import io.github.yibird.starter.extension.curd.core.annotation.CrudRequestMapping;
import io.github.yibird.starter.extension.curd.core.enums.Api;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Description crud请求映射器处理器映射器
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:52
 */
public class CrudRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    public CrudRequestMappingHandlerMapping() {
        // 使用 Spring 默认的 PathPatternParser
        setPatternParser(PathPatternParser.defaultInstance);
    }

    /**
     * 让 Spring 也把带 @CrudRequestMapping 的类当成 Handler 来处理
     */
    @Override
    protected boolean isHandler(@NotNull Class<?> beanType) {
        // 既保留 Spring 默认的 @Controller / @RestController，也识别我们的 @CrudRequestMapping
        return (AnnotatedElementUtils.hasAnnotation(beanType, CrudRequestMapping.class)
                || super.isHandler(beanType));
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(@NonNull Method method, @NonNull Class<?> handlerType) {
        // 先尝试拿子类自己声明的 @RequestMapping / @GetMapping 等
        RequestMappingInfo mapping = super.getMappingForMethod(method, handlerType);

        // 如果子类里没声明，就尝试去父类（BaseController）里找
        if (mapping == null) {
            Method specific = getUserDeclaredMethod(method, handlerType);
            if (specific != null && specific != method) {
                mapping = super.getMappingForMethod(specific, specific.getDeclaringClass());
            }
        }

        if (mapping == null) {
            return null;
        }

        // 如果这个 Controller 类没有打 @CrudRequestMapping，按默认逻辑返回
        if (!handlerType.isAnnotationPresent(CrudRequestMapping.class)) {
            return mapping;
        }

        CrudRequestMapping crm = handlerType.getDeclaredAnnotation(CrudRequestMapping.class);
        Api[] allowed = crm.api();

        // 取方法上的 @CrudApi 注解
        CrudApi ca = AnnotatedElementUtils.findMergedAnnotation(method, CrudApi.class);
        if (ca == null) {
            // 如果没标 @CrudApi，还是允许子类自定义方法（hello() 之类）
            return wrapWithPrefix(mapping, crm.value());
        }
        Api api = ca.value();

        // 只有当这个方法是继承来的（declaringClass != handlerType）且不在 allowed 列表里，才过滤掉
        if (method.getDeclaringClass() != handlerType && !containsApi(allowed, api)) {
            return null;
        }

        // 最终，拼前缀返回
        return wrapWithPrefix(mapping, crm.value());
    }

    /**
     * 拿父类声明的方法（同名同参）
     */
    private Method getUserDeclaredMethod(Method method, Class<?> handlerType) {
        Class<?> userClass = ClassUtils.getUserClass(handlerType);
        try {
            return userClass.getMethod(method.getName(), method.getParameterTypes());
        } catch (NoSuchMethodException ignored) {
            return method;
        }
    }

    private boolean containsApi(Api[] apis, Api target) {
        if (apis == null) {
            return false;
        }
        for (Api a : apis) {
            if (Objects.equals(a, target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 拼接前缀
     */
    private RequestMappingInfo wrapWithPrefix(RequestMappingInfo info, String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return info;
        }
        RequestMappingInfo.BuilderConfiguration opts = new RequestMappingInfo.BuilderConfiguration();
        opts.setPatternParser(PathPatternParser.defaultInstance);
        RequestMappingInfo pre = RequestMappingInfo.paths(prefix).options(opts).build();
        return pre.combine(info);
    }

    @NotNull
    @Override
    protected RequestMappingInfo createRequestMappingInfo(@NotNull RequestMapping requestMapping, RequestCondition<?> customCondition) {
        // 保留父类默认实现
        return super.createRequestMappingInfo(requestMapping, customCondition);
    }
}
package io.github.yibird.starter.core.utils.expression;

import java.lang.reflect.Method;

/**
 * @Description 表达式上下文类
 * @Author zchengfeng
 * @Datetime 2025/4/1 23:58
 */
public class ExpressionInvokeContext {

    /**
     * 目标方法
     */
    private Method method;

    /**
     * 方法参数
     */
    private Object[] args;

    /**
     * 目标对象
     */
    private Object target;

    public ExpressionInvokeContext(Method method, Object[] args, Object target) {
        this.method = method;
        this.args = args;
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}

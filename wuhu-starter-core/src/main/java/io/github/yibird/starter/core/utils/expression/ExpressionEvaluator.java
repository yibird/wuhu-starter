package io.github.yibird.starter.core.utils.expression;

import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * @Description 表达式计算类
 * @Author zchengfeng
 * @Datetime 2025/4/1 23:56
 */
public class ExpressionEvaluator implements Function<Object, Object> {

    private final Function<Object, Object> evaluator;

    public ExpressionEvaluator(String script, Method defineMethod) {
        this.evaluator = new SpelEvaluator(script, defineMethod);
    }

    @Override
    public Object apply(Object rootObject) {
        return evaluator.apply(rootObject);
    }

    Function<Object, Object> getEvaluator() {
        return evaluator;
    }
}

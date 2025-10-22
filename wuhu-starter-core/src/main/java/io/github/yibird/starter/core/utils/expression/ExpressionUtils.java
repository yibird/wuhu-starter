package io.github.yibird.starter.core.utils.expression;

import cn.hutool.core.text.CharSequenceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Description spring el表达式工具类
 * @Author zchengfeng
 * @Datetime 2025/4/1 23:53
 */
public class ExpressionUtils {
    private static final Logger log = LoggerFactory.getLogger(ExpressionUtils.class);

    private ExpressionUtils() {
    }

    /**
     * 解析
     *
     * @param script 表达式
     * @param target 目标对象
     * @param method 目标方法
     * @param args   方法参数
     * @return 解析结果
     */
    public static Object eval(String script, Object target, Method method, Object... args) {
        try {
            if (CharSequenceUtil.isBlank(script)) {
                return null;
            }
            ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(script, method);
            ExpressionInvokeContext invokeContext = new ExpressionInvokeContext(method, args, target);
            return expressionEvaluator.apply(invokeContext);
        } catch (Exception e) {
            log.error("Error occurs when eval script \"{}\" in {} : {}", script, method, e.getMessage(), e);
            return null;
        }
    }
}

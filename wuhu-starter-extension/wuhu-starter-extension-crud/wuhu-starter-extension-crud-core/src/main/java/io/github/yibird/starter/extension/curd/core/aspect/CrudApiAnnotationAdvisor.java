package io.github.yibird.starter.extension.curd.core.aspect;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.lang.NonNull;

import java.lang.annotation.Annotation;

/**
 * @Description CRUD API 注解通知类
 * @Author zchengfeng
 * @Datetime 2025/4/7 11:03
 */
public class CrudApiAnnotationAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {
    private final Advice advice;
    private final Pointcut pointcut;

    public CrudApiAnnotationAdvisor(CrudApiAnnotationInterceptor advice, Class<? extends Annotation> annotation) {
        this.advice = advice;
        this.pointcut = new ComposablePointcut(AnnotationMatchingPointcut.forMethodAnnotation(annotation));
    }

    @Override
    @NonNull
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    @NonNull
    public Advice getAdvice() {
        return this.advice;
    }

    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
        if (this.advice instanceof BeanFactoryAware beanFactoryAware) {
            beanFactoryAware.setBeanFactory(beanFactory);
        }
    }
}

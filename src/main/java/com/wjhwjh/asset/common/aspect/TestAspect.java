package com.wjhwjh.asset.common.aspect;

import com.wjhwjh.asset.common.annotation.TestAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TestAspect {

    /**
     * 所要拦截的注解
     */
    @Pointcut("@annotation(com.wjhwjh.asset.common.annotation.TestAnnotation)")
    public void cutMethod() {

    }

    @Before("cutMethod()")
    public void before(JoinPoint joinPoint) {
        //获取注解参数
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
        System.out.println(annotation.value());
    }


}

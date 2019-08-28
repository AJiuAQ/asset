package com.wjhwjh.asset.common.config.aspect;

import com.wjhwjh.asset.common.utils.SpringContextHolder;
import com.wjhwjh.asset.entity.result.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author wjhwjh
 * @description a
 * Created in 9:18 2019/8/27
 */
@Component
@Aspect
public class ControllerAspect {


//    Map<String, BaseDo> dosths = SpringContextHolder.getApplicationContext().getBeansOfType(BaseDo.class);
//
//    @Pointcut("execution(com.wjhwjh.asset.entity.result.Result com.wjhwjh.asset.api..*.*(..))")
//    public void all(){}
//
//    @Pointcut("execution(com.wjhwjh.asset.entity.result.Result com.wjhwjh.asset.api..*.*(..))")
//    public void responseBody(){}
//
//    @Before(value = "all()")
//    public void before(JoinPoint joinPoint) throws NoSuchMethodException{
//        Object target = joinPoint.getTarget();
//        String methodName =joinPoint.getSignature().getName();
//        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
//        Method method = target.getClass().getMethod(methodName, parameterTypes);
//        dosths.values().forEach(dosths -> dosths.before(joinPoint, method));
//    }
//
//    @AfterReturning(pointcut = "responseBody()", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Result result){
//        dosths.values().forEach(dosths -> dosths.afterReturning(joinPoint, result));
//    }
}

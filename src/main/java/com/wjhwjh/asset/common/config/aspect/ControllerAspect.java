package com.wjhwjh.asset.common.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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

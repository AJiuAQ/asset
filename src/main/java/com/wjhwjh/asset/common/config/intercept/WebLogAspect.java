package com.wjhwjh.asset.common.config.intercept;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author wujinhang
 * 网页请求AOP拦截输出日志
 */
//切面类
@Aspect
@Component
public class WebLogAspect {
    //保存输出内容
    protected StringBuffer str = null;

    /**
     * 定义切入点，为com.housoo.controller包下所有类的所有方法
     */
    @Pointcut("execution(public * com.wjhwjh.asset.api..*.*(..))")
    public void webLog() {

    }

    /**
     * 切入之前执行获取客户端访问请求相关信息
     *
     * @param joinPoint 所切入方法相关内容
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = joinPoint.getSignature();
        //记录下请求的内容
        str = new StringBuffer();
        str.append("\r\n\r\n┏━━━━━ INFO [访问链接] ━━━");
        str.append("\r\n┣ FUNCTION \t ：").append(signature.getName());
        str.append("\r\n┣ CLASS    \t ：").append(signature.getDeclaringTypeName());
        str.append("\r\n┣ URL      \t ：").append(request.getRequestURL().toString());
        str.append("\r\n┣ METHOD   \t ：").append(request.getMethod());
        str.append("\r\n┣ IP       \t ：").append(request.getRemoteAddr());
        str.append("\r\n┣ JSON     \t ：");
        //获取请求参数
        Enumeration<String> enu = request.getParameterNames();
        Map<String, String> parameterMap = Maps.newHashMap();
        while (enu.hasMoreElements()) {
            String parameter = enu.nextElement();
            parameterMap.put(parameter, request.getParameter(parameter));
        }
        str.append(JSON.toJSONString(parameterMap));
        str.append("\r\n┣ RESPONSE \t ：");
    }

    /**
     * 请求成功返回之后执行
     *
     * @param ret 请求返回结果
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        //处理完请求，返回内容
        str.append(ret);
        str.append("\r\n┗━━━━━ INFO [访问链接] ━━━\r\n\r\n");
        System.out.println(str.toString());
    }

}

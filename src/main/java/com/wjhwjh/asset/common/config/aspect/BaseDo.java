package com.wjhwjh.asset.common.config.aspect;

import com.wjhwjh.asset.entity.result.Result;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
public interface BaseDo {

    void before(JoinPoint joinPoint, Method method);

    void afterReturning(JoinPoint joinPoint, Result result);
}

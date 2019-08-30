package com.wjhwjh.asset.common.config.aspect.dosth;

import com.wjhwjh.asset.common.config.annotation.PassToken;
import com.wjhwjh.asset.common.config.aspect.BaseDo;
import com.wjhwjh.asset.common.utils.JWTUtils;
import com.wjhwjh.asset.common.persistence.result.Result;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wjhwjh
 * @description token拦截验证
 * Created in 11:44 2019/8/28
 */
@Component
public class TokenValidator implements BaseDo {

    @Autowired
    private JWTUtils jwtUtils;

    @Value("Authorization")
    private String authorization;

    @Override
    public void before(JoinPoint joinPoint, Method method) {
        PassToken passToken = method.getAnnotation(PassToken.class);
        if (passToken == null) {

        }
    }

    @Override
    public void afterReturning(JoinPoint joinPoint, Result result) {

    }
}

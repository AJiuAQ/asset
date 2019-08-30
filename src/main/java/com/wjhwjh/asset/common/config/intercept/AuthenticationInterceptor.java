package com.wjhwjh.asset.common.config.intercept;

import com.alibaba.fastjson.JSON;
import com.wjhwjh.asset.common.config.annotation.PassToken;
import com.wjhwjh.asset.common.utils.JWTUtils;
import com.wjhwjh.asset.common.utils.UserUtils;
import com.wjhwjh.asset.entity.User;
import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author wjhwjh
 * token拦截器 对token进行验证
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Autowired
    private JWTUtils jwtUtils;

    @Value("Authorization")
    private String authorization;

    //会跳转/error
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String token = request.getHeader("Authorization");
        //如果不是映射的方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return false;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        } else {
            User user = UserUtils.getUser();
            if (token == null || !jwtUtils.validateToken(token) || user == null || !token.equals(user.getToken())) {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter printWriter = response.getWriter();
                printWriter.println(JSON.toJSONString(Result.failure(ResultCode.USER_NOT_TOKEN)));
            }
            return true;
        }
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}

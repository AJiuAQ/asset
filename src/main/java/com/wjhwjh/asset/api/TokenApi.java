package com.wjhwjh.asset.api;

import com.alibaba.fastjson.JSONObject;
import com.wjhwjh.asset.common.config.annotation.PassToken;
import com.wjhwjh.asset.entity.User;
import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.service.TokenService;
import com.wjhwjh.asset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wjhwjh
 * @description token相关api
 * Created in 11:03 2019/8/26
 */
@RestController
@RequestMapping("tokens")
public class TokenApi {

    /**
     * 对于POST、PUT、PATCH这种HTTP方法，统一使用 application/json，将参数放在请求体中以JSON格式传递至服务器
     * 对于GET、DELETE的HTTP方法，使用默认类型（application/x-www-form-urlencoded）
     */

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping("")
    @PassToken(required = true)
    public Result login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findByLoginName(user);
        if (userForBase == null) {
            jsonObject.put("message", "登陆失败，用户不存在");
            return Result.failure(ResultCode.USER_LOGIN_ERROR, jsonObject);
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return Result.failure(ResultCode.USER_LOGIN_ERROR, jsonObject);
            } else {
//                String token = tokenService.getToken(userForBase);
//                userService.save(userForBase);
//                userForBase.setToken(token);
                jsonObject.put("user", userForBase);
            }
        }

        return Result.success(ResultCode.SUCCESS, jsonObject);
    }

}

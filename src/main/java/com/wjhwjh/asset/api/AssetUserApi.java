package com.wjhwjh.asset.api;

import com.alibaba.fastjson.JSONObject;
import com.wjhwjh.asset.entity.AssetUser;
import com.wjhwjh.asset.entity.User;
import com.wjhwjh.asset.service.AssetUserService;
import com.wjhwjh.asset.service.TokenService;
import com.wjhwjh.asset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class AssetUserApi {

    @Autowired
    AssetUserService assetUserService;
    @Autowired
    TokenService tokenService;


    @PostMapping(value = "user", produces = "text/plain;charset=UTF-8")
    public String addUser(@RequestBody User user) {
        return JSONObject.toJSONString(assetUserService.save((AssetUser) user).toString());
    }

    @PostMapping("/login")
//    public Object login(@RequestBody User user) {
//        JSONObject jsonObject = new JSONObject();
//        User userForBase = userService.getUserByName(user);
//        if (userForBase == null) {
//            jsonObject.put("message", "登陆失败，用户不存在");
//        } else {
//            if (!userForBase.getPassword().equals(user.getPassword())) {
//                jsonObject.put("message", "登录失败,密码错误");
//            } else {
//                String token = tokenService.getToken(userForBase);
//                jsonObject.put("token", token);
//                jsonObject.put("user", userForBase);
//            }
//        }
//
//        return jsonObject;
//    }

    //    @UserLoginToken
    @GetMapping(value = "/getMessage", produces = "text/plain;charset=UTF-8")
    public String getMessage() {
        return "123";
    }
}

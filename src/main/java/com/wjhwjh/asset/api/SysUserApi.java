package com.wjhwjh.asset.api;

import com.alibaba.fastjson.JSONObject;
import com.wjhwjh.asset.entity.SysUser;
import com.wjhwjh.asset.entity.User;
import com.wjhwjh.asset.entity.result.Result;
import com.wjhwjh.asset.entity.result.ResultCode;
import com.wjhwjh.asset.service.SysUserService;
import com.wjhwjh.asset.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("sysUsers")
public class SysUserApi {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    TokenService tokenService;

    @GetMapping("/{sysUserId}")
    public Result getSysUser(@PathVariable("sysUserId") Long sysUserId) {
        return Result.success(ResultCode.SUCCESS, sysUserService.findUserById(sysUserId));
    }

    @PostMapping(value = "", produces = "text/plain;charset=UTF-8")
    public Result addUser(@Valid @RequestBody SysUser sysUser) {
        return Result.success(ResultCode.SUCCESS, sysUserService.save(sysUser));
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

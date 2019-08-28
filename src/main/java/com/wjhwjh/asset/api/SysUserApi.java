package com.wjhwjh.asset.api;

import com.wjhwjh.asset.common.config.annotation.PassToken;
import com.wjhwjh.asset.entity.SysUser;
import com.wjhwjh.asset.entity.result.Result;
import com.wjhwjh.asset.entity.result.ResultCode;
import com.wjhwjh.asset.service.SysUserService;
import com.wjhwjh.asset.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return Result.success(ResultCode.SUCCESS, sysUserService.findById(sysUserId));
    }

    @PostMapping()
    public Result addSysUser(@Valid @RequestBody SysUser sysUser) {
        return Result.success(ResultCode.SUCCESS, sysUserService.save(sysUser));
    }

    @PostMapping("/{sysUserId}")
    public Result fDelSysUser(@PathVariable("sysUserId") Long sysUserId) {
        sysUserService.fDelById(sysUserId);
        return Result.success(ResultCode.SUCCESS);
    }

    @DeleteMapping("/{sysUserId}")
    @ResponseStatus(HttpStatus.OK)
    public Result tDelSysUser(@PathVariable("sysUserId") Long sysUserId) {
        sysUserService.tDelById(sysUserId);
        return Result.success(ResultCode.SUCCESS);
    }

    @GetMapping(value = "/getMessage", produces = "text/plain;charset=UTF-8")
    public String getMessage() {
        return "123";
    }
}

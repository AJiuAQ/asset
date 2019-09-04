package com.wjhwjh.asset.api;

import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.entity.SysUser;
import com.wjhwjh.asset.service.SysUserService;
import com.wjhwjh.asset.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author wjhwjh
 * @description a
 * Created in 16:23 2019/8/29
 */
public class Api<T> {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    TokenService tokenService;

    @GetMapping
    public Result getSysUsers(SysUser sysUser) {
        return Result.success(ResultCode.SUCCESS, sysUserService.findList());
    }

    @GetMapping("/{sysUserId}")
    public Result getSysUser(@PathVariable("sysUserId") Long sysUserId) {
        return Result.success(ResultCode.SUCCESS, sysUserService.findById(sysUserId));
    }

    @PostMapping()
    public Result addSysUser(@Valid @RequestBody SysUser sysUser) {
        return Result.success(ResultCode.SUCCESS, sysUserService.save(sysUser));
    }

    @PutMapping
    public Result updateSysUser(@Valid @RequestBody SysUser sysUser) {
        return Result.success(ResultCode.SUCCESS, sysUserService.update(sysUser));
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


}

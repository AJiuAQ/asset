package com.wjhwjh.asset.api;

import com.alibaba.fastjson.JSONObject;
import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.entity.SysMenu;
import com.wjhwjh.asset.service.SysMenuService;
import com.wjhwjh.asset.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("sysMenus")
public class SysMenuApi {

    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    TokenService tokenService;

    @GetMapping
    public Result getSysMenus(SysMenu sysMenu) {
        return Result.success(ResultCode.SUCCESS, sysMenuService.findChild());
    }

    @GetMapping("/{sysMenuId}")
    public Result getSysMenu(@PathVariable("sysMenuId") Long sysMenuId) {
        return Result.success(ResultCode.SUCCESS, sysMenuService.findById(sysMenuId));
    }

    @PostMapping()
    public Result addSysMenu(@Valid @RequestBody SysMenu sysMenu) {
        return Result.success(ResultCode.SUCCESS, sysMenuService.save(sysMenu));
    }

    @PutMapping
    public Result updateSysMenu(@Valid @RequestBody SysMenu sysMenu) {
        return Result.success(ResultCode.SUCCESS, sysMenuService.update(sysMenu));
    }

    @PostMapping("/{sysMenuId}")
    public Result fDelSysMenu(@PathVariable("sysMenuId") Long sysMenuId) {
        sysMenuService.fDelById(sysMenuId);
        return Result.success(ResultCode.SUCCESS);
    }

    @DeleteMapping("/{sysMenuId}")
    @ResponseStatus(HttpStatus.OK)
    public Result tDelSysMenu(@PathVariable("sysMenuId") Long sysMenuId) {
        sysMenuService.tDelById(sysMenuId);
        return Result.success(ResultCode.SUCCESS);
    }

}

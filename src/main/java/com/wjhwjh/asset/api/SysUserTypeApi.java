package com.wjhwjh.asset.api;

import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.entity.SysUserType;
import com.wjhwjh.asset.service.SysUserTypeService;
import com.wjhwjh.asset.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("sysUserTypes")
public class SysUserTypeApi {

    @Autowired
    SysUserTypeService sysUserTypeService;
    @Autowired
    TokenService tokenService;

    @GetMapping
    public Result getSysUserTypes(SysUserType sysUserType) {
        return Result.success(ResultCode.SUCCESS, sysUserTypeService.findList());
    }

    @GetMapping("/{sysUserTypeId}")
    public Result getSysUserType(@PathVariable("sysUserTypeId") Long sysUserTypeId) {
        return Result.success(ResultCode.SUCCESS, sysUserTypeService.findById(sysUserTypeId));
    }

    @PostMapping()
    public Result addSysUserType(@Valid @RequestBody SysUserType sysUserType) {
        return Result.success(ResultCode.SUCCESS, sysUserTypeService.save(sysUserType));
    }

    @PutMapping
    public Result updateSysUserType(@Valid @RequestBody SysUserType sysUserType) {
        return Result.success(ResultCode.SUCCESS, sysUserTypeService.update(sysUserType));
    }

    @PostMapping("/{sysUserTypeId}")
    public Result fDelSysUserType(@PathVariable("sysUserTypeId") Long sysUserTypeId) {
        sysUserTypeService.fDelById(sysUserTypeId);
        return Result.success(ResultCode.SUCCESS);
    }

    @DeleteMapping("/{sysUserTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public Result tDelSysUserType(@PathVariable("sysUserTypeId") Long sysUserTypeId) {
        sysUserTypeService.tDelById(sysUserTypeId);
        return Result.success(ResultCode.SUCCESS);
    }

}

package com.wjhwjh.asset.api;

import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.entity.AssetUser;
import com.wjhwjh.asset.entity.SysUser;
import com.wjhwjh.asset.service.AssetUserService;
import com.wjhwjh.asset.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("assetUsers")
public class AssetUserApi {

    @Autowired
    AssetUserService assetUserService;
    @Autowired
    TokenService tokenService;

    @GetMapping
    public Result getSysUsers(AssetUser assetUser) {
        return Result.success(ResultCode.SUCCESS, assetUserService.findList(assetUser));
    }

    @GetMapping("/{assetUserId}")
    public Result getSysUser(@PathVariable("sysUserId") Long assetUserId) {
        return Result.success(ResultCode.SUCCESS, assetUserService.findById(assetUserId));
    }

    @PostMapping()
    public Result addAssetUser(@Valid @RequestBody AssetUser assetUser) {
        return Result.success(ResultCode.SUCCESS, assetUserService.save(assetUser));
    }

    @PutMapping
    public Result updateAssetUser(@Valid @RequestBody AssetUser assetUser) {
        return Result.success(ResultCode.SUCCESS, assetUserService.update(assetUser));
    }

    @PostMapping("/{assetUserId}")
    public Result fDelSysUser(@PathVariable("assetUserId") Long assetUserId) {
        assetUserService.fDelById(assetUserId);
        return Result.success(ResultCode.SUCCESS);
    }

    @DeleteMapping("/{assetUserId}")
    @ResponseStatus(HttpStatus.OK)
    public Result tDelSysUser(@PathVariable("assetUserId") Long assetUserId) {
        assetUserService.tDelById(assetUserId);
        return Result.success(ResultCode.SUCCESS);
    }

}

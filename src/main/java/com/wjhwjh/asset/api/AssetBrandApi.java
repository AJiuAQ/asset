package com.wjhwjh.asset.api;

import com.wjhwjh.asset.entity.AssetBrand;
import com.wjhwjh.asset.entity.result.Result;
import com.wjhwjh.asset.entity.result.ResultCode;
import com.wjhwjh.asset.service.AssetBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:25 2019/8/26
 */
@RestController
@RequestMapping("brands")
public class AssetBrandApi {

    @Autowired
    AssetBrandService assetBrandService;

    @PostMapping("")
    public Result save(@RequestBody AssetBrand assetBrand) {
        assetBrandService.save(assetBrand);
        return Result.success(ResultCode.SUCCESS, assetBrand);
    }

}
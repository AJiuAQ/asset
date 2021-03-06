package com.wjhwjh.asset.api;

import com.wjhwjh.asset.entity.AssetProvider;
import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.service.AssetProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:25 2019/8/26
 */
@RestController
@RequestMapping("assetProviders")
public class AssetProviderApi {

    @Autowired
    AssetProviderService assetProviderService;

    @PostMapping("")
    public Result save(@Valid @RequestBody AssetProvider assetProvider) {
        assetProviderService.save(assetProvider);
        return Result.success(ResultCode.SUCCESS, assetProvider);
    }

}

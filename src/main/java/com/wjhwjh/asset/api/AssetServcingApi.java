package com.wjhwjh.asset.api;

import com.wjhwjh.asset.entity.AssetServcing;
import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.service.AssetServcingService;
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
@RequestMapping("assetServcings")
public class AssetServcingApi {

    @Autowired
    AssetServcingService assetServcingService;

    @PostMapping("")
    public Result save(@Valid @RequestBody AssetServcing assetServcing) {
        assetServcingService.save(assetServcing);
        return Result.success(ResultCode.SUCCESS, assetServcing);
    }

}

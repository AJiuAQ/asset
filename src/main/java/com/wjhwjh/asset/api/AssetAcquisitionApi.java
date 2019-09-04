package com.wjhwjh.asset.api;

import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.entity.AssetAcquisition;
import com.wjhwjh.asset.service.AssetAcquisitionService;
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
@RequestMapping("assetAcquisitions")
public class AssetAcquisitionApi {

    @Autowired
    AssetAcquisitionService assetAcquisitionService;

    @PostMapping("")
    public Result save(@Valid @RequestBody AssetAcquisition assetAcquisition) {
        assetAcquisitionService.save(assetAcquisition);
        return Result.success(ResultCode.SUCCESS, assetAcquisition);
    }

}

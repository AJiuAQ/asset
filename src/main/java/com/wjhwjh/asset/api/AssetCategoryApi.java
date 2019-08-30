package com.wjhwjh.asset.api;

import com.wjhwjh.asset.entity.AssetCategory;
import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.service.AssetCategoryService;
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
@RequestMapping("assetCategorys")
public class AssetCategoryApi {

    @Autowired
    AssetCategoryService assetCategoryService;

    @PostMapping("")
    public Result save(@RequestBody AssetCategory assetCategory) {
        assetCategoryService.save(assetCategory);
        return Result.success(ResultCode.SUCCESS, assetCategory);
    }

}

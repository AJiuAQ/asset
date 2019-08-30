package com.wjhwjh.asset.api;

import com.wjhwjh.asset.entity.AssetDepart;
import com.wjhwjh.asset.common.persistence.result.Result;
import com.wjhwjh.asset.common.persistence.result.ResultCode;
import com.wjhwjh.asset.service.AssetDepartService;
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
@RequestMapping("assetDeparts")
public class AssetDepartApi {

    @Autowired
    AssetDepartService assetDepartService;

    @PostMapping("")
    public Result save(@RequestBody AssetDepart assetDepart) {
        assetDepartService.save(assetDepart);
        return Result.success(ResultCode.SUCCESS, assetDepart);
    }

}

package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetBrand;
import com.wjhwjh.asset.repository.AssetBrandRepository;
import com.wjhwjh.asset.service.AssetBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetBrandServiceImpl implements AssetBrandService {

    @Autowired
    AssetBrandRepository assetBrandRepository;

    @Override
    public AssetBrand save(AssetBrand assetBrand) {
        assetBrand.preInsert();
        assetBrand = assetBrandRepository.save(assetBrand);
        return assetBrand;
    }
}

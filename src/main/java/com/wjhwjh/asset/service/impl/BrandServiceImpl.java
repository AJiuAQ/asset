package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetBrand;
import com.wjhwjh.asset.repository.BrandRepository;
import com.wjhwjh.asset.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public AssetBrand save(AssetBrand assetBrand) {
        assetBrand.preInsert();
        return brandRepository.save(assetBrand);
    }
}

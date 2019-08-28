package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetCategory;
import com.wjhwjh.asset.repository.AssetCategoryRepository;
import com.wjhwjh.asset.service.AssetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetCategoryServiceImpl implements AssetCategoryService {

    @Autowired
    AssetCategoryRepository assetCategoryRepository;

    @Override
    public AssetCategory save(AssetCategory assetCategory) {
        assetCategory.preInsert();
        return assetCategoryRepository.save(assetCategory);
    }
}

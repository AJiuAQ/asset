package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetScrapModel;
import com.wjhwjh.asset.repository.AssetScrapModelRepository;
import com.wjhwjh.asset.service.AssetScrapModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetScrapModelServiceImpl implements AssetScrapModelService {

    @Autowired
    AssetScrapModelRepository assetScrapModelRepository;

    @Override
    public AssetScrapModel save(AssetScrapModel assetScrapModel) {
        assetScrapModel.preInsert();
        assetScrapModel = assetScrapModelRepository.save(assetScrapModel);
        return assetScrapModel;
    }
}

package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.Asset;
import com.wjhwjh.asset.repository.AssetRepository;
import com.wjhwjh.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetRepository AssetRepository;

    @Override
    public Asset save(Asset asset) {
        asset.preInsert();
        asset = AssetRepository.save(asset);
        return asset;
    }
}

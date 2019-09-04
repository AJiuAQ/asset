package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetStorage;
import com.wjhwjh.asset.repository.AssetStorageRepository;
import com.wjhwjh.asset.service.AssetStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetStorageServiceImpl implements AssetStorageService {

    @Autowired
    AssetStorageRepository assetStorageRepository;

    @Override
    public AssetStorage save(AssetStorage assetStorage) {
        assetStorage.preInsert();
        assetStorage = assetStorageRepository.save(assetStorage);
        return assetStorage;
    }
}

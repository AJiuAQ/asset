package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetProviderType;
import com.wjhwjh.asset.repository.AssetProviderTypeRepository;
import com.wjhwjh.asset.service.AssetProviderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetProviderTypeServiceImpl implements AssetProviderTypeService {

    @Autowired
    AssetProviderTypeRepository assetProviderTypeRepository;

    @Override
    public AssetProviderType save(AssetProviderType assetProviderType) {
        assetProviderType.preInsert();
        assetProviderType = assetProviderTypeRepository.save(assetProviderType);
        return assetProviderType;
    }
}

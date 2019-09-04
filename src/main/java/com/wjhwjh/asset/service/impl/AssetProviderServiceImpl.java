package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetProvider;
import com.wjhwjh.asset.repository.AssetProviderRepository;
import com.wjhwjh.asset.service.AssetProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetProviderServiceImpl implements AssetProviderService {

    @Autowired
    AssetProviderRepository assetProviderRepository;

    @Override
    public AssetProvider save(AssetProvider assetProvider) {
        assetProvider.preInsert();
        assetProvider = assetProviderRepository.save(assetProvider);
        return assetProvider;
    }
}

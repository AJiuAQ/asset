package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetScrap;
import com.wjhwjh.asset.repository.AssetScrapRepository;
import com.wjhwjh.asset.service.AssetScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetScrapServiceImpl implements AssetScrapService {

    @Autowired
    AssetScrapRepository assetScrapRepository;

    @Override
    public AssetScrap save(AssetScrap assetScrap) {
        assetScrap.preInsert();
        assetScrap = assetScrapRepository.save(assetScrap);
        return assetScrap;
    }
}

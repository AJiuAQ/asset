package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetPurchase;
import com.wjhwjh.asset.repository.AssetPurchaseRepository;
import com.wjhwjh.asset.service.AssetPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetPurchaseServiceImpl implements AssetPurchaseService {

    @Autowired
    AssetPurchaseRepository assetPurchaseRepository;

    @Override
    public AssetPurchase save(AssetPurchase assetPurchase) {
        assetPurchase.preInsert();
        assetPurchase = assetPurchaseRepository.save(assetPurchase);
        return assetPurchase;
    }
}

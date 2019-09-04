package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetServcing;
import com.wjhwjh.asset.repository.AssetServcingRepository;
import com.wjhwjh.asset.service.AssetServcingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetServcingServiceImpl implements AssetServcingService {

    @Autowired
    AssetServcingRepository assetServcingRepository;

    @Override
    public AssetServcing save(AssetServcing assetServcing) {
        assetServcing.preInsert();
        assetServcing = assetServcingRepository.save(assetServcing);
        return assetServcing;
    }
}

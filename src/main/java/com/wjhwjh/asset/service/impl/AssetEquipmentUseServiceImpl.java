package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetEquipmentUse;
import com.wjhwjh.asset.repository.AssetEquipmentUseRepository;
import com.wjhwjh.asset.service.AssetEquipmentUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetEquipmentUseServiceImpl implements AssetEquipmentUseService {

    @Autowired
    AssetEquipmentUseRepository assetEquipmentUseRepository;

    @Override
    public AssetEquipmentUse save(AssetEquipmentUse assetEquipmentUse) {
        assetEquipmentUse.preInsert();
        assetEquipmentUse = assetEquipmentUseRepository.save(assetEquipmentUse);
        return assetEquipmentUse;
    }
}

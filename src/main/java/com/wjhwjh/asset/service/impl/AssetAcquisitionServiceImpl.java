package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetAcquisition;
import com.wjhwjh.asset.repository.AssetAcquisitionRepository;
import com.wjhwjh.asset.service.AssetAcquisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetAcquisitionServiceImpl implements AssetAcquisitionService {

    @Autowired
    AssetAcquisitionRepository assetAcquisitionRepository;

    @Override
    public AssetAcquisition save(AssetAcquisition assetAcquisition) {
        assetAcquisition.preInsert();
        assetAcquisition = assetAcquisitionRepository.save(assetAcquisition);
        return assetAcquisition;
    }
}

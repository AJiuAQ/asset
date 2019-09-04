package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetAcquisitionModel;
import com.wjhwjh.asset.repository.AssetAcquisitionModelRepository;
import com.wjhwjh.asset.service.AssetAcquisitionModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetAcquisitionModelServiceImpl implements AssetAcquisitionModelService {

    @Autowired
    AssetAcquisitionModelRepository assetBrandRepository;

    @Override
    public AssetAcquisitionModel save(AssetAcquisitionModel assetAcquisitionModel) {
        assetAcquisitionModel.preInsert();
        assetAcquisitionModel = assetBrandRepository.save(assetAcquisitionModel);
        return assetAcquisitionModel;
    }
}

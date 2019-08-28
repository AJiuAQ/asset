package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetDepart;
import com.wjhwjh.asset.repository.AssetDepartRepository;
import com.wjhwjh.asset.service.AssetDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetDepartServiceImpl implements AssetDepartService {

    @Autowired
    AssetDepartRepository assetDepartRepository;

    @Override
    public AssetDepart save(AssetDepart assetDepart) {
        assetDepart.preInsert();
        return assetDepartRepository.save(assetDepart);
    }
}

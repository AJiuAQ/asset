package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetUser;
import com.wjhwjh.asset.repository.AssetUserRepository;
import com.wjhwjh.asset.service.AssetUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetUserServiceImpl implements AssetUserService {

    @Autowired
    AssetUserRepository assetUserRepository;

    @Override
    public AssetUser findAssetUserById(Long id) {
        return assetUserRepository.getOne(id);
    }

    @Override
    public AssetUser save(AssetUser assetUser) {
        assetUser.preInsert();
        assetUserRepository.save(assetUser);
        return 1;
    }

    @Override
    public AssetUser findByLoginName(AssetUser assetUser) {
        if (assetUser == null) {
            return null;
        }
        String loginName = assetUser.getLoginName();
        if (StringUtils.isEmpty(loginName)) {
            return null;
        }
        return assetUserRepository.findByLoginName(loginName);
    }
}

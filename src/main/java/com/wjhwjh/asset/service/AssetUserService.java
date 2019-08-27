package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.AssetUser;

public interface AssetUserService {
    AssetUser findAssetUserById(Long id);

    AssetUser save(AssetUser assetUser);

    AssetUser findByLoginName(AssetUser assetUser);
}

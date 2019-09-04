package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.AssetUser;

import java.util.List;

public interface AssetUserService {

    AssetUser findById(Long assetUserId);

    AssetUser save(AssetUser assetUser);

    AssetUser update(AssetUser assetUser);

    AssetUser findByLoginName(AssetUser assetUser);

    List<AssetUser> findList();

    AssetUser fDelById(Long assetUserId);

    void tDelById(Long assetUserId);

}

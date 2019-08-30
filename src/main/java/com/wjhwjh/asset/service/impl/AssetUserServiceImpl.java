package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetUser;
import com.wjhwjh.asset.repository.AssetUserRepository;
import com.wjhwjh.asset.service.AssetUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjhwjh
 * assetUser服务
 */
@Service
public class AssetUserServiceImpl implements AssetUserService {

    @Autowired
    AssetUserRepository assetUserRepository;

    @Override
    public List<AssetUser> findList(AssetUser assetUser) {
        return assetUserRepository.findAll(assetUser);
    }

    @Override
    public AssetUser findById(Long assetUserId) {
        return assetUserRepository.getOne(assetUserId);
    }

    @Override
    public AssetUser save(AssetUser assetUser) {
        assetUser.preInsert();
        return assetUserRepository.save(assetUser);
    }

    @Override
    public AssetUser update(AssetUser assetUser) {
        return assetUserRepository.saveAndFlush(assetUser);
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

    @Override
    public AssetUser fDelById(Long assetUserId) {
        AssetUser assetUser = assetUserRepository.getOne(assetUserId);
        assetUser.setDel_flag(0);
        return assetUserRepository.saveAndFlush(assetUser);
    }

    @Override
    public void tDelById(Long assetUserId) {
        assetUserRepository.deleteById(assetUserId);
    }
}

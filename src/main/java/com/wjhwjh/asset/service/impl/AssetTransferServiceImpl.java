package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetTransfer;
import com.wjhwjh.asset.repository.AssetTransferRepository;
import com.wjhwjh.asset.service.AssetTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetTransferServiceImpl implements AssetTransferService {

    @Autowired
    AssetTransferRepository assetTransferRepository;

    @Override
    public AssetTransfer save(AssetTransfer assetTransfer) {
        assetTransfer.preInsert();
        assetTransfer = assetTransferRepository.save(assetTransfer);
        return assetTransfer;
    }
}

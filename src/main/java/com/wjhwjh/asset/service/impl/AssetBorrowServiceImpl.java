package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.AssetBorrow;
import com.wjhwjh.asset.repository.AssetBorrowRepository;
import com.wjhwjh.asset.service.AssetBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:23 2019/8/26
 */
@Service
public class AssetBorrowServiceImpl implements AssetBorrowService {

    @Autowired
    AssetBorrowRepository assetBorrowRepository;

    @Override
    public AssetBorrow save(AssetBorrow assetBorrow) {
        assetBorrow.preInsert();
        assetBorrow = assetBorrowRepository.save(assetBorrow);
        return assetBorrow;
    }
}

package com.wjhwjh.asset.repository;

import com.wjhwjh.asset.entity.AssetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wjhwjh
 * @description Created in 16:37 2019/8/23
 */
@Repository
public interface AssetUserRepository extends JpaRepository<AssetUser, Long> {

    List<AssetUser> findAll();

    AssetUser findByLoginName(String loginName);

    AssetUser findByNameAndPassword(String name, String password);
}

package com.wjhwjh.asset.repository;

import com.wjhwjh.asset.entity.AssetServcing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:22 2019/8/26
 */
@Repository
public interface AssetServcingRepository extends JpaRepository<AssetServcing, Long> {
}

package com.wjhwjh.asset.repository;

import com.wjhwjh.asset.entity.SysUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wjhwjh
 * @description Created in 16:37 2019/8/23
 */
@Repository
public interface SysUserTypeRepository extends JpaRepository<SysUserType, Long> {

    List<SysUserType> findAll();

    SysUserType findByName(String name);

}

package com.wjhwjh.asset.repository;

import com.wjhwjh.asset.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wjhwjh
 * @description Created in 16:37 2019/8/23
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    List<SysUser> findAll();

    SysUser findByLoginName(String loginName);

    SysUser findByNameAndPassword(String name, String password);

}

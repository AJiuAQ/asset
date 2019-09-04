package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> findList();

    SysUser findById(Long id);

    SysUser save(SysUser user);

    SysUser update(SysUser sysUser);

    SysUser findByLoginName(SysUser user);

    SysUser fDelById(Long id);

    void tDelById(Long id);

}

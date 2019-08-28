package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.SysUser;

public interface SysUserService {
    SysUser findById(Long id);

    SysUser save(SysUser user);

    SysUser findByLoginName(SysUser user);

    SysUser fDelById(Long id);

    void tDelById(Long id);
}

package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.SysUser;

public interface SysUserService {
    SysUser findUserById(Long id);

    SysUser save(SysUser user);

    SysUser findByLoginName(SysUser user);
}

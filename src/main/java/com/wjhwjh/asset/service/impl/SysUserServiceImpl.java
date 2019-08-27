package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.SysUser;
import com.wjhwjh.asset.repository.SysUserRepository;
import com.wjhwjh.asset.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public SysUser findUserById(Long id) {
        return sysUserRepository.getOne(id);
    }

    @Override
    public SysUser save(SysUser user) {
        user.preInsert();
        sysUserRepository.save(user);
        return user;
    }

    @Override
    public SysUser findByLoginName(SysUser user) {
        if (user == null) {
            return null;
        }
        String loginName = user.getLoginName();
        if (StringUtils.isEmpty(loginName)) {
            return null;
        }
        return sysUserRepository.findByLoginName(loginName);
    }
}

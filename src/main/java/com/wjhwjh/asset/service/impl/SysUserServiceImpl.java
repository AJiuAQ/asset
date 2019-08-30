package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.SysUser;
import com.wjhwjh.asset.repository.SysUserRepository;
import com.wjhwjh.asset.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public SysUser findById(Long id) {
        return sysUserRepository.getOne(id);
    }

    @Override
    public List<SysUser> findList(SysUser sysUser) {
        return sysUserRepository.findAll(sysUser);
    }

    @Override
    public SysUser save(SysUser sysUser) {
        sysUser.preInsert();
        //这里必须直接返回添加后的user 否则导致返回结果和数据库id不同
        return sysUserRepository.save(sysUser);
    }

    @Override
    public SysUser update(SysUser sysUser) {
        return sysUserRepository.saveAndFlush(sysUser);
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

    @Override
    public SysUser fDelById(Long id) {
        SysUser sysUser = sysUserRepository.getOne(id);
        sysUser.setDel_flag(1);
        return sysUserRepository.saveAndFlush(sysUser);
    }

    @Override
    public void tDelById(Long id) {
        SysUser sysUser = sysUserRepository.getOne(id);
        sysUserRepository.delete(sysUser);
    }

}

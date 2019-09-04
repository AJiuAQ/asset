package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.SysUserType;

import java.util.List;

public interface SysUserTypeService {

    List<SysUserType> findList();

    SysUserType findById(Long id);

    SysUserType findByName(String name);

    SysUserType save(SysUserType user);

    SysUserType update(SysUserType sysUserType);

    SysUserType fDelById(Long id);

    void tDelById(Long id);

}

package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.SysUserType;
import com.wjhwjh.asset.repository.SysUserTypeRepository;
import com.wjhwjh.asset.service.SysUserTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserTypeServiceImpl implements SysUserTypeService {

    @Autowired
    SysUserTypeRepository sysUserTypeRepository;

    @Override
    public SysUserType findById(Long id) {
        return sysUserTypeRepository.getOne(id);
    }

    @Override
    public SysUserType findByName(String name) {
        return sysUserTypeRepository.findByName(name);
    }

    @Override
    public List<SysUserType> findList() {
        return sysUserTypeRepository.findAll();
    }

    @Override
    public SysUserType save(SysUserType sysUserType) {
        sysUserType.preInsert();
        //这里必须直接返回添加后的user 否则导致返回结果和数据库id不同
        return sysUserTypeRepository.save(sysUserType);
    }

    @Override
    public SysUserType update(SysUserType sysUserType) {
        return sysUserTypeRepository.saveAndFlush(sysUserType);
    }

    @Override
    public SysUserType fDelById(Long id) {
        SysUserType sysUserType = sysUserTypeRepository.getOne(id);
        sysUserType.setDel_flag(1);
        return sysUserTypeRepository.saveAndFlush(sysUserType);
    }

    @Override
    public void tDelById(Long id) {
        SysUserType sysUserType = sysUserTypeRepository.getOne(id);
        sysUserTypeRepository.delete(sysUserType);
    }

}

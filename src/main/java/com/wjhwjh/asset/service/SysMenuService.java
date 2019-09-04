package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.SysMenu;

import java.util.List;

public interface SysMenuService {

    List<SysMenu> findList(SysMenu sysMenu);

    List<SysMenu> findListByType(SysMenu sysMenu);

    SysMenu findById(Long id);

    SysMenu findChild();

    SysMenu findByName(String name);

    SysMenu save(SysMenu user);

    SysMenu update(SysMenu sysMenu);

    SysMenu fDelById(Long id);

    void tDelById(Long id);

}

package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.common.utils.UserUtils;
import com.wjhwjh.asset.entity.SysMenu;
import com.wjhwjh.asset.entity.SysUserType;
import com.wjhwjh.asset.repository.SysMenuRepository;
import com.wjhwjh.asset.repository.SysUserTypeRepository;
import com.wjhwjh.asset.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    SysMenuRepository sysMenuRepository;

    @Autowired
    SysUserTypeRepository sysUserTypeRepository;

    @Override
    public SysMenu findById(Long id) {
        return sysMenuRepository.getOne(id);
    }

    @Override
    public SysMenu findChild() {
        SysMenu sysMenu = sysMenuRepository.findByName("超级菜单");
        //好长好长
        return sysMenu.childListToMap(sysMenu.getChildList(sysMenu, sysMenu.getChildMap(findListByType(sysMenu))));
    }

    @Override
    public List<SysMenu> findList(SysMenu sysMenu) {
        return sysMenuRepository.findAll();
    }

    @Override
    public List<SysMenu> findListByType(SysMenu sysMenu) {
        SysUserType sysUserType = UserUtils.getUser().getType();
        return sysMenuRepository.findAllByType(sysUserType);
    }


    @Override
    public SysMenu findByName(String name) {
        return sysMenuRepository.findByName(name);
    }

    /**
     * 保存菜单，同时对父菜单的childs字段进行更新，因为对象保存时id的问题，所以此处先保存再取出再更新
     * 因为获取子菜单时childs字段的作用更像是一个标识，所以暂未做出删除菜单时对父菜单该字段修改
     *
     * @param sysMenu
     * @return
     */
    @Override
    public SysMenu save(SysMenu sysMenu) {
        sysMenu.preInsert();
        sysMenu.setType(sysUserTypeRepository.findByName(sysMenu.getType().getName()));

        Long parentId = sysMenu.getParentMenu();
        sysMenu = sysMenuRepository.save(sysMenu);
        SysMenu parentMenu = sysMenuRepository.getOne(parentId);
        String parentChilds = parentMenu.getChilds();
        if (StringUtils.isEmpty(parentChilds)) {
            parentChilds = sysMenu.getId().toString();
        } else {
            parentChilds += "," + sysMenu.getId().toString();
        }
        parentMenu.setChilds(parentChilds);
        sysMenuRepository.saveAndFlush(parentMenu);
        //这里必须直接返回添加后的user 否则导致返回结果和数据库id不同
        return sysMenu;
    }

    @Override
    public SysMenu update(SysMenu sysMenu) {
        return sysMenuRepository.saveAndFlush(sysMenu);
    }

    @Override
    public SysMenu fDelById(Long id) {
        SysMenu sysMenu = sysMenuRepository.getOne(id);
        sysMenu.setDel_flag(1);
        return sysMenuRepository.saveAndFlush(sysMenu);
    }

    @Override
    public void tDelById(Long id) {
        SysMenu sysMenu = sysMenuRepository.getOne(id);
        sysMenuRepository.delete(sysMenu);
    }

}

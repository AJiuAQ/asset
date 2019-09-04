package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.DataEntity;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wjhwjh
 * @description a
 * Created in 14:09 2019/9/3
 */
@Data
@Entity
//@Proxy(lazy = false)
public class SysMenu extends DataEntity<SysMenu> {

    SysMenu() {
        List<SysMenu> list = new ArrayList<>();
        setChildList(list);
    }

    @Column(nullable = false)
    private String href;

    private String icon;

    private String target;

    @Column(name = "parent")
    private Long parentMenu;

    private String childs;

    @Transient
    private List<SysMenu> childList;

    @Transient
    private Map<String, Object> childMap;


    @ManyToOne
    @JoinColumn(name = "type")
    private SysUserType type;

    /**
     * 将0级菜单提取为map
     *
     * @param sysMenu
     * @return
     */
    public SysMenu childListToMap(SysMenu sysMenu) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SysMenu> list = sysMenu.getChildList();
        for (SysMenu one : list) {
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("child", one.getChildList());
            map1.put("name", one.getName());
            map1.put("icon", one.getIcon());
            map.put(one.getHref(), map1);
        }
        sysMenu.setChildMap(map);
        return sysMenu;
    }

    /**
     * 用递归的方法将这些菜单挨个添加到222222、父菜单里去
     * 话说今天早上写的，下午再看就忘了，唉，转眼间已经21岁，老的真快
     * 之前是将父菜单字段"patentMenu"用外键关联到menu表，即 我关联我自己，结果出现堆栈溢出，有兴趣可以试一试
     * 将那个字段的注解改为45、46行的这两个，name"parent"
     *
     * @param patentMenu
     * @param map
     * @return
     */
    public SysMenu getChildList(SysMenu patentMenu, Map<Long, List<SysMenu>> map) {
        List<SysMenu> temp = patentMenu.getChildList();
        for (SysMenu one : map.get(patentMenu.getId())) {
            if (StringUtils.isEmpty(one.getChilds())) {
                temp.add(one);
            } else {
                temp.add(patentMenu.getChildList(one, map));
            }
        }
        patentMenu.setChildList(temp);
        return patentMenu;
    }

    /**
     * 获取所有的父菜单包括中间级数
     *
     * @param list
     * @return
     */
    public Map<Long, List<SysMenu>> getChildMap(List<SysMenu> list) {
        Map<Long, List<SysMenu>> map = new HashMap<Long, List<SysMenu>>();
        for (SysMenu sysMenu : list) {
            if (222222 == sysMenu.getId()) {

            } else if (map.keySet().contains(sysMenu.getParentMenu())) {
                List<SysMenu> temp = map.get(sysMenu.getParentMenu());
                temp.add(sysMenu);
                map.put(sysMenu.getParentMenu(), temp);
            } else {
                List<SysMenu> temp = new ArrayList<SysMenu>();
                temp.add(sysMenu);
                map.put(sysMenu.getParentMenu(), temp);
            }
        }
        return map;
    }

}

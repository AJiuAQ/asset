package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.DataEntity;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;

/**
 * @author wjhwjh
 * @description 用户、菜单类型
 * Created in 14:12 2019/9/3
 */
@Data
@Entity
@Proxy(lazy = false)
public class SysUserType extends DataEntity<SysMenu> {

}

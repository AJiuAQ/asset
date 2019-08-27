package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.DataEntity;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author wjhwjh
 * @description a
 * Created in 16:37 2019/8/27
 */
@Data
@MappedSuperclass
@Proxy(lazy = false)
public class User extends DataEntity<User> {

    private Long userId;

}

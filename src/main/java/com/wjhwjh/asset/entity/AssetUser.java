package com.wjhwjh.asset.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Proxy(lazy = false)
public class AssetUser extends User {

    //@Column字段属性设置
    /**
     * （1）name属性：被标注字段在数据库表中所对应字段的名称；
     * （2）length属性：表示该字段的长度，当字段的类型为varchar时，该属性才有效果，默认为255个字符；
     * （3）nullable属性：表示该字段是否可以为null值，默认是true。
     * （4）unique属性：表示该字段是否为唯一标识，默认fasle。
     */
    @Column(unique = true, nullable = false, length = 20)
    private String loginName;

    private String password;

    private String token;

    @Column(length = 200)
    private String mobile;
}

package com.wjhwjh.asset.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 这两个注解将数据库新增记录主键id设置为雪花算法生成的id
 * GeneratedValu(strategy
 * GenericGenerator
 */
@Data
@Entity
@Proxy(lazy = false)
public class Stu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.wjhwjh.asset.common.utils.CustomIdGenerator")
    private Long id;
    private String name;
    private String school;
}

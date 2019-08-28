package com.wjhwjh.asset.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Proxy(lazy = false)
public class AssetUser extends User {

}

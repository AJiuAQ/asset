package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.DataEntity;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description a
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Table(name = "asset_brand")
@Proxy(lazy = false)
public class AssetBrand extends AssetEntity {

}

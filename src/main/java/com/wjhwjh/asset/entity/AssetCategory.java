package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.DataEntity;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 类别
 * Created in 16:21 2019/8/27
 */
@Data
@Entity
@Table(name = "asset_category")
@Proxy(lazy = false)
public class AssetCategory extends AssetEntity {
}

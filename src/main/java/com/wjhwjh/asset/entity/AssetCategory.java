package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.persistence.DataEntity;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 类别
 * “资产类别”作为资产信息的属性而存在。该模块用于系统管理
 * 员对资产类别进行管理，包括资产类别的新增、修改、启用和禁用。
 * Created in 16:21 2019/8/27
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetCategory extends AssetEntity {

    public AssetCategory() {
        this.code = AssetCode.ASSET_CATEGORY.getCode();
        this.code += SnowFlake.nextId();
    }
}

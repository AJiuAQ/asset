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
 * @description a
 * “品牌”作为资产信息的属性而存在。该模块用于系统管理员对
 * 品牌进行管理，包括品牌的新增、修改、启用和禁用。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetBrand extends AssetEntity {

    public AssetBrand() {
        this.code = AssetCode.ASSET_BRAND.getCode();
        this.code += SnowFlake.nextId();
    }
}

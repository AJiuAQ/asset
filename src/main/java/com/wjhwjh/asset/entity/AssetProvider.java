package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 供应商
 * “供应商”作为资产信息的属性而存在。该模块用于系统管理员
 * 对供应商进行管理，包括新增、修改、启用、禁用、查询、查看供应
 * 商信息。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetProvider extends AssetEntity {

    public AssetProvider() {
        this.code = AssetCode.ASSET_PROVIDER.getCode();
        this.code += SnowFlake.nextId();
    }
}

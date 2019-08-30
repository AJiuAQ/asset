package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 存放地点
 * “存放地点”作为资产信息的属性而存在。该模块用于系统管理
 * 员对存放地点进行管理，包括新增、修改、启用、禁用、查询存放地
 * 点。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetStorage extends AssetEntity {

    public AssetStorage() {
        this.code = AssetCode.ASSET_STRORAGE.getCode();
        this.code += SnowFlake.nextId();
    }
}

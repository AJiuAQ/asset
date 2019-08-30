package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 设备用途
 * “设备用途”作为资产申购信息的属性而存在。该模块用于系统
 * 管理员对设备用途进行管理，包括新增、修改、启用、禁用、查询设
 * 备用途。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetEquipmentUse extends AssetEntity {

    public AssetEquipmentUse() {
        this.code = AssetCode.ASSET_EQUIPMENT_USER.getCode();
        this.code += SnowFlake.nextId();
    }
}

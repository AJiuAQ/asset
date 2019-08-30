package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 取得方式
 * “取得方式”作为资产信息的属性而存在。该模块用于系统管理
 * 员对取得方式进行管理，包括取得方式的新增、修改、启用和禁用。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetAcquisitionModel extends AssetEntity {

    public AssetAcquisitionModel() {
        this.code = AssetCode.ASSET_ACQUISITION_MODEL.getCode();
        this.code += SnowFlake.nextId();
    }
}

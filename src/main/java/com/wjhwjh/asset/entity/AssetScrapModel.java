package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 报废方式
 * “报废方式”作为资产报废信息的属性而存在。该模块用于系统
 * 管理员对报废方式进行管理，包括新增、修改、启用、禁用、查询报
 * 废方式。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetScrapModel extends AssetEntity {

    public AssetScrapModel() {
        this.code = AssetCode.ASSET_SCRAP_MODEL.getCode();
        this.code += SnowFlake.nextId();
    }
}

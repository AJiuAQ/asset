package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 资产维修
 * 该模块用于资产管理员对资产的维修过程进行管理，由资产管理
 * 员记录资产维修的流水，包括资产维修登记、查询以及查看资产维修
 * 信息。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetServcing extends AssetEntity {

    public AssetServcing() {
        this.code = AssetCode.ASSET_SERVCING.getCode();
        this.code += SnowFlake.nextId();
    }
}

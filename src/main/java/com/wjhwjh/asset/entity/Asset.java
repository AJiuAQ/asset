package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 资产
 * 该模块用于资产管理员对资产的入库登记进行管理，资产管理员
 * 可以进行资产入库登记。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class Asset extends AssetEntity {

    public Asset() {
        this.code = AssetCode.ASSET.getCode();
        this.code += SnowFlake.nextId();
    }
}

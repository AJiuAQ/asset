package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 资产借还
 * 该模块用于资产管理员对资产的借还过程进行管理，资产管理员
 * 可以进行资产借用登记、归还、查询以及查看资产借还详情。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetBorrow extends AssetEntity {

    public AssetBorrow() {
        this.code = AssetCode.ASSET_BORROW.getCode();
        this.code += SnowFlake.nextId();
    }
}

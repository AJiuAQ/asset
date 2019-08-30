package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 资产申购
 * 该模块用于资产管理员对资产的申购过程进行管理，由资产管理
 * 员记录资产申购的流水，资产管理员可以进行资产申购登记、查询、
 * 修改、提交、删除以及查看资产申购详情。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetPurchase extends AssetEntity {

    public AssetPurchase() {
        this.code = AssetCode.ASSET_PURCHASE.getCode();
        this.code += SnowFlake.nextId();
    }
}

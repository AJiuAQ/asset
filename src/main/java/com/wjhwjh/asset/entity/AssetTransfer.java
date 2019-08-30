package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 资产转移
 * 该模块用于资产管理员对资产的转移过程进行管理，由资产管理
 * 员记录资产转移的流水，包括资产转移登记、查询以及查看资产转移
 * 信息。
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetTransfer extends AssetEntity {

    public AssetTransfer() {
        this.code = AssetCode.ASSET_TRANSFER.getCode();
        this.code += SnowFlake.nextId();
    }
}

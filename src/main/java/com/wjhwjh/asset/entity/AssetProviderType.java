package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 供应商类型
 * Created in 18:20 2019/8/26
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetProviderType extends AssetEntity {

    public AssetProviderType() {
        this.code = AssetCode.ASSET_PROVIDER_TYPE.getCode();
        this.code += SnowFlake.nextId();
    }
}

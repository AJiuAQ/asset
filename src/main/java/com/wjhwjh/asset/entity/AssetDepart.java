package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.AssetCode;
import com.wjhwjh.asset.common.persistence.DataEntity;
import com.wjhwjh.asset.common.utils.SnowFlake;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjhwjh
 * @description 部门
 * 该模块用于系统管理员对部门信息进行管理，系统管理员可以新
 * 增、修改部门信息。
 * Created in 16:16 2019/8/27
 */
@Data
@Entity
@Proxy(lazy = false)
public class AssetDepart extends AssetEntity {

    public AssetDepart() {
        this.code = AssetCode.ASSET_DEPART.getCode();
        this.code += SnowFlake.nextId();
    }
}

package com.wjhwjh.asset.entity;

import com.wjhwjh.asset.common.persistence.DataEntity;
import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * @author wjhwjh
 * @description a
 * Created in 17:10 2019/8/28
 */
@Data
@MappedSuperclass
public class AssetEntity extends DataEntity<AssetEntity> {

    protected String code;

    protected Integer status;
}

package com.wjhwjh.asset.common.persistence;

/**
 * @author wjhwjh
 * @description 资产属性标识
 * Created in 9:11 2019/8/29
 */
public enum AssetCode {

    ASSET_BRAND("asset_brand"),

    ASSET_DEPART("asset_depart"),

    ASSET_CATEGORY("asset_category"),

    ASSET_PROVIDER("asset_provider"),

    ASSET_PROVIDER_TYPE("asset_provider_type"),

    ASSET_ACQUISITION("asset_acquisition"),

    ASSET_ACQUISITION_MODEL("asset_acquisitio_model"),

    ASSET_EQUIPMENT_USER("asset_equipment_use"),

    ASSET_PURCHASE("asset_purchase"),

    ASSET_BORROW("asset_borrow"),

    ASSET_SCRAP("asset_scrap"),

    ASSET_SCRAP_MODEL("asset_scrap_model"),

    ASSET_SERVCING("asset_servcing"),

    ASSET_STRORAGE("asset_strorage"),

    ASSET_TRANSFER("asset_transfer"),

    ASSET("asset");

    private String code;

    AssetCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static String getMessage(String name) {
        for (AssetCode item : AssetCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return name;
    }
}

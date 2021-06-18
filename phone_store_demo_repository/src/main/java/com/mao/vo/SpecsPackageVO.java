package com.mao.vo;

import lombok.Data;

import java.util.Map;

/**
 * Author: Administrator
 * Date: 2021/6/16 20:03
 * Description:
 */
@Data
public class SpecsPackageVO {
    private Map<String,String> goods;
    private SkuVO sku;
}

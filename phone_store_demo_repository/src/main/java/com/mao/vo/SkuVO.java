package com.mao.vo;

import lombok.Data;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/6/16 20:04
 * Description:
 */
@Data
public class SkuVO {
    private List<TreeVO> tree;
    private List<PhoneSpecsCasVO> list;
    private String price;
    private Integer stock_num;
    private Boolean none_sku = false;
    private Boolean hide_stock = false;
}

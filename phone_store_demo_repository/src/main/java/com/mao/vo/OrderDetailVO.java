package com.mao.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Author: Administrator
 * Date: 2021/6/16 21:44
 * Description:
 */
@Data
public class OrderDetailVO {
    private String orderId;
    private String buyerName;
    private String phoneName;
    private Integer payStatus;
    private Integer freight = 10;
    @JsonProperty("tel")
    private String buyerPhone;
    @JsonProperty("address")
    private String buyerAddress;
    @JsonProperty("num")
    private Integer phoneQuantity;
    @JsonProperty("specs")
    private String specsName;
    @JsonProperty("price")
    private String specsPrice;
    @JsonProperty("icon")
    private String phoneIcon;
    @JsonProperty("amount")
    private BigDecimal orderAmount;
}

package com.mao.dto;

import lombok.Data;

/**
 * Author: Administrator
 * Date: 2021/6/16 21:15
 * Description:
 */
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer specsId;
    private Integer phoneQuantity;
}

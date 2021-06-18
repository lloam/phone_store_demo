package com.mao.enums;

import lombok.Getter;

/**
 * Author: Administrator
 * Date: 2021/6/16 21:31
 * Description:
 */
@Getter
public enum PayStatusEnum {
    UNPAID(0,"未支付"),
    PAID(1,"已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

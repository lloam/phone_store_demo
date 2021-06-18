package com.mao.vo;

import lombok.Data;

/**
 * Author: Administrator
 * Date: 2021/6/18 18:04
 * Description:
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}

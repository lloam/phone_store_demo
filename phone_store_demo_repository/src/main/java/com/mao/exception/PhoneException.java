package com.mao.exception;

import com.mao.enums.ResultEnum;

/**
 * Author: Administrator
 * Date: 2021/6/16 20:38
 * Description:
 */
public class PhoneException extends RuntimeException {
    public PhoneException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }

    public PhoneException(String message) {
        super(message);
    }
}

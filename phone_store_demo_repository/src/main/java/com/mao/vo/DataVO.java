package com.mao.vo;

import lombok.Data;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/6/15 21:18
 * Description:
 */
@Data
public class DataVO {
    private List<PhoneCategoryVO> categories;
    private List<PhoneInfoVO> phones;
}

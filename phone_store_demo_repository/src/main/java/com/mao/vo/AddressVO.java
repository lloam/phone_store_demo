package com.mao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: Administrator
 * Date: 2021/6/16 20:49
 * Description: 这里我手动封装数据，字段直接和api文档对应，不用JsonProperty
 */
@Data
@AllArgsConstructor
public class AddressVO {
    private Integer id;
    private String areaCode;
    private String name;
    private String tel;
    private String address;
}

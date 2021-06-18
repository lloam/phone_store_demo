package com.mao.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Author: Administrator
 * Date: 2021/6/15 21:21
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneInfoVO {
    @JsonProperty("id")
    private Integer phoneId;
    @JsonProperty("title")
    private String phoneName;
    @JsonProperty("price")
    private String phonePrice;
    @JsonProperty("desc")
    private String phoneDescription;
    private List<Map<String,String>> tag;
    @JsonProperty("thumb")
    private String phoneIcon;
}

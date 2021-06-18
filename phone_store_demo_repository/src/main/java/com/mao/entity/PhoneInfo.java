package com.mao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: Administrator
 * Date: 2021/6/15 20:32
 * Description:
 */
@Data
@Entity
public class PhoneInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer phoneId;
    private String phoneName;
    private BigDecimal phonePrice;
    private String phoneDescription;
    private Integer phoneStock;
    private Integer categoryType;
    private String phoneIcon;
    private String phoneTag;
    private Date createTime;
    private Date updateTime;
}

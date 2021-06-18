package com.mao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: Administrator
 * Date: 2021/6/15 20:17
 * Description:
 */
@Data
@Entity
public class PhoneCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column
    private String categoryName;
    @Column
    private Integer categoryType;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
}

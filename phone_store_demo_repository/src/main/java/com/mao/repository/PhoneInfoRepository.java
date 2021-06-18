package com.mao.repository;

import com.mao.entity.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/6/15 20:36
 * Description:
 */
public interface PhoneInfoRepository extends JpaRepository<PhoneInfo,Integer> {
    public List<PhoneInfo> findAllByCategoryType(Integer categoryType);
}

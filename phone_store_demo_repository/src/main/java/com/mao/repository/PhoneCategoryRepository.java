package com.mao.repository;

import com.mao.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Administrator
 * Date: 2021/6/15 20:22
 * Description:
 */
public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory,Integer> {
    public PhoneCategory findByCategoryType(Integer categoryType);
}

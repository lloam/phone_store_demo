package com.mao.repository;

import com.mao.entity.PhoneSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/6/15 20:45
 * Description:
 */
public interface PhoneSpecsRepository extends JpaRepository<PhoneSpecs,Integer> {
    public List<PhoneSpecs> findAllByPhoneId(Integer phoneId);
}

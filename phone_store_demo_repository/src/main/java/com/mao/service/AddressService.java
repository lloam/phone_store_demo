package com.mao.service;

import com.mao.form.AddressForm;
import com.mao.vo.AddressVO;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/6/16 20:48
 * Description:
 */
public interface AddressService {
    public List<AddressVO> findAll();
    public void saveOrUpdate(AddressForm addressForm);
}

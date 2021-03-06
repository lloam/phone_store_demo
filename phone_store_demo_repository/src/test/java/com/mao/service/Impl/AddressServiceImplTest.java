package com.mao.service.Impl;

import com.mao.form.AddressForm;
import com.mao.service.AddressService;
import com.mao.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Administrator
 * Date: 2021/6/16 20:56
 * Description:
 */
@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;
    @Test
    void findAll() {
        List<AddressVO> list = addressService.findAll();
        int i = 0;
    }

    @Test
    void saveOrUpdate(){
        AddressForm addressForm = new AddressForm();
        addressForm.setId(36);
        addressForm.setName("张三");
        addressForm.setTel("12345678911");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("东城区");
        addressForm.setAreaCode("110101");
        addressForm.setAddressDetail("168号545室");
        addressService.saveOrUpdate(addressForm);
    }
}
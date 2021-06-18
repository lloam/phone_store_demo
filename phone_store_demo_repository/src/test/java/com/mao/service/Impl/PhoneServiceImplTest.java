package com.mao.service.Impl;

import com.mao.service.PhoneService;
import com.mao.vo.DataVO;
import com.mao.vo.PhoneInfoVO;
import com.mao.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Administrator
 * Date: 2021/6/15 21:47
 * Description:
 */
@SpringBootTest
class PhoneServiceImplTest {

    @Autowired
    private PhoneService phoneService;
    @Test
    void findDataVO(){
        DataVO dataVO = phoneService.findDataVO();
        int id = 1;
    }

    @Test
    void findPhoneInfoVOByCategoryType(){
        List<PhoneInfoVO> phoneInfoVOList = phoneService.findPhoneInfoVOByCategoryType(1);
        int i = 0;
    }

    @Test
    void findSku(){
        SpecsPackageVO specsPackageVO = phoneService.findSpecsByPhoneId(1);
        int i = 0;
    }

    @Test
    void subStock(){
        phoneService.subStock(1,2);
    }

}
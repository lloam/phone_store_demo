package com.mao.service;

import com.mao.vo.DataVO;
import com.mao.vo.PhoneInfoVO;
import com.mao.vo.SpecsPackageVO;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/6/15 21:17
 * Description:
 */
public interface PhoneService {

    public DataVO findDataVO();
    public List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType);
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId);
    public void subStock(Integer specsId,Integer quantity);
}

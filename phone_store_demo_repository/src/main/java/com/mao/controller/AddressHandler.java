package com.mao.controller;

import com.mao.exception.PhoneException;
import com.mao.form.AddressForm;
import com.mao.service.AddressService;
import com.mao.util.ResultVOUtil;
import com.mao.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Author: Administrator
 * Date: 2021/6/18 19:37
 * Description:
 */
@RestController
@RequestMapping("/address")
@Slf4j
public class AddressHandler {
    @Autowired
    private AddressService addressService;
    @GetMapping("/list")
    public ResultVO list(){
        return ResultVOUtil.success(addressService.findAll());
    }
    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult){
//        System.out.println(bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            log.error("【添加地址】参数错误，addressForm={}",addressForm);
            log.error("bindingResult的错误信息为"+bindingResult.getFieldError().getDefaultMessage());
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);
        return ResultVOUtil.success(null);
    }
    @PutMapping("/update")
    public ResultVO update(@Valid @RequestBody AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改地址】参数错误，addressForm={}",addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);
        return ResultVOUtil.success(null);
    }
}

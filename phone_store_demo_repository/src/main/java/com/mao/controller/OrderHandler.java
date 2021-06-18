package com.mao.controller;

import com.mao.dto.OrderDTO;
import com.mao.exception.PhoneException;
import com.mao.form.OrderForm;
import com.mao.service.OrderService;
import com.mao.util.ResultVOUtil;
import com.mao.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Administrator
 * Date: 2021/6/18 20:31
 * Description:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderHandler {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数错误，orderForm={}",orderForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        // 将前端提交的订单数据转换成我们的DTO对象
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setPhoneQuantity(orderForm.getQuantity());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        // 创建订单，这里已经减库存了，所以不要重复操作
        OrderDTO result = orderService.create(orderDTO);
        // 返回结果为 map
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderDTO.getOrderId());
        return ResultVOUtil.success(map);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVO findOrderDetail(@PathVariable("orderId") String orderId){
        return ResultVOUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }
    @PutMapping("/pay/{orderId}")
    public ResultVO pay(@PathVariable("orderId") String orderId){
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderService.pay(orderId));
        return ResultVOUtil.success(map);
    }
}

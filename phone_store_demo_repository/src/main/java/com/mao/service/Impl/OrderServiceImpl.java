package com.mao.service.Impl;

import com.mao.dto.OrderDTO;
import com.mao.entity.OrderMaster;
import com.mao.entity.PhoneInfo;
import com.mao.entity.PhoneSpecs;
import com.mao.enums.PayStatusEnum;
import com.mao.enums.ResultEnum;
import com.mao.exception.PhoneException;
import com.mao.repository.OrderMasterRepository;
import com.mao.repository.PhoneInfoRepository;
import com.mao.repository.PhoneSpecsRepository;
import com.mao.service.OrderService;
import com.mao.service.PhoneService;
import com.mao.util.KeyUtil;
import com.mao.vo.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Author: Administrator
 * Date: 2021/6/16 21:17
 * Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private PhoneService phoneService;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        // 前端传过来的数据
        BeanUtils.copyProperties(orderDTO,orderMaster);
        // 存储手机规格相关的数据
        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(orderDTO.getSpecsId()).get();
        if(orderMaster == null){
            log.error("【创建订单】规格不存在，phoneSpecs={}",phoneSpecs);
            throw new PhoneException(ResultEnum.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneSpecs,orderMaster);
        // 存储手机信息相关的数据
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        if(orderMaster == null){
            log.error("【创建订单】手机不存在，phoneInfo={}",phoneInfo);
            throw new PhoneException(ResultEnum.PHONE_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneInfo,orderMaster);

        // 计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount);
        orderMaster.setOrderAmount(orderAmount);
        // orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        // 设置需要返回的 orderDTO 的orderId
        orderDTO.setOrderId(orderMaster.getOrderId());

        // payStatus
        orderMaster.setPayStatus(PayStatusEnum.UNPAID.getCode());
        orderMasterRepository.save(orderMaster);

        // 改库存
        phoneService.subStock(orderDTO.getSpecsId(),orderDTO.getPhoneQuantity());
        return orderDTO;
    }

    @Override
    public OrderDetailVO findOrderDetailByOrderId(String orderId) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if(orderMaster == null){
            log.error("【查询订单】订单不存在，orderMaster={}" ,orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }
        BeanUtils.copyProperties(orderMaster,orderDetailVO);
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100))+"");
        orderDetailVO.setOrderAmount(orderMaster.getOrderAmount().add(new BigDecimal(10)));
        return orderDetailVO;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if(orderMaster == null){
            log.error("【支付订单】订单不存在，orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(orderMaster.getPayStatus().equals(PayStatusEnum.UNPAID.getCode())){
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            orderMasterRepository.save(orderMaster);
        }else {
            log.error("【支付订单】订单已支付，orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_IS_PAID);
        }
        return orderId;
    }
}

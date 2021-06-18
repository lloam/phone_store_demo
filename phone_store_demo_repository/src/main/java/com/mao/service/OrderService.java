package com.mao.service;

import com.mao.dto.OrderDTO;
import com.mao.vo.OrderDetailVO;

/**
 * Author: Administrator
 * Date: 2021/6/16 21:12
 * Description:
 */
public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
    public OrderDetailVO findOrderDetailByOrderId(String orderId);
    public String pay(String orderId);
}

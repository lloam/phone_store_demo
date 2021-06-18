package com.mao.service.Impl;

import com.mao.dto.OrderDTO;
import com.mao.service.OrderService;
import com.mao.vo.OrderDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Administrator
 * Date: 2021/6/16 21:35
 * Description:
 */
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;
    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13678787878");
        orderDTO.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        orderDTO.setSpecsId(1);
        orderDTO.setPhoneQuantity(1);
        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);
    }

    @Test
    void findDetail(){
        OrderDetailVO orderDetailVO = orderService.findOrderDetailByOrderId("123456");
        int id = 0;
    }

    @Test
    void pay(){
        System.out.println(orderService.pay("1623850955304389239"));
    }
}
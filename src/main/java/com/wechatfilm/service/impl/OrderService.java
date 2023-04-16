package com.wechatfilm.service.impl;


import com.wechatfilm.service.IOrderService;
import com.wechatfilm.entity.Order;
import com.wechatfilm.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Order getOrderList(Integer userid) {
        return orderMapper.getOrderList(userid);
    }

    // 下单
    @Override
    public void placeOrder(Order order) {
        orderMapper.placeOrder(order);
    }
}

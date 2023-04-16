package com.wechatfilm.service;



import com.wechatfilm.entity.Order;

import java.util.List;

public interface IOrderService {

    // userid查询列表
    Order getOrderList(Integer userid);

    // 下单
    void placeOrder(Order order);


}

package com.wechatfilm.mapper;

import com.wechatfilm.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    // 按用户查询列表
    Order getOrderList(Integer userid);

    // 下单
    void placeOrder(Order order);



}



















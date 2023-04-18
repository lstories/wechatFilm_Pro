package com.wechatfilm.mapper;


import com.wechatfilm.controller.request.OrdersRequest;
import com.wechatfilm.entity.Vo.OrdersVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface OrdersMapper {

    // 查询所有列表
    List<OrdersVo> listOrders();

    // 分页
    List<OrdersVo> listByCondition(OrdersRequest ordersRequest);

    // 新增订单
    void addOrders(OrdersVo ordersVo);

    // 通过Id查询
    OrdersVo getByOrdersId(Integer id);

    // 更新
    void updateOrdersById(OrdersVo ordersVo);

    // 通过id删除
    void deleteOrdersById(Integer id);

    // 通过年份查找


}



















package com.wechatfilm.service;

import com.wechatfilm.controller.request.OrdersRequest;
import com.wechatfilm.entity.Vo.OrdersVo;

import java.util.List;

public interface IOrdersService {
    // 查询所有的订单信息
    List<OrdersVo> listOrders();

    // 分页
    Object ordersPage(OrdersRequest ordersRequest);

    // 添加新电影
    void addOrders(OrdersVo ordersVo);

    // 通过Id查询到详细信息
    OrdersVo getByOrdersId(Integer id);

    // 修改信息后更新
    void updateOrders(OrdersVo ordersVo);

    void deleteOrdersById(Integer id);

    // 查询前10个人
    List<OrdersVo> getTenHeightList();

    // 查询有评论的列表
    Object getComment(OrdersRequest ordersRequest);

    // 查询营业额
    List<OrdersVo> getTurnover();

    // 月营业额
    List<OrdersVo> getMonTur();
}

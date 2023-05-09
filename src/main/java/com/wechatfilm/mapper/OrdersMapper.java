package com.wechatfilm.mapper;


import com.wechatfilm.controller.request.OrdersRequest;
import com.wechatfilm.entity.Film;
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

    // 查询排行帮，消费次数前十的和金额
    List<OrdersVo> getTenHeightList();

    // 查询有评论的列表
    List<OrdersVo> getComment(OrdersRequest ordersRequest);


    // 周查询营业额
    List<OrdersVo> getTurnover();

    // 月营业额
    List<OrdersVo> getMonTur();

}



















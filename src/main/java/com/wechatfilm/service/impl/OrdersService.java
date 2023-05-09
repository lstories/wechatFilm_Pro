package com.wechatfilm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatfilm.controller.request.OrdersRequest;
import com.wechatfilm.entity.Film;
import com.wechatfilm.entity.Vo.OrdersVo;
import com.wechatfilm.mapper.OrdersMapper;
import com.wechatfilm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    // 列表
    @Override
    public List<OrdersVo> listOrders() {
        return ordersMapper.listOrders();
    }

    // 分页
    @Override
    public Object ordersPage(OrdersRequest ordersRequest) {
        PageHelper.startPage(ordersRequest.getPageNum(), ordersRequest.getPageSize());
        List<OrdersVo> ordersVos = ordersMapper.listByCondition(ordersRequest);// 按条件查找
        return new PageInfo<>(ordersVos);
    }

    // 新增
    @Override
    public void addOrders(OrdersVo ordersVo) {
        ordersMapper.addOrders(ordersVo);
    }

    // 查询当前id的信息
    @Override
    public OrdersVo getByOrdersId(Integer id) {
        return ordersMapper.getByOrdersId(id);
    }

    // 修改信息后更新
    @Override
    public void updateOrders(OrdersVo ordersVo) {
//        ordersVo.setCategory();
        ordersMapper.updateOrdersById(ordersVo);
    }

    // 删除
    @Override
    public void deleteOrdersById(Integer id) {
        ordersMapper.deleteOrdersById(id);
    }

    // 查询排行帮，消费次数前十的和金额
    @Override
    public List<OrdersVo> getTenHeightList() {
        return ordersMapper.getTenHeightList();
    }

    // 查询有评论的列表
    public Object getComment(OrdersRequest ordersRequest) {
        PageHelper.startPage(ordersRequest.getPageNum(), ordersRequest.getPageSize());
        List<OrdersVo> ordersVos = ordersMapper.getComment(ordersRequest);// 按条件查找
        return new PageInfo<>(ordersVos);
    }

    // 查询营业额
    @Override
    public List<OrdersVo> getTurnover() {
        return ordersMapper.getTurnover();
    }

    // 月营业额
    @Override
    public List<OrdersVo> getMonTur() {
        return ordersMapper.getMonTur();
    }


}

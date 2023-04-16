package com.wechatfilm.controller;


import com.wechatfilm.common.Result;
import com.wechatfilm.controller.request.OrderRequest;
import com.wechatfilm.entity.Order;
import com.wechatfilm.mapper.OrderMapper;
import com.wechatfilm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {

    @Autowired
    IOrderService orderService;

    // userId查询列表
    @GetMapping("/list/{userId}")
    public Result getOrderList(@PathVariable("userId") Integer userId) {
        Order order = orderService.getOrderList(userId);
        return Result.success(order);
    }

    @PostMapping("placeOrder")
    public Result placeOrder(@RequestBody Order order) {
        orderService.placeOrder(order);
        return Result.success();
    }




}

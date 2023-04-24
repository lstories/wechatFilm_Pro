package com.wechatfilm.controller;


import com.wechatfilm.common.Result;
import com.wechatfilm.controller.request.OrdersRequest;
import com.wechatfilm.entity.Vo.OrdersVo;
import com.wechatfilm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")

public class OrdersController {
    // 5. controller层实现将数据传递给前端浏览器
    // 对外暴露api

    @Autowired  // 注入
    IOrdersService ordersService;

    // 电影列表
    @GetMapping("/list")
    public Result listFilms() {
        List<OrdersVo> ordersVos = ordersService.listOrders();
        return Result.success(ordersVos);
    }

    // 分页功能
    @GetMapping("/page")
    public Result Page(OrdersRequest ordersRequest) {
        return Result.success(ordersService.ordersPage(ordersRequest));
    }

    // 新增
    @PostMapping("/add")
    public Result addOrders(@RequestBody OrdersVo ordersVo) {
        ordersService.addOrders(ordersVo);
        return Result.success();
    }

    // 通过查 Id 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getByOrdersId(@PathVariable Integer id) {
        OrdersVo ordersVo = ordersService.getByOrdersId(id);
        return Result.success(ordersVo);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody OrdersVo ordersVo){
        ordersService.updateOrders(ordersVo);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        ordersService.deleteOrdersById(id);
        return Result.success();
    }

    // 前十排行榜
    @GetMapping("/tenHeight")
    public Result getTenHeightList() {
         return Result.success(ordersService.getTenHeightList());
    }




}

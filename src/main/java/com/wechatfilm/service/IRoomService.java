package com.wechatfilm.service;

import com.github.pagehelper.PageInfo;
import com.wechatfilm.controller.request.BaseRequest;
import com.wechatfilm.entity.Room;

import java.util.List;

public interface IRoomService {

    // 查询所有的房间信息
    List<Room> list();

    // 分页
    PageInfo<Room> Page(BaseRequest baseRequest);

    // 添加
    void add(Room room);

    // 通过Id查询到详细信息
    Room getById(Integer id);

    // 修改信息后更新
    void updateById(Room room);

    // 删除
    void deleteById(Integer id);

    // 查询每个类型房间的消费金额
    List<Room> price();

}

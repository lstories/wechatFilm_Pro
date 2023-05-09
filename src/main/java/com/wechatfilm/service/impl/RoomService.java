package com.wechatfilm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatfilm.service.IRoomService;
import com.wechatfilm.controller.request.BaseRequest;
import com.wechatfilm.entity.Room;
import com.wechatfilm.mapper.RoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@Slf4j
public class RoomService implements IRoomService {

    @Resource
    RoomMapper roomMapper;

    // 列表
    @Override
    public List<Room> list() {
        return roomMapper.list();
    }

    // 分页
    @Override
    public PageInfo<Room> Page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Room> rooms = roomMapper.listByCondition(baseRequest);// 按条件查找
        return new PageInfo<>(rooms);
    }

    // 添加房间
    @Override
    public void add(Room room) {
        roomMapper.add(room);
    }

    // 通过id查询房间
    @Override
    public Room getById(Integer id) {
        return roomMapper.getById(id);
    }

    // 通过id更新房间信息
    @Override
    public void updateById(Room room) {
        roomMapper.updateById(room);
    }

    // 通过id删除房间信息
    @Override
    public void deleteById(Integer id) {
        roomMapper.deleteById(id);
    }

    // 查询每个类型房间的消费金额
    @Override
    public List<Room> price() {
        return roomMapper.price();
    }


}

package com.wechatfilm.controller;


import com.wechatfilm.common.Result;
import com.wechatfilm.controller.request.RoomPageRequest;
import com.wechatfilm.entity.Room;
import com.wechatfilm.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired  // 注入
    IRoomService roomService;

    // 房间列表
    @GetMapping("/list")
    public Result list() {
        List<Room> rooms = roomService.list();
        return Result.success(rooms);
    }

    // 分页功能
    @GetMapping("/page")
    public Result Page(RoomPageRequest pageRequest) {
        return Result.success(roomService.Page(pageRequest));
    }

    // 新增房间
    @PostMapping("/add")
    public Result add(@RequestBody Room room) {
        roomService.add(room);
        return Result.success();
    }

    // 通过查adminId 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Room room = roomService.getById(id);
        return Result.success(room);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Room room){
        roomService.updateById(room);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        roomService.deleteById(id);
        return Result.success();
    }

    // 查询每个类型房间的消费金额
    @GetMapping("/price")
    public Result price() {
        List<Room> rooms = roomService.price();
        return Result.success(rooms);
    }

}

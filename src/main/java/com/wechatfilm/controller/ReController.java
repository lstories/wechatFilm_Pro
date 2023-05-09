package com.wechatfilm.controller;


import com.wechatfilm.common.Result;
import com.wechatfilm.controller.request.ReRequest;
import com.wechatfilm.controller.request.RoomPageRequest;
import com.wechatfilm.entity.Reservation;
import com.wechatfilm.entity.Room;
import com.wechatfilm.entity.Vo.ReVo;
import com.wechatfilm.service.IReService;
import com.wechatfilm.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reOrder")
public class ReController {

    @Autowired  // 注入
    IReService reService;

    @GetMapping("/list")
    public Result reList(ReVo reVo) {
        return Result.success(reService.list());
    }

    // 分页功能
    @GetMapping("/page")
    public Result Page(ReRequest request) {
        return Result.success(reService.listByCondition(request));
    }

    // 新增
    @PostMapping("/add")
    public Result add(@RequestBody ReVo reVo) {
        reService.add(reVo);
        return Result.success();
    }

    // 通过id查
    @GetMapping("/{reId}")
    public Result getById(@PathVariable Integer reId) {
        ReVo reVo = reService.getById(reId);
        return Result.success(reVo);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody ReVo reVo){
        reService.update(reVo);
        return Result.success();
    }

}

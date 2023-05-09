package com.wechatfilm.service;

import com.github.pagehelper.PageInfo;
import com.wechatfilm.controller.request.BaseRequest;
import com.wechatfilm.entity.Reservation;
import com.wechatfilm.entity.Room;

import java.util.List;

public interface IReservationService {


    // 查询所有列表
    List<Reservation> reList(Reservation reservation);

    // 新增
    void addRe(Reservation obj);

    // 通过id删除
    void deleteById(Integer reId);

}

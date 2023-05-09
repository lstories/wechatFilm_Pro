package com.wechatfilm.mapper;


import com.wechatfilm.controller.request.BaseRequest;
import com.wechatfilm.entity.Reservation;
import com.wechatfilm.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReservationMapper {

    // 查询所有列表
    List<Reservation> reList(Reservation reservation);

    // 新增
    void addRe(Reservation obj);

    // 通过id删除
    void deleteById(Integer id);


}



















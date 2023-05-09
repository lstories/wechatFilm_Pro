package com.wechatfilm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatfilm.controller.request.BaseRequest;
import com.wechatfilm.entity.Reservation;
import com.wechatfilm.entity.Room;
import com.wechatfilm.mapper.ReservationMapper;
import com.wechatfilm.mapper.RoomMapper;
import com.wechatfilm.service.IReservationService;
import com.wechatfilm.service.IRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@Slf4j
public class ReservationService implements IReservationService {

    @Resource
    ReservationMapper reservationMapper;


    @Override
    public List<Reservation> reList(Reservation reservation) {
        return reservationMapper.reList(reservation);
    }

    @Override
    public void addRe(Reservation obj) {
        reservationMapper.addRe(obj);
    }

    @Override
    public void deleteById(Integer reId) {
        reservationMapper.deleteById(reId);
    }
}

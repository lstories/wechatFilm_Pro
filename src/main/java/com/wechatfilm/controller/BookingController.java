package com.wechatfilm.controller;

import com.wechatfilm.service.impl.RoomRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private RoomRedisService roomService;

    @PostMapping("/book")
    public String bookRoom(@RequestParam String roomId,
                           @RequestParam long begintime,
                           @RequestParam long endTime) {
        if (roomService.bookRoom(roomId, begintime, endTime)) {
            return "Room booked successfully!";
        } else {
            return "Failed to book the room, please try again later.";
        }
    }

    @PostMapping("/release")
    public String releaseRoom(@RequestParam String roomId) {
        roomService.releaseRoom(roomId);
        return "Room released successfully!";
    }
}

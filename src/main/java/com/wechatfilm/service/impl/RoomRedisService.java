package com.wechatfilm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RoomRedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String ROOM_PREFIX = "room:";

    /**
     * 预订房间
     *
     * @param roomId 房间号
     * @param begintime 开始时间
     * @param endTime 结束时间
     * @return true-预订成功 false-预订失败
     */
    public boolean bookRoom(String roomId, long begintime, long endTime) {
        String lockKey = ROOM_PREFIX + roomId;
        try {
            if (redisTemplate.opsForValue().setIfAbsent(lockKey, "locked")) {
                redisTemplate.expire(lockKey, endTime - begintime, TimeUnit.MILLISECONDS);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 释放房间
     *
     * @param roomId 房间号
     */
    public void releaseRoom(String roomId) {
        String lockKey = ROOM_PREFIX + roomId;
        redisTemplate.delete(lockKey);
    }
}

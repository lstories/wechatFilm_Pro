package com.wechatfilm.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimestampConversionDate {
    public String timestampDate(String param) {
        Instant timestamp = Instant.ofEpochMilli(new Long(param));
        System.out.println("timestamp:"+param);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return format;
    }
}

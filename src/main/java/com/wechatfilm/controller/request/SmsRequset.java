package com.wechatfilm.controller.request;

import lombok.Data;

@Data
public class SmsRequset {
    private String phone;
    private String code;
}

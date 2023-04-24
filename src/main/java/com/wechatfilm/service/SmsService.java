package com.wechatfilm.service;

public interface SmsService {

    boolean sendSms(String phone,String code);

    boolean getCode(String phone, String code);
}

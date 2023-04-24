package com.wechatfilm.controller.request;

import lombok.Data;

@Data
public class UserPageRequest extends BaseRequest {
    private String username;    // 用户名
    private String name;    // 昵称
    private String phone;   // 手机号
}

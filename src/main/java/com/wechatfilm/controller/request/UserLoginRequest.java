package com.wechatfilm.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest extends BaseRequest {

    private String username;   // 账号
    private String password;    // 密码

}

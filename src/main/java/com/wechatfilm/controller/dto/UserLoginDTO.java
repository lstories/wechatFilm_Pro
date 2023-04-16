package com.wechatfilm.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {

    private Integer userId;     // id
    private String name;        // 昵称
    private String username;    // 用户名
    private String password;    // 密码
    private String phone;     // 手机号
    private String headpic;     // 头像
    private String token;       // token

}

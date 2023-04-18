package com.wechatfilm.controller.request;


import lombok.Data;

import java.util.Date;

@Data
public class UserPageRequest extends BaseRequest {


    private String username;    // 用户名

}

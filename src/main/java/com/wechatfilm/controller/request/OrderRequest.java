package com.wechatfilm.controller.request;


import lombok.Data;

@Data
public class OrderRequest extends BaseRequest {


    private String name;     // 昵称
    private String filmName;     // 电影名
    private String userid;      // 用户id

}

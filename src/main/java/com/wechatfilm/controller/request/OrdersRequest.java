package com.wechatfilm.controller.request;


import lombok.Data;

@Data
public class OrdersRequest extends BaseRequest {


    private String name;     // 昵称
    private String filmName;     // 电影名
    private Integer userid;      // 用户id
    private String status;     // 状态
}

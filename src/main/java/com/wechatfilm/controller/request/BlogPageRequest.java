package com.wechatfilm.controller.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BlogPageRequest extends BaseRequest {

    private Integer answerId;   // 回帖id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date answerTime;    // 回帖时间
    private Integer bid;        // 论坛id
    private Integer uid;        // 回帖用户id
    private String answerContent;   // 回帖内容
    private String name;        // 用户昵称
    private String titleText;   // 帖子标题
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date sendTime;      // 发帖时间
    private String contentText; // 帖子内容
    private Integer uuid;       // 发帖用户id

}

package com.wechatfilm.entity.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogVo {
    private Integer answerId;   // 回帖id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date answerTime;    // 回帖时间
    private Integer blogId;     // 帖子id
    private Integer bid;        // 论坛id
    private Integer uid;        // 回帖用户id
    private String answerContent;   // 回帖内容
    private String titleText;   // 帖子标题
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date sendTime;      // 发帖时间
    private String contentText; // 帖子内容
    private Integer uuid;       // 发帖用户id

    private String blogName;        // 用户昵称
    private String blogPic;         // 用户头像
    private String answerName;        // 回帖用户昵称
    private String answerPic;       // 回帖用户头像

}

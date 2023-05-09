package com.wechatfilm.entity.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReVo {

    private Integer reId;   // id
    private Integer roomId; // 房间id
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date beginTime;    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endTime;    // 结束时间
    private Integer personNum;  // 参加人数
    private Integer filmId;     // 电影id
    private String reStatus;    // 订单状态

    private String filmName;    // 电影名称
    private String pic;     // 电影封面
    private String styleBrand;  // 影房主题
    private String spaceBrand;  // 空间大小
}

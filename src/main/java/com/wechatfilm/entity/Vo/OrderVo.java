package com.wechatfilm.entity.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {

    private Integer id;     // id
    private String code;    // 订单代码
    private Integer userid;     // 用户名
    private Integer filmid;     // 电影名
    private Integer roomid;     // 房间id
    private BigDecimal price;    // 价格
    private String brand;        // 类型(平团/预约)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") //接收时间类型
    private Date createtime;    // 备注
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") //接收时间类型
    private Date begintime;    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") //接收时间类型
    private Date endtime;    // 创建时间
    private String captcha;     // 验证码
    private Integer status;     // 订单状态
    private String comment;     // 评价

    private String name;    // 昵称
    private String filmName;    // 电影名称

    private String styleBrand;  // 影房主题
    private String spaceBrand;  // 空间大小

}

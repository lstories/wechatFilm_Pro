package com.wechatfilm.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Integer logonMonth;    // 注册月份
    private Integer logonCount;     // 注册数量
}

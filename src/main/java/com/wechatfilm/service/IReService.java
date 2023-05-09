package com.wechatfilm.service;


import com.wechatfilm.controller.request.ReRequest;
import com.wechatfilm.entity.Vo.ReVo;

import java.util.List;

public interface IReService {
    List<ReVo> list();

    // 分页
    Object listByCondition(ReRequest request);

    // 新增订单
    void add(ReVo reVo);

    // 通过Id查询
    ReVo getById(Integer reId);

    // 更新
    void update(ReVo reVo);

    // 通过id删除
    void deleteById(Integer reId);


}

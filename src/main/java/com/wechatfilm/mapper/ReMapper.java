package com.wechatfilm.mapper;


import com.wechatfilm.controller.request.OrdersRequest;
import com.wechatfilm.controller.request.ReRequest;
import com.wechatfilm.entity.Vo.OrdersVo;
import com.wechatfilm.entity.Vo.ReVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface ReMapper {

    // 查询所有列表
    List<ReVo> list();

    // 分页
    List<ReVo> listByCondition(ReRequest request);

    // 新增订单
    void add(ReVo reVo);

    // 通过Id查询
    ReVo getById(Integer reId);

    // 更新
    void updateById(ReVo reVo);

    // 通过id删除
    void deleteById(Integer reId);


}



















package com.wechatfilm.mapper;


import com.wechatfilm.controller.request.BlogPageRequest;
import com.wechatfilm.controller.request.OrdersRequest;
import com.wechatfilm.entity.Vo.BlogVo;
import com.wechatfilm.entity.Vo.OrdersVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface BlogVoMapper {

    // 查询所有列表
    List<BlogVo> listBlogVo();

    // 分页
    List<BlogVo> listByCondition(BlogPageRequest blogPageRequest);

    // 新增
    void addAnswer(BlogVo blogVo);

    // 通过Id查询
    BlogVo getByBlogId(Integer id);

    // 更新
    void updateBlogVo(BlogVo blogVo);

    // 通过id删除
    void deleteBlogVoById(Integer id);



}



















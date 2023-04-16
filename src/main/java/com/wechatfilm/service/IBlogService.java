package com.wechatfilm.service;

import com.github.pagehelper.PageInfo;
import com.wechatfilm.entity.Vo.BlogVo;
import com.wechatfilm.controller.request.BaseRequest;

import java.util.List;

public interface IBlogService {

    // 查询博客信息
    List<BlogVo> listBlog();

    // 分页
    PageInfo<BlogVo> BlogPage(BaseRequest baseRequest);

    // 添加新回帖
    void addAnswer(BlogVo blogVo);

    // 新增帖子
    void addBlog(BlogVo blogVo);

    // 通过bid删除帖子
    void deleteBlog(Integer bid);

    // 通过answerId删除回帖
    void deleteAnswer(Integer answerId);


}

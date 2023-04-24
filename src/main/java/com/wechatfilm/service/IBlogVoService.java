package com.wechatfilm.service;

import com.wechatfilm.controller.request.BlogPageRequest;
import com.wechatfilm.entity.Vo.BlogVo;

import java.util.List;

public interface IBlogVoService {
    // 查询所有的信息
    List<BlogVo> listBlogVo();

    // 分页
    Object blogPage(BlogPageRequest blogPageRequest);

    // 添加
    void addAnswer(BlogVo blogVo);

    // 通过Id查询到详细信息
    BlogVo getByBlogId(Integer id);

    // 修改信息后更新
    void updateBlogVo(BlogVo blogVo);

    void deleteBlogVoById(Integer id);

}

package com.wechatfilm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatfilm.service.IBlogService;
import com.wechatfilm.entity.Vo.BlogVo;
import com.wechatfilm.controller.request.BaseRequest;
import com.wechatfilm.mapper.BlogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BlogService implements IBlogService {

    @Autowired
    BlogMapper blogMapper;

    // 列表
    @Override
    public List<BlogVo> listBlog() {
        return blogMapper.listBlog();
    }

    // 分页
    @Override
    public PageInfo<BlogVo> BlogPage(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<BlogVo> blogVos = blogMapper.BlogPage(baseRequest);
        return new PageInfo<>(blogVos);
    }

    // 根据id查询
    @Override
    public BlogVo getBlogById(Integer blogId) {
        return blogMapper.getBlogById(blogId);
    }

    // 新增回帖
    @Override
    public void addAnswer(BlogVo blogVo) {
        blogMapper.addAnswer(blogVo);
    }

    // 新增帖子
    @Override
    public void addBlog(BlogVo blogVo) {
        blogMapper.addBlog(blogVo);
    }

    // 通过id删除帖子
    @Override
    public void deleteBlog(Integer bid) {
        blogMapper.deleteBlog(bid);
    }
    // 通过answerId删除回帖
    @Override
    public void deleteAnswer(Integer answerId) {
        blogMapper.deleteAnswer(answerId);
    }



}

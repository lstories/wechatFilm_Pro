package com.wechatfilm.controller;


import com.wechatfilm.common.Result;
import com.wechatfilm.controller.request.BlogPageRequest;
import com.wechatfilm.controller.request.OrdersRequest;
import com.wechatfilm.entity.Vo.BlogVo;
import com.wechatfilm.entity.Vo.OrdersVo;
import com.wechatfilm.service.IBlogService;
import com.wechatfilm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blogs")

public class BlogController {
    // 5. controller层实现将数据传递给前端浏览器
    // 对外暴露api

    @Autowired  // 注入
    IBlogService blogService;

    // 电影列表
    @GetMapping("/list")
    public Result listBlog() {
        List<BlogVo> blogVos = blogService.listBlog();
        return Result.success(blogVos);
    }

    // 分页功能
    @GetMapping("/page")
    public Result Page(BlogPageRequest blogPageRequest) {
        return Result.success(blogService.BlogPage(blogPageRequest));
    }

    // 新增帖子
    @PostMapping("/addBlog")
    public Result addBlog(@RequestBody BlogVo blogVo) {
        blogService.addBlog(blogVo);
        return Result.success();
    }

    // 新增回帖
    @PostMapping("/addAnswer")
    public Result addAnswer(@RequestBody BlogVo blogVo) {
        blogService.addAnswer(blogVo);
        return Result.success();
    }

    @GetMapping("/getId/{blogId}")
    public Result getBlogById(@PathVariable Integer blogId) {
        BlogVo blogVo = blogService.getBlogById(blogId);
        return Result.success(blogVo);
    }

    // 根据id删除帖子
    @DeleteMapping("/deleteBlog/{bid}")
    public Result deleteBlog(@PathVariable Integer bid) {
        blogService.deleteBlog(bid);
        return Result.success();
    }

    // 根据id删除回帖
    @DeleteMapping("/deleteBlog/{answerId}")
    public Result deleteAnswer(@PathVariable Integer answerId) {
        blogService.deleteAnswer(answerId);
        return Result.success();
    }




}

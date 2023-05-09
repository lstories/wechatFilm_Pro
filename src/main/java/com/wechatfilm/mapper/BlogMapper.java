package com.wechatfilm.mapper;


import com.wechatfilm.entity.Vo.BlogVo;
import com.wechatfilm.controller.request.BaseRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {

    // 列表
    List<BlogVo> listBlog();

    // 分页
    List<BlogVo> BlogPage(BaseRequest baseRequest);

    // 根据id查询
    BlogVo getBlogById(Integer blogId);

    // 添加新回帖
    void addAnswer(BlogVo blogVo);

    // 新增帖子
    void addBlog(BlogVo blogVo);

    // 通过id删除帖子
    void deleteBlog(Integer bid);

    // 通过id删除回答
    void deleteAnswer(Integer answerId);

    // 修改帖子
    void updateBlog(BlogVo blogVo);

}

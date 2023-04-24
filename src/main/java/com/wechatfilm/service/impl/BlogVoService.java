package com.wechatfilm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatfilm.controller.request.BlogPageRequest;
import com.wechatfilm.entity.Vo.BlogVo;
import com.wechatfilm.mapper.BlogVoMapper;
import com.wechatfilm.service.IBlogVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogVoService implements IBlogVoService {

    @Autowired
    BlogVoMapper blogVoMapper;

    // 列表
    @Override
    public List<BlogVo> listBlogVo() {
        return blogVoMapper.listBlogVo();
    }

    // 分页
    @Override
    public Object blogPage(BlogPageRequest blogPageRequest) {
        PageHelper.startPage(blogPageRequest.getPageNum(), blogPageRequest.getPageSize());
        List<BlogVo> blogVos = blogVoMapper.listByCondition(blogPageRequest);// 按条件查找
        return new PageInfo<>(blogVos);
    }

    // 新增
    @Override
    public void addAnswer(BlogVo blogVo) {
//        ordersVo.setCategory(category(film.getCategories()));
        blogVoMapper.addAnswer(blogVo);
    }

    // 根据id查找
    @Override
    public BlogVo getByBlogId(Integer id) {
        return blogVoMapper.getByBlogId(id);
    }


    // 修改信息后更新
    @Override
    public void updateBlogVo(BlogVo blogVo) {
//        ordersVo.setCategory();
        blogVoMapper.updateBlogVo(blogVo);
    }

    // 删除
    @Override
    public void deleteBlogVoById(Integer id) {
        blogVoMapper.deleteBlogVoById(id);
    }


}

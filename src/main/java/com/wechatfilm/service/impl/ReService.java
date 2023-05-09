package com.wechatfilm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatfilm.controller.request.ReRequest;
import com.wechatfilm.entity.Vo.OrdersVo;
import com.wechatfilm.entity.Vo.ReVo;
import com.wechatfilm.mapper.ReMapper;
import com.wechatfilm.service.IReService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReService implements IReService {

    @Autowired
    ReMapper reMapper;

    // 列表
    @Override
    public List<ReVo> list() {
        return reMapper.list();
    }

    // 分页
    @Override
    public Object listByCondition(ReRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<ReVo> reVoList = reMapper.listByCondition(request);// 按条件查找
        return new PageInfo<>(reVoList);
    }

    // 新增
    @Override
    public void add(ReVo reVo) {
        reMapper.add(reVo);
    }

    // 查询当前id的信息
    @Override
    public ReVo getById(Integer reId) {
        return reMapper.getById(reId);
    }

    // 修改信息后更新
    @Override
    public void update(ReVo reVo) {
        reMapper.updateById(reVo);
    }

    // 删除
    @Override
    public void deleteById(Integer reId) {
        reMapper.deleteById(reId);
    }



}

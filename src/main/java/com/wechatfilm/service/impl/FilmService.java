package com.wechatfilm.service.impl;


import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatfilm.entity.Category;
import com.wechatfilm.entity.Vo.FilmVo;
import com.wechatfilm.service.IFilmService;
import com.wechatfilm.controller.request.FilmPageRequest;
import com.wechatfilm.entity.Film;
import com.wechatfilm.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // 注释,标注为spring的组件,才能被调用
public class FilmService implements IFilmService {

    @Autowired
    FilmMapper filmMapper;

    // 列表
    @Override
    public List<Film> listFilms() {
        return filmMapper.listFilms();
    }

    // 分页
    @Override
    public Object filmsPage(FilmPageRequest filmPageRequest) {
        PageHelper.startPage(filmPageRequest.getPageNum(), filmPageRequest.getPageSize());
        List<Film> films = filmMapper.listByCondition(filmPageRequest);// 按条件查找
        return new PageInfo<>(films);
    }

    // 新增
    @Override
    public void addFilm(Film film) {
        filmMapper.addFilm(film);
    }

    @Override
    public void updateById(Film film) {
        filmMapper.updateById(film);
    }


    // 查询当前id的信息
    @Override
    public Film getByFilmId(Integer id) {
        return filmMapper.getByFilmId(id);
    }



    // 删除
    @Override
    public void deleteFilmById(Integer id) {
        filmMapper.deleteFilmById(id);
    }

    // 查询评分最高的前10个
    @Override
    public List<Film> heightTen() {
        return filmMapper.heightTen();
    }

    // 按照分类查询
    @Override
    public Object filmsCategory(FilmPageRequest filmPageRequest) {
        PageHelper.startPage(filmPageRequest.getPageNum(), filmPageRequest.getPageSize());
        List<Film> films = filmMapper.filmsCategory(filmPageRequest);// 按条件查找
        return new PageInfo<>(films);
    }

    // 按照分类查询
    @Override
    public Object byCategory(FilmPageRequest filmPageRequest) {
        PageHelper.startPage(filmPageRequest.getPageNum(), filmPageRequest.getPageSize());
        List<Film> films = filmMapper.filmsCategory(filmPageRequest);// 按条件查找
        return new PageInfo<>(films);
    }

    // 查询每年电影比例
    @Override
    public List<Film> yearFilm() {
        return filmMapper.yearFilm();
    }

    // 查询今年每月新上映的电影数量
    @Override
    public List<FilmVo> monthFilm() {
        return filmMapper.monthFilm();
    }

}

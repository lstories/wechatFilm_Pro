package com.wechatfilm.mapper;


import com.wechatfilm.controller.request.FilmPageRequest;
import com.wechatfilm.entity.Film;
import com.wechatfilm.entity.Vo.FilmVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface FilmMapper {

    // 查询评分最高的前10个
    List<Film> heightTen();

    // 2. mapper接口,提供数据库调用的方法

    // 查询所有用户列表
    //  @Select("select * from usertable")
    List<Film> listFilms();

    // 分页
    List<Film> listByCondition(FilmPageRequest filmPageRequest);

    // 新增用户
    void addFilm(Film film);

    void updateById(Film film);

    // 通过Id查询
    Film getByFilmId(Integer id);

    // 通过Id删除
    void updateFilmById(Film film);

    void deleteFilmById(Integer id);

    List<Film> filmsCategory(FilmPageRequest filmPageRequest);

    List<Film> byCategory(FilmPageRequest filmPageRequest);


    // 查询各年的电影比例
    List<Film> yearFilm();

    // 查询今年每月新上映的电影数量
    List<FilmVo> monthFilm();

}



















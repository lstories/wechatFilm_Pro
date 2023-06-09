package com.wechatfilm.controller;

import com.wechatfilm.common.Result;
import com.wechatfilm.controller.request.FilmPageRequest;
import com.wechatfilm.entity.Film;
import com.wechatfilm.entity.Vo.FilmVo;
import com.wechatfilm.service.IFilmService;
import com.wechatfilm.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/film")

public class FilmController {
    // 5. controller层实现将数据传递给前端浏览器
    // 对外暴露api

    @Autowired  // 注入
    IFilmService filmService;

    // 电影列表
    @GetMapping("/list")
    public Result listFilms() {
        List<Film> films = filmService.listFilms();
        return Result.success(films);
    }

    // 分页功能
    @GetMapping("/page")
    public Result filmsPage(FilmPageRequest filmPageRequest) {
        return Result.success(filmService.filmsPage(filmPageRequest));
    }

    // 新增
    @PostMapping("/add")
    public Result addFilm(@RequestBody Film film) {
        filmService.addFilm(film);
        return Result.success();
    }

    // 通过查 Id 返回到页面对应的位置的数据
    @GetMapping("/{id}")
    public Result getByFilmId(@PathVariable Integer id) {
        Film film = filmService.getByFilmId(id);
        return Result.success(film);
    }

    // 更新修改后的用户信息
    @PutMapping("/update")
    public Result update(@RequestBody Film film){
        filmService.updateById(film);
        return Result.success();
    }

    // 根据id删除用户
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        filmService.deleteFilmById(id);
        return Result.success();
    }

    // 查询评分最高的前5个
    @GetMapping("height")
    public Result heightTen() {
        List<Film> films = filmService.heightTen();
        return Result.success(films);
    }

    // 上传图片
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        return Result.success(UploadUtil.uploadImage(file));
    }

    // 通过查 分类 返回到页面对应的位置的数据
    @GetMapping("/category")
    public Result getByFilmCategory(FilmPageRequest filmPageRequest) {
        return Result.success(filmService.filmsCategory(filmPageRequest));
    }


    // 通过查 分类 返回到页面对应的位置的数据
    @GetMapping("/byCategory")
    public Result byCategory(FilmPageRequest filmPageRequest) {
        return Result.success(filmService.byCategory(filmPageRequest));
    }

    // 查询每年电影比例
    @GetMapping("/yearFilm")
    public Result yearFilm() {
        List<Film> films = filmService.yearFilm();
        return Result.success(films);
    }

    // 查询今年每月新上映的电影数量
    @GetMapping("/monthFilm")
    public Result monthFilm() {
        List<FilmVo> films = filmService.monthFilm();
        return Result.success(films);
    }


}

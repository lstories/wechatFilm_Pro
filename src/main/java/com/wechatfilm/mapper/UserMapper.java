package com.wechatfilm.mapper;


import com.wechatfilm.controller.request.UserPageRequest;
import com.wechatfilm.entity.User;
import com.wechatfilm.entity.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface UserMapper {

    // 2. mapper接口,提供数据库调用的方法

    // 查询所有用户列表
    //  @Select("select * from usertable")
    List<User> listUsers();

    // 分页
    List<User> listByCondition(UserPageRequest userPageRequest);

    // 新增用户
    void addUser(User user);

    // 注册
    void logonUser(User user);


    // 通过Id查询
    User getByUserId(Integer userId);

    // 通过Id删除
    void updateUserById(User user);

    void deleteUserById(Integer userId);


    // 通过查找username来判断登录
    User getByUserName(String username);

    // 18年注册数量
    List<User> getUserNum_18();

    // 19年注册数量
    List<User> getUserNum_19();

    // 20年注册数量
    List<User> getUserNum_20();

    // 21年注册数量
    List<User> getUserNum_21();

    // 22年注册数量
    List<User> getUserNum_22();

    // 23年注册数量
    List<User> getUserNum_23();

    // 注册 查询 用户名、手机号
    List<User> usernamePhone(UserPageRequest userPageRequest);

    // 忘记密码
    void resetPwd(User user);

    // 查询今年每个月注册的人数
    List<UserVo> getMonLogin();

}



















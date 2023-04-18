package com.wechatfilm.service;

import com.wechatfilm.controller.request.UserLoginRequest;
import com.wechatfilm.controller.dto.UserLoginDTO;
import com.wechatfilm.controller.request.UserPageRequest;
import com.wechatfilm.entity.User;

import java.util.List;

public interface IUserService {
    // 3. 业务处理层, 操作数据库, 先写个接口

    // 查询所有的用户信息
    List<User> listUsers();

    // 分页
    Object usersPage(UserPageRequest userPageRequest);

    // 添加新用户
    void addUser(User user);

    // 注册
    void logonUser(User user);

    // 通过Id查询到详细信息
    User getByUserId(Integer userId);

    // 修改信息后更新
    void updateUser(User user);

    void deleteUserById(Integer userId);

    // 登录
    UserLoginDTO login(UserLoginRequest userLoginRequest);

    // 18年用户数量
    List<User> getUserNum_18();

    // 19年用户数量
    List<User> getUserNum_19();

    // 20年用户数量
    List<User> getUserNum_20();

    // 21年用户数量
    List<User> getUserNum_21();

    // 22年用户数量
    List<User> getUserNum_22();

    // 23年用户数量
    List<User> getUserNum_23();

}

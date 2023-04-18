package com.wechatfilm.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatfilm.controller.request.UserLoginRequest;
import com.wechatfilm.service.IUserService;
import com.wechatfilm.Exception.ServiceException;
import com.wechatfilm.controller.dto.UserLoginDTO;
import com.wechatfilm.controller.request.UserPageRequest;
import com.wechatfilm.entity.User;
import com.wechatfilm.mapper.UserMapper;
import com.wechatfilm.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service    // 注释,标注为spring的组件,才能被调用
public class UserService implements IUserService {
    // 4. 实现类, 调用mapper接口

    @Autowired
    UserMapper userMapper;

    // 用户列表
    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    // 分页
    @Override
    public Object usersPage(UserPageRequest userPageRequest) {
        PageHelper.startPage(userPageRequest.getPageNum(), userPageRequest.getPageSize());
        List<User> users = userMapper.listByCondition(userPageRequest);// 按条件查找
        return new PageInfo<>(users);
    }

    // 新增用户
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    // 注册
    @Override
    public void logonUser(User user) {
        userMapper.logonUser(user);
    }

    // 查询当前id的用户信息
    @Override
    public User getByUserId(Integer userId) {
        return userMapper.getByUserId(userId);
    }

    // 修改信息后更新
    @Override
    public void updateUser(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userMapper.deleteUserById(userId);
    }


    // 登录
    @Override
    public UserLoginDTO login(UserLoginRequest userLoginRequest) {
        userMapper.getByUserName(userLoginRequest.getUsername());
        User user = null;
        try {
            user = userMapper.getByUserName(userLoginRequest.getUsername());
        } catch (Exception e) {
            log.error("根据用户名{} 查询错误", userLoginRequest.getUsername());
            throw new ServiceException("用户名错误");
        }
        // 判断密码是否合法
        String UserPassword = userLoginRequest.getPassword();
        if (!UserPassword.equals(user.getPassword())) {
            throw new ServiceException("用户名或密码错误");
        }
        UserLoginDTO loginDTO = new UserLoginDTO();
        BeanUtils.copyProperties(user, loginDTO);
        // 生成token
        String token = TokenUtils.getUserToken(String.valueOf(user.getUserId()), user.getPassword());
        loginDTO.setToken(token);
        return loginDTO;
    }

    // 18年
    @Override
    public List<User> getUserNum_18() {
        return userMapper.getUserNum_18();
    }

    // 19年
    @Override
    public List<User> getUserNum_19() {
        return userMapper.getUserNum_19();
    }

    // 20年
    @Override
    public List<User> getUserNum_20() {
        return userMapper.getUserNum_20();
    }

    // 21年
    @Override
    public List<User> getUserNum_21() {
        return userMapper.getUserNum_21();
    }

    // 22年
    @Override
    public List<User> getUserNum_22() {
        return userMapper.getUserNum_22();
    }

    // 23年
    @Override
    public List<User> getUserNum_23() {
        return userMapper.getUserNum_23();
    }

}

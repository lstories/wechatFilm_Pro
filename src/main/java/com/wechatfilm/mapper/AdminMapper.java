package com.wechatfilm.mapper;

import com.wechatfilm.controller.request.LoginRequest;
import com.wechatfilm.controller.request.BaseRequest;
import com.wechatfilm.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper     // 使用Mapper注解,将这个注册为spring的一个bean
public interface AdminMapper {

    // 2. mapper接口,提供数据库调用的方法

    // 查询所有用户列表
    List<Admin> listAdmins();

    // 分页
    List<Admin> listByCondition(BaseRequest baseRequest);

    // 新增用户
    void addAdmin(Admin admin);

    // 通过Id查询
    Admin getById(Integer adminId);

    // 通过Id更新
    void updateById(Admin admin);

    // 通过id删除
    void deleteById(Integer adminId);

    // 通过账号密码登录
    Admin getByAdminNameAndPassword(LoginRequest loginRequest);

    // 通过AdminName查询
    Admin getByAdminName(String adminName);
}



















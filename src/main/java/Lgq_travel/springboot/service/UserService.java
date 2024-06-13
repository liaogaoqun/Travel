package Lgq_travel.springboot.service;

import Lgq_travel.springboot.entity.User;

public interface UserService {
    //用户登录
    public User UserLogin(User user);
    User Select();
    //用户注册
    int Register(User user);
    //用户重命名检查
    int CheckUsername(String username);
    //更改用户信息
    int UpdateInfo(User user);
    //更改用户密码
    int UpdateUserPass(User user);
}

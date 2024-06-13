package Lgq_travel.springboot.service.Impl;

import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.mapper.UserMapper;
import Lgq_travel.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User UserLogin(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public User Select() {
        return userMapper.selectUser();
    }

    @Override
    public int Register(User user) {
        return userMapper.userRegister(user);
    }

    @Override
    public int CheckUsername(String username) {
        return userMapper.CheckUsername(username);
    }

    @Override
    public int UpdateInfo(User user) {
        return userMapper.UpdateInfo(user);
    }

    @Override
    public int UpdateUserPass(User user) {
        return userMapper.UpdateInfo(user);
    }
}

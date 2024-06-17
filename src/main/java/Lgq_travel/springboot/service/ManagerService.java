package Lgq_travel.springboot.service;



import Lgq_travel.springboot.entity.Manager;

import java.util.List;

public interface ManagerService {
    //插入管理员信息
    public int insertManager(Manager manager);
    //删除管理员信息
    public int deleteManager(Integer id);
    //通过名字返回管理员信息
    public List<Manager> getAllManager(String name);
    //登录验证
    public Manager confirmManager(Manager manager);
}


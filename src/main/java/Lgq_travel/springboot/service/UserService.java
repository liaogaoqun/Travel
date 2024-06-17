package Lgq_travel.springboot.service;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.utils.Page;

import java.util.List;

public interface UserService {
    //用户登录
    public User UserLogin(User user);
    List<User> Select();
    //用户注册
    int Register(User user);
    //用户重命名检查
    int CheckUsername(String username);
    //更改用户信息
    int UpdateInfo(User user);
    //更改用户密码
    int UpdateUserPass(User user);
    //用户状态调为禁用
    public void updateStateById(String id);
    //用户状态调为不禁用
    public void updateStateBy1Id(String id);
    //获取分页结果集
    public Page<User> selectPageByQueryVo(QueryVo vo);
    //展示学生详情信息
    public User showUserDetail(User user);

}

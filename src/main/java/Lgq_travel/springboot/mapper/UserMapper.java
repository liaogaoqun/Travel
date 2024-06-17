package Lgq_travel.springboot.mapper;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //用户登录
    public User getUser(User user);

    //获取全部用户信息
    public List<User> selectUser();

    //用户注册
    public int userRegister(User user);

    //检查用户重复命名数量
    int CheckUsername(String username);

    //更改用户信息
    int UpdateInfo(User user);

    //用户总条数
    public Integer customerCountByQueryVo(QueryVo vo);

    //用户分页结果集
    public List<User> selectCustomerListByQueryVo(QueryVo vo);

    //设置用户状态为禁用
    int updateStateById(String id);

    //解禁用户
    int updateState1ById(String id);

}

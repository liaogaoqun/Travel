package Lgq_travel.springboot.mapper;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public User getUser(User user);
    public User selectUser();
    public int userRegister(User user);
    //检查用户重复命名数量
    int CheckUsername(String username);
    //更改用户信息
    int UpdateInfo(User user);


//    //用户注册
//    public int UserRegister(User user);
//
//    //用户更改信息
//    public int UpdateUserInfo(User user);
//
//    //检查重复名数量
//    public int CheckUsername(String UserName);
//
//    //总条数
//    public Integer customerCountByQueryVo(QueryVo vo);
//    //结果集
//    public List<User> selectCustomerListByQueryVo(QueryVo vo);
//
//    int updateStateById(String id);

}

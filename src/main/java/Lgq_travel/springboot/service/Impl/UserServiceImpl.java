package Lgq_travel.springboot.service.Impl;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.mapper.UserMapper;
import Lgq_travel.springboot.service.UserService;
import Lgq_travel.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User UserLogin(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public List<User> Select() {
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

    @Override
    public void updateStateById(String id) {
        userMapper.updateStateById(id);
    }

    @Override
    public void updateStateBy1Id(String id) {
            userMapper.updateState1ById(id);
    }

    @Override
    public Page<User> selectPageByQueryVo(QueryVo vo) {
        Page<User> page = new Page<User>();
        //每页数
        page.setSize(5);
        vo.setSize(5);
        if (null != vo) {
            if(null != vo.getName() && !"".equals(vo.getName().trim())){
                vo.setName(vo.getName().trim());
            }
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() -1)*vo.getSize());
            }
            //总条数
            page.setTotal(userMapper.customerCountByQueryVo(vo));
            page.setRows(userMapper.selectCustomerListByQueryVo(vo));
        }
        return page;
    }

    @Override
    public User showUserDetail(User user) {
        return userMapper.getUser(user);
    }
}

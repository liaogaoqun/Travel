package Lgq_travel.springboot.mapper;

import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerMapper {
    //插入管理员
    public int insertManager(Manager manager);
    //删除管理员
    public int deleteManager(String id);
    //通过名字获取管理员列表
    public List<Manager> getAllManager(String name);

    public Manager confirmManager(Manager manager);
}

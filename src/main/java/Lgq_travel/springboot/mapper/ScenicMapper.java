package Lgq_travel.springboot.mapper;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.Scenic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScenicMapper {
    //输出全部景点
    List<Scenic> selectAllScience();
    //总条数
    Integer postCountByQueryVo(QueryVo vo);
    //输出一定数量景点
    List<Scenic> selectPostScience(QueryVo vo);
    //通过id获得景点
    Scenic selectScenicById(Integer id);
    //增加景点
    void addScenic(Scenic scenic);
    //删除景点
    public void deleteById(Integer id);
    //更新
    int updateScenic(Scenic scenic);
    //更新售卖票数
    int updateScenicSales(Integer id);

}

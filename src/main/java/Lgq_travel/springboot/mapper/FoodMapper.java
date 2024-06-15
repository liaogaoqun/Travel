package Lgq_travel.springboot.mapper;

import Lgq_travel.springboot.entity.Food;
import Lgq_travel.springboot.entity.QueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FoodMapper {
    //获得美食列表
    List<Food> selectAllFood();
    //通过id获得美食
    Food selectFoodById(Integer id);
    //获得Food表总条数
    Integer postCountByQueryVo(QueryVo vo);
    //返回分页结果集
    List<Food> selectPostListByQueryVo(QueryVo vo);
}

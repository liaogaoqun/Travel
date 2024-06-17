package Lgq_travel.springboot.service;

import Lgq_travel.springboot.entity.Food;
import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.utils.Page;

import java.util.List;

public interface FoodService {
    //获取全部食物列表
    List<Food> selectFoodList();
    //返回分页食物列表
    Page<Food> selectFoodPageByQueryVo(QueryVo vo);
    //添加食物
    void addFood(Food Food);
    //删除食物
    void deleteById(Integer id);
    //更新食物信息
    int updateFood(Food Food);
    //通过食物id获取食物
    Food getFoodById(Integer id);
}

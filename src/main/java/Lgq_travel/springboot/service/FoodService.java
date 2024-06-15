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
}

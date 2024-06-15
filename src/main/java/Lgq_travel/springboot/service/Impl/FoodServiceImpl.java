package Lgq_travel.springboot.service.Impl;

import Lgq_travel.springboot.entity.Food;
import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.mapper.FoodMapper;
import Lgq_travel.springboot.service.FoodService;
import Lgq_travel.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<Food> selectFoodList() {
        return foodMapper.selectAllFood();
    }

    @Override
    public Page<Food> selectFoodPageByQueryVo(QueryVo vo) {
        Page<Food> page = new Page<Food>();
        //设置分页大小
        vo.setSize(5);
        page.setSize(5);
        if (vo!=null){
            if (vo.getPage()!=null && "".equals(vo.getPage())){
                vo.setStartRow((vo.getPage()-1)*vo.getSize());
                page.setPage(vo.getPage());
            }
            page.setTotal(foodMapper.postCountByQueryVo(vo));
            page.setRows(foodMapper.selectPostListByQueryVo(vo));
        }
        return page;
    }
}

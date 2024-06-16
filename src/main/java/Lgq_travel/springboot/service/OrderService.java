package Lgq_travel.springboot.service;

import Lgq_travel.springboot.entity.Order;
import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.utils.Page;

import java.util.List;

public interface OrderService {
    //通过uid获得用户所用订单
    List<Order> selectOrderByUid(Integer uid);
    //返回分页结果集
    Page<Order> selectOrderPageByQueryVo(QueryVo vo);
    //插入Order对象
    int insertOrder(Order order);
}

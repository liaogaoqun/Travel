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

    //通过订单编号更改订单状态
    int updateStateByOno(String orderno);

    //通过id更新state情况 --  1 未取票
    void updateStateById(Integer id);
    //通过id更新state -- 2 已取票
    void updateStateToPayById(Integer id);
    //通过订单号活动order对象
    Order getOrderByNo(String orderno);
}

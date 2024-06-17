package Lgq_travel.springboot.mapper;

import Lgq_travel.springboot.entity.Order;
import Lgq_travel.springboot.entity.QueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    //通过学生uid获取订单列表
    List<Order> selectOrderList(Integer uid);
    //订单列表总条数
    Integer postCountByQueryVo(QueryVo vo);
    //返回分页结果集
    List<Order> selectPostListByQueryVo(QueryVo vo);
    //插入Order
    int insertOrder(Order order);
    //通过订单编号更改订单状态
    int updateStateByOno(String orderno);

    int updateStateById(Integer id);

    void updateStateToPayById(Integer id);

    Order getOrderByNo(String orderno);
}

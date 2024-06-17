package Lgq_travel.springboot.service.Impl;

import Lgq_travel.springboot.entity.Order;
import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.mapper.OrderMapper;
import Lgq_travel.springboot.service.OrderService;
import Lgq_travel.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> selectOrderByUid(Integer uid) {
        return orderMapper.selectOrderList(uid);
    }

    @Override
    public Page<Order> selectOrderPageByQueryVo(QueryVo vo) {
        Page<Order> page = new Page<Order>();
        //每页数
        page.setSize(5);
        vo.setSize(5);
        if (null != vo) {
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }
            if(null != vo.getName() && !"".equals(vo.getName().trim())){
                vo.setName(vo.getName().trim());
            }
            if(null !=vo.getUserid()&&!"".equals(vo.getUserid().trim())){
                vo.setUserid(vo.getUserid().trim());
            }
            //总条数
            page.setTotal(orderMapper.postCountByQueryVo(vo));
            page.setRows(orderMapper.selectPostListByQueryVo(vo));
        }
        return page;
    }

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public int updateStateByOno(String orderno) {
        return orderMapper.updateStateByOno(orderno);
    }

    @Override
    public void updateStateById(Integer id) {
        orderMapper.updateStateById(id);
    }

    @Override
    public void updateStateToPayById(Integer id) {
        orderMapper.updateStateToPayById(id);
    }

    @Override
    public Order getOrderByNo(String orderno) {
        return orderMapper.getOrderByNo(orderno);
    }
}

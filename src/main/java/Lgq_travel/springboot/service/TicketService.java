package Lgq_travel.springboot.service;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.Ticket;
import Lgq_travel.springboot.utils.Page;

import java.util.List;

public interface TicketService {
    //返回门票列表
    Page<Ticket> selectTicketPageByQueryVo(QueryVo vo);
    //通过景点id查询相关门票
    List<Ticket> selectTicketListBySid(Integer sid);
    //通过景点id获取景点最低票价
    double selectTickerPriceBySid(Integer sid);
}

package Lgq_travel.springboot.mapper;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.Ticket;
import Lgq_travel.springboot.utils.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TicketMapper {
    //获取某景点所有票
    List<Ticket> selectTicketList(Integer sid);
    //获取票总数
    Integer postCountByQueryVo(QueryVo vo);
    //结果集
    List<Ticket> selectPostListByQueryVo(QueryVo vo);
    Double selectPriceBySid(Integer sid);
}

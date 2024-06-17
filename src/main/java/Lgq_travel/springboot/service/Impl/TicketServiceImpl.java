package Lgq_travel.springboot.service.Impl;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.Ticket;
import Lgq_travel.springboot.mapper.TicketMapper;
import Lgq_travel.springboot.service.TicketService;
import Lgq_travel.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public Page<Ticket> selectTicketPageByQueryVo(QueryVo vo) {
        Page<Ticket> page = new Page<Ticket>();
        //设置返回长度
        vo.setSize(5);
        //设置页数量
        page.setSize(5);
        if (vo != null) {
            if (vo.getPage() != null) {
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
                page.setPage(vo.getPage());
            }
            if (vo.getName() != null && !"".equals(vo.getName().trim())) {
                vo.setName(vo.getName().trim());
            }
            page.setTotal(ticketMapper.postCountByQueryVo(vo));
            page.setRows(ticketMapper.selectPostListByQueryVo(vo));
        }
        return page;
    }

    @Override
    public List<Ticket> selectTicketListBySid(Integer sid) {
        return ticketMapper.selectTicketList(sid);
    }

    @Override
    public double selectTickerPriceBySid(Integer sid) {
        return ticketMapper.selectPriceBySid(sid);
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketMapper.getTicketById(id);
    }

    public void deleteById(Integer id) {
        ticketMapper.deleteById(id);
    }

    public void addTicket(Ticket ticket) {
        ticketMapper.addTicket(ticket);
    }

    public int updateTicket(Ticket ticket) {
        return ticketMapper.updateTicket(ticket);
    }
}

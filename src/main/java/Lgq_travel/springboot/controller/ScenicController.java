package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.Scenic;
import Lgq_travel.springboot.entity.Ticket;
import Lgq_travel.springboot.mapper.TicketMapper;
import Lgq_travel.springboot.service.ScenicService;
import Lgq_travel.springboot.service.TicketService;
import Lgq_travel.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScenicController {
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private TicketService ticketService;

    @RequestMapping(value="/getScenicList")
    public @ResponseBody
    Map<String,Object> getScenicList(){
        List<Scenic> list =  scenicService.selectScenicList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",list);
        return map;
    }

//    @RequestMapping(value = "/getScenicPageForUser")
//    public String getScenicPageForUser(Model model, QueryVo vo, HttpServletRequest request){
//        Page<Scenic> page = scenicService.selectPageByQueryVo(vo);
////        for (Scenic scenic :page.getRows()) {
//////            List<Ticket> ticketList =  ticketService.selectTicketListByFid(scenic.getId());
//////            double cheapestPrice = ticketService.selectPriceByFid(scenic.getId());
//////            scenic.setTicketList(ticketList);
//////            scenic.setCheapestPrice(cheapestPrice);
////        }
//        //根据参数判断目前是不是根据地址获得景点信息
//        String addrParameter = request.getParameter("addr");
//        if (addrParameter!=null){
//            model.addAttribute("addrParameter",addrParameter);
//        }
//        model.addAttribute("page", page);
//        return "user/scenicList";
//    }
    @RequestMapping(value = "/getScenicPageForUser")
    public String getScenicPageForUser(Model model,QueryVo vo,HttpServletRequest request){
        Page<Scenic> page = scenicService.selectPageByQueryVo(vo);
        //设置景点门票信息并传回Page
        for (Scenic scenic:page.getRows()){
            List<Ticket> ticketList = ticketService.selectTicketListBySid(scenic.getId());
            double price = ticketService.selectTickerPriceBySid(scenic.getId());
            scenic.setTickets(ticketList);
            scenic.setPrice(price);
        }
        //根据前端返回的Address参数判断目前是不是根据地址获得景点信息
        String addrParameter = request.getParameter("addr");
        if (addrParameter != null){
            model.addAttribute("addrParameter",addrParameter);
        }
        model.addAttribute("page",page);
        return "user/scenicList";
    }

}

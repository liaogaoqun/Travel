package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.Scenic;
import Lgq_travel.springboot.entity.Ticket;
import Lgq_travel.springboot.service.ScenicService;
import Lgq_travel.springboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TickerController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ScenicService scenicService;

    @RequestMapping(value = "/getScenicTById")
    public String getScenicById(Integer id, Model model){
        Scenic scenic = scenicService.getScenicById(id);
        List<Ticket> ticketList =  ticketService.selectTicketListBySid(id);
        scenic.setTickets(ticketList);
        model.addAttribute("scenic", scenic);
        return "user/scenicTicketInfo";
    }
}

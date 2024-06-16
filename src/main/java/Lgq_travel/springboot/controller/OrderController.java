package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.Order;
import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.Ticket;
import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.service.OrderService;
import Lgq_travel.springboot.service.TicketService;
import Lgq_travel.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class OrderController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private OrderService orderService;

    /*
    在旅游景点界面点击购买
    获得的订单信息
    */
    @RequestMapping(value = "/getOrderInfo")
    public String ToPayOrderPage(Integer id, Model model) {
        Ticket ticket = (Ticket) ticketService.selectTicketListBySid(id);
        model.addAttribute("ticket", ticket);
        return "user/order";
    }

    /**
     * 用户查看自己的订单列表
     */
    @RequestMapping(value = "listOrder")
    public String UserToOrderList(HttpSession session, Model model, QueryVo vo) {
        //获得当前user对象
        User user = (User) session.getAttribute("user");
        //设置Userid信息
        vo.setUserid(String.valueOf(user.getUserid()));
        Page<Order> page = orderService.selectOrderPageByQueryVo(vo);
        model.addAttribute("page", page);
        return "user/orderInfo";
    }

    /*
     * 提交订单转至付款页面
     * */
//    @RequestMapping(value = "/submitOrderInfo")
//    public String submitOrder(HttpServletRequest request, Order order, String name, Double price, Model model){
//        order.setPrice(price*order.getNum());
//        order.setOrderno(UUID.randomUUID().toString());
//        order.setTicketno(UUID.randomUUID().toString());
//        User user = (User)request.getSession().getAttribute("user");
//        order.setUid(user.getUserid());
//        orderService.insertOrder(order);
//        model.addAttribute("order",order);
//        model.addAttribute("mprice",price);
//        model.addAttribute("name",name);
//        return "user/orderInfo";
//    }

    @RequestMapping(value = "/submitOrderInfo")
    public String submitOrder(HttpServletRequest request, Order order, String name, Double price, Model model) {
        //设置总价
        order.setPrice(price * order.getNum());
        //使用十六机制随机数设置订单编号和取票号
        order.setOrderno(UUID.randomUUID().toString());
        order.setTicketno(UUID.randomUUID().toString());

        User user = (User) request.getSession().getAttribute("user");
        order.setUid(user.getUserid());
        orderService.insertOrder(order);
        model.addAttribute("order", order);
        model.addAttribute("cprice", price);
        model.addAttribute("name", name);
        return "user/orderInfo";
    }
}

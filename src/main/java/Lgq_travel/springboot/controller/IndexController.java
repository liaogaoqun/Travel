package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.Food;
import Lgq_travel.springboot.entity.Scenic;
import Lgq_travel.springboot.service.FoodService;
import Lgq_travel.springboot.service.ScenicService;
import Lgq_travel.springboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ScenicService scenicService;
    @Autowired
    FoodService foodService;
    @Autowired
    TicketService ticketService;

    /**
     * 管理员登陆界面
     * @return
     */
    @RequestMapping(value = "/managerLoginPage")
    public String toManagerLoginPage(){
        return "manager/login";
    }

    /**
     * 加载管理员首页
     * @return
     */
    @RequestMapping(value = "/manager")
    public String testManagerIndex(){
        return "manager/index";
    }

    /**
     * 用户登录界面
     * @return
     */
    @RequestMapping(value = "/loginPage")
    public String toLoginPage(){
        return "user/login";
    }

    /**
     * 用户注册界面
     * @return
     */
    @RequestMapping(value = "/registerPage")
    public String toRegisterPage(){
        return "user/register";
    }

    @RequestMapping(value = "/userInfoPage")
    public String toInformationPage(){
        return "user/userInfo";
    }

    /**
     * 加载用户主界面
     * @param model
     * @return
     */
    @RequestMapping(value = "/user")
    public String testUserIndex(Model model){
        //获取热度榜靠前的景点
        List<Scenic> list =  scenicService.selectScenicList();
        List<Food> listFood =  foodService.selectFoodList();
//        获取热度榜前3的景点
        list = list.subList(0, 3);
        listFood = listFood.subList(0, 3);
        model.addAttribute("list",list);
        model.addAttribute("listFood",listFood);
        return "user/index";
    }
}

package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.Food;
import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.service.FoodService;
import Lgq_travel.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;
    /**
     * 为用户展示所有美食getScenicPageForUser
     * @param model
     * @return
     */
    @RequestMapping(value = "/getFoodPageForUser")
    public String listFoodPageToUser(Model model, QueryVo vo){
        Page<Food> page = foodService.selectFoodPageByQueryVo(vo);
        model.addAttribute("page",page);
        return "user/foodList";
    }
}

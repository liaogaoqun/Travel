package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.Food;
import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.service.FoodService;
import Lgq_travel.springboot.utils.Page;
import Lgq_travel.springboot.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 管理员管理美食资讯
     * @param model
     * @param vo
     * @return
     */
    @RequestMapping(value = "/manageFood")
    public String getFoodPage(Model model, QueryVo vo){
        System.out.println("vo:"+vo.getName());
        Page<Food> page = foodService.selectFoodPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("name",vo.getName());
        return "manager/food";
    }

    /**
     * 管理员新增美食信息
     //     * @param scenic
     * @return
     */
    @RequestMapping(value = "/addFood")
    public String insert(Food tastyFood, MultipartFile foodImage){
        System.out.println(tastyFood);
        //当上传的图片不为空的时候才去存储路径,否则不存
        if (foodImage.getSize() != 0) {
            //将上传的文件保存到磁盘中
            String path = "E:\\workspace_IDEA\\bdtravel\\src\\main\\webapp\\image\\foodpic";
            String path1="E:\\Git demo\\Travel\\Lgq_Travel\\src\\main\\webapp\\image\\foodpic";
            String imageName = UploadUtil.upload(foodImage,path1);
            //将图片路径封装到Scenic中
            tastyFood.setImg("image/foodpic/"+imageName);
        }
        //插入
        foodService.addFood(tastyFood);
        return "redirect:/manageFood";
    }

    @RequestMapping(value = "/deleteFood")
    public @ResponseBody
    String deleteScenic(Integer id){
        //删除
        foodService.deleteById(id);
        return "OK";
    }

    /**
     * 管理员修改美食信息
     * @param
     * @return
     */
    @RequestMapping(value = "/updateFood")
    public String update(Food Food, MultipartFile foodImage){
        //当上传的图片不为空的时候才去存储路径,否则不存
        if (foodImage.getSize() != 0) {
            //将上传的文件保存到磁盘中
            String path = "E:\\workspace_IDEA\\bdtravel\\src\\main\\webapp\\image\\foodpic";
            String path1="E:\\Git demo\\Travel\\Lgq_Travel\\src\\main\\webapp\\image\\foodpic";
            String imageName = UploadUtil.upload(foodImage,path1);
            //将图片路径封装到Scenic中
            Food.setImg("image/foodpic/"+imageName);
        }
        foodService.updateFood(Food);
        return "redirect:/manageFood";
    }

    /**
     * 根据id获得美食信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getFoodById")
    public @ResponseBody
    Food getFoodById(Integer id){
        Food Food = foodService.getFoodById(id);
        return Food;
    }
}

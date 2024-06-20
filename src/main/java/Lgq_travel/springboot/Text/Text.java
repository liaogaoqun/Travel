package Lgq_travel.springboot.Text;

import Lgq_travel.springboot.entity.Food;
import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.mapper.TicketMapper;
import Lgq_travel.springboot.service.*;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Text {
    @Autowired
    private UserService userService;
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private FoodService foodService;
    User user = new User();
    @Autowired
    private OrderService orderService;
    Food food = new Food();
    @Autowired
    private TicketMapper ticketMapper;
    @Test
    public void he() {
//    System.out.println(scenicService.selectScenicList());

//    System.out.println(ticketService.selectTickerPriceBySid(1));
//    System.out.println(ticketService.selectTicketListBySid(1));

//    user.setUsername("TEXT1");
//    user.setPassword("e10adc3949ba59abbe56e057f20f883e");
//    System.out.println(userService.UserLogin(user));

//        System.out.println(orderService.selectOrderByUid(6));
//        QrCodeUtil.generate("https://4fb0-124-89-23-255.ngrok-free.app/user/test", 300, 300, FileUtil.file(":C:/Users/31752/Desktop/二维码.jpg"));
//        managerService.

//        food.setId(11);
//        food.setImg("ffaafafa");
//        food.setAddress("fafafff");
//        food.setMessage("faffafafaf");
//        food.setName("safafafs");
////        foodService.addFood(food);
//        foodService.updateFood(food);
//        System.out.println( foodService.getFoodById(4));
//        user.setUserid(5);
//        user.setName("廖");
//        userService.UpdateInfo(user);
        System.out.println(ticketService.selectTickerPriceBySid(2));
//        System.out.println(ticketMapper.selectPriceBySid(1));
    }


}

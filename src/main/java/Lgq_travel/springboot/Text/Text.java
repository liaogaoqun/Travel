package Lgq_travel.springboot.Text;

import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.service.ScenicService;
import Lgq_travel.springboot.service.TicketService;
import Lgq_travel.springboot.service.UserService;
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
    User user = new User();

@Test
public void he(){
//    System.out.println(scenicService.selectScenicList());
//    System.out.println(ticketService.selectTickerPriceBySid(1));
//    System.out.println(ticketService.selectTicketListBySid(1));
    user.setUsername("TEXT1");
    user.setPassword("e10adc3949ba59abbe56e057f20f883e");
    System.out.println(userService.UserLogin(user));
}
}

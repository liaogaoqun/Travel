package Lgq_travel.springboot.Text;

import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
public class Text {
    @Autowired
    private UserService userService;
    private User user;
    @Test
    public void he(){
        System.out.println(userService.UserLogin(user));
    }
}

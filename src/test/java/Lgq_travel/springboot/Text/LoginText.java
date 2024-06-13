package Lgq_travel.springboot.Text;
import Lgq_travel.springboot.SpringbootApplication;
import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = SpringbootApplication.class)
public class LoginText {
    @Autowired
    private UserService userService;
    private User user;
    @Test
    public User he(){
        return userService.UserLogin(user);
    }
}

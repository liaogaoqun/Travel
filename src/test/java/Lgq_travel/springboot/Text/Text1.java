package Lgq_travel.springboot.Text;

//import com.example.junit.services.TestService;
import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.service.UserService;
import Lgq_travel.springboot.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Text1 {
    @Autowired
    private UserService userService;
    @Test
    public void he(){
//        System.out.println( userService.Select());
        User user =new User();
        user.setPassword("123456");
//        String p = user.getPassword();
        System.out.println("123456".equals(user.getPassword()));
        System.out.println(MD5Utils.md5("123456"));
//        System.out.println(MD5Utils.md5(user.getPassword()));
    }
}

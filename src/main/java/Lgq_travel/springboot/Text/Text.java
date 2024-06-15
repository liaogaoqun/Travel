package Lgq_travel.springboot.Text;

import Lgq_travel.springboot.service.ScenicService;
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
    private ScenicService scenicService;

@Test
public void he(){
    System.out.println(scenicService.selectScenicList());
}
}

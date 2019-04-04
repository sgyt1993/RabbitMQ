import common.RabbitApplication;
import common.rabbit.dao.HellowSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/1 15:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class RabbitMqHellowTest {
    @Autowired
    private HellowSender hellowSender;

    @Test
    public void hello(){
        hellowSender.send();
    }

    @Test
    public void topicsend(){
        hellowSender.send1();
        hellowSender.send2();
        hellowSender.send3();
    }

    @Test
    public void fanoutsend(){
        hellowSender.sendFanout();
    }

}

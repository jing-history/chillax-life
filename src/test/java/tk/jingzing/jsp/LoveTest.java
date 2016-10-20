package tk.jingzing.jsp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tk.jingzing.Application;
import tk.jingzing.entity.Love;
import tk.jingzing.service.LoveService;

/**
 * Created by wangyunjing on 16/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class LoveTest {

    @Autowired
    private LoveService loveService;

    @Before
    public void setUp() {
        // 准备，清空user表
        //	studentService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {
        Love love = loveService.getMyLove();
        Assert.assertEquals(new Integer(2),love.getId());
        Assert.assertEquals("罗柳华",love.getName());
    }
}

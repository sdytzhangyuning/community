package life.yuning.community;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import life.yuning.community.Service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

//	@Test
//	public void contextLoads() {
//	}
	@Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {
        System.out.println("插入5个用户");
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);
        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.getAllUsers().intValue());
        // 删除两个用户
        userService.deleteByName("a");
        userService.deleteByName("e");
        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }

}

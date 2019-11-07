package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ApplicationConfig;
import entity.User;
import service.prototype.IUserService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class})
public class UserServiceTest {
	@Autowired
	private IUserService userService;
	@Test
	public void TestListUsers() {
//		 System.out.println(userService.listUsers(1, 3));
		Pager<User>  pager = (Pager<User>) userService.listUsers(1, 3);
		for (User user : pager.getData()) {
			System.out.println(user);
		}
	}
}



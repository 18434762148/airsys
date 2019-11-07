package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;

/**
 * 测试Service
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class AccountServiceTest {
	@Autowired
	private IAccountService actService;
	@Test
	public void TestSearchFind() {
		System.out.println(actService.searchAccount(5));
	}
	@Test
	public void TestTotal() {
		Pager<Account> pager = (Pager<Account>) actService.listPaged(1, 5);
		for (Account account : pager.getData()) {
			System.out.println(account);
		}
		System.out.println(pager.getTotal());
	}
}




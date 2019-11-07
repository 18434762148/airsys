package daoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IAccountDao;
import entity.Account;

/**
 * 单元测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAccountDao {
	@Autowired
	private IAccountDao actDao;
	@Test
	public void TestFindById(){
		System.out.println(actDao.find(1));
	}
	@Test
	public void TestSaveOrUpdate() {
		Account act = new Account(7,"c",3000);
		actDao.saveOrUpdate(act);
	}
	@Test
	public void TestDelete() {
		actDao.delete(7);
	}
	@Test
	public void TestFind() {
		List<Account> acts = actDao.findAll();
		for (Account act : acts) {
			System.out.println(act);
		}
	}
}






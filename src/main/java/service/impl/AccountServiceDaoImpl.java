package service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.prototype.IAccountDao;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;
@Service("accountServiceDaoImpl")
public class AccountServiceDaoImpl implements IAccountService{
	@Autowired
	private IAccountDao actDao;
	@Override
	public void transfer(Account from, Account to, double money) {
		//涉及到事务   Spring   声明式的Transaction处理(AOP动态代理模式的应用)
		from.setBalance(from.getBalance()+money);
		to.setBalance(to.getBalance()-money);
		actDao.saveOrUpdate(from);
		actDao.saveOrUpdate(to);
	}

	@Override
	public Account searchAccount(int id) {
		return actDao.find(id);
	}

	@Override
	public List<Account> listAccount(int pageNo, int pageSize) {
		return null;
	}

	@Override
	public List<Account> listPaged(int pageNo, int pageSize) {
		return  actDao.find((pageNo-1)*pageSize, pageSize);
	}

}

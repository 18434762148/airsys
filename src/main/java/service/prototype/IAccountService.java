package service.prototype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

/**
 * Account业务接口
 * @author Administrator
 *
 */
public interface IAccountService {
	void transfer(Account from,Account to,double money);
	//查询账号
	Account searchAccount(int id);
	//分页查询数据
	
	List<Account> listAccount(int pageNo , int pageSize);
	@MiniPager(tableName = "account")
	List<Account> listPaged(int pageNo , int pageSize);
}

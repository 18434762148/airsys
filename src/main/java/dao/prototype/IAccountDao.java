package dao.prototype;

import java.util.List;
import entity.Account;
import util.Pager;

/**
 *AccountDao 
 */
public interface IAccountDao {
//	void modify(Account act, Connection con);      //事务的原子性
	//查询
	Account find(int id);
	//再写修改
	void saveOrUpdate(Account act);
	void delete(int id);
	List<Account> findAll();
	//做分页返回数据是不够的
	List<Account> find(int offset , int pageSize);   // 查全部    0     Integer.MaxValue
//	Pager<Account> findPaged(int offset , int pageSize);
	int totalItems();        //获取总条数
}

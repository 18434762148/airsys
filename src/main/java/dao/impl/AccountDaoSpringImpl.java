package dao.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import dao.prototype.IAccountDao;
import entity.Account;
import util.Pager;
/**
 * AccountDao实现类
 * @author Administrator
 *
 */
@Repository("accountDaoSpringImpl")
public class AccountDaoSpringImpl implements IAccountDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private DataSource ds;
	@Override
	public Account find(int id) {
		return jdbcTemplate.queryForObject("select * from account where id=?",new Object[] {id}, new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public void saveOrUpdate(Account act) {
		if(act.getId()==0) {
			jdbcTemplate.update("insert into account(name,balance) values(?,?)",new Object[] {act.getName(),act.getBalance()});
			System.out.println("添加成功");
		}else {
			jdbcTemplate.update("update account set name=?,balance=? where id=?",new Object[] {act.getName(),act.getBalance(),act.getId()});
			System.out.println("修改成功");
		}
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update("delete from account where id=?", new Object[] {id});
		System.out.println("删除成功");
	}

	@Override
	public List<Account> findAll() {
		return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> find(int offset, int pageSize) {
		return jdbcTemplate.query("select * from account limit ?,?", new Object[] {offset,pageSize},new BeanPropertyRowMapper<Account>(Account.class));
	}

/*	@Override
	public Pager<Account> findPaged(int offset, int pageSize) {
		return null;
	}*/

	@Override
	public int totalItems() {
		return jdbcTemplate.queryForObject("select count(*) from account", Integer.class);
	}
	
}

package service.prototype;

import java.util.List;
import entity.User;
import util.MiniPager;

public interface IUserService {
	@MiniPager(tableName = "User")
	List<User> listUsers(int pageNo,int pageSize);
}

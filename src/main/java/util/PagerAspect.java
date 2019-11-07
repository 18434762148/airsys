package util;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import entity.Account;

/**
 * 分页切面
 * 
 * @author Administrator
 *
 */
@Aspect
@Component
public class PagerAspect {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 自定义切点
	@Pointcut("execution(* service..*(..))")
	public void selfPointcut() {}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Around("selfPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint jp) {
		Object o = null;
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Method m = signature.getMethod();
		MiniPager miniPager = m.getAnnotation(MiniPager.class);
		if (miniPager == null) {
			try {
				o = jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace(); 
			}
			return o;
		}
		// 若加有@MiniPager标注，则加入分页代码
		// 获取某实体类对应的总的条目数
		String tableName = miniPager.tableName();
		int totalItems = jdbcTemplate.queryForObject("select count(*) from " + tableName, Integer.class);
		// 根据页大小计算总的页数
		int pageSize = (int) jp.getArgs()[1];
		int pageNo = (int) jp.getArgs()[0];
		int totalPages = (totalItems + pageSize - 1) / pageSize;
		if(pageNo>=totalPages) {
			pageNo=totalPages;
		}
		// 返回Pager对象
		Pager pager = new Pager();
		try {
			List data = (List) jp.proceed(new Object[] {pageNo,pageSize});
//			for (Object object : data) {
//				System.out.println(object);
//			}
			pager.setData(data);
			pager.setTotal(totalPages);
		} catch (Throwable e) {
			e.printStackTrace();
		}
//		System.out.println(pageSize);
		return pager;
	}
//	@After("selfPointcut()")
//	public List<Account> after() {
//		return null;
//	}
}

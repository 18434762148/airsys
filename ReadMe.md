1. 分页框架：
    		分页更加简单
       需求：
		    框架可以自动分页
			      标注和AOP：写标注和切面来实现这个框架

2.  MiniPager框架
		目标：
			(1).  使用标注来实现分页
			(2).  减少重复的分页代码
		实现：
			分析：以结果为导向去分析，或者以程序员用例来分析
		编写步骤：
			(1).  编写自定义标注
					@MiniPager：至少应该有个表名属性
			(2).  编写切面(核心框架代码)
					a. 配置类启动AOP的功能 @EnableAspectJAutoProxy
							@ComponentScan({"util"})
					b. 编写系定义切面：
							util：PagerAspect(分页切面)
							@Aspect
							@Component
					c. 自定义切面中的切点：
						@Pointcut("execution(* service..*(..))")     检测service包及子包下的所有方法
							public void selfPointcut() {}        
					d. 自定义通知   (Around)
						public List<Account> aroundAdvice(ProceedingJoinPoint jp){}
						测试
					e. 编写通知体里面的核心代码(实现通用分页的核心代码)
							I.  只有在加入@MinPager标注的方法上实现拦截功能
							思路：拿到被调用的方法对象Method对象，然后判断该方法上有没有@MiniPager标注
							若有就加入切面功能，否则不加
					
					
							
							
							
							
							
							

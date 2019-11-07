package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Tomcat启动的时候会检测是否有WebApplicationInitializer接口的类
 * 若检测到有这个类，就会实例化它，并调用它的onStartup方法
 * @author Administrator
 *
 */
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ApplicationConfig.class);
		ctx.setServletContext(servletContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
/*
 * 你想使用Spring，就得有Spring容器的实例
 * 你想使用Spring MVC，就得配置DispatcherServlet的实例
 * 还要把这两个东西放到ServletContext对象里，因为他们俩都是重量级对象
 * 
 * */
 
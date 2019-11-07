package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 应用配置(Spring配置)
 * 它相当于XML的替代者
 * @author Administrator
 *
 */
@Configuration
@ComponentScan({"dao","service","entity","controller"})
@Import(DBConfig.class)
@EnableAspectJAutoProxy
//@EnableWebMvc
public class ApplicationConfig extends WebMvcConfigurationSupport{
	@Bean
	public  UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");     // 位置   受保护的，不可以直接访问
		resolver.setSuffix(".jsp");                //jsp文件的后缀   你在写页面的时候就省略掉后缀
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	/**
	 *配置处理静态资源 
	 * 
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		super.addResourceHandlers(registry);
	}

}

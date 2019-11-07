package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 应用配置(Spring配置)
 * 它相当于XML的替代者
 * @author Administrator
 *
 */
@Configuration
@ComponentScan({"dao","service","controller"})
@Import(DBConfig.class)
@EnableAspectJAutoProxy
public class TestConfig {
	
}

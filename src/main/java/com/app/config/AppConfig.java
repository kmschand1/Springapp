package com.app.config;

import java.util.Properties;
//test
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.User;

@Configuration
@ComponentScan("com.app")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:app.properties")
@Import(SecurityConfig.class)
public class AppConfig {


	@Autowired
	private Environment env;

	@Bean
	public BasicDataSource bs(){

		BasicDataSource b=new BasicDataSource();
		                b.setDriverClassName(env.getProperty("db.driver"));
		                b.setUrl(env.getProperty("db.url"));
		                b.setUsername(env.getProperty("db.un"));
		                b.setPassword(env.getProperty("db.pwd"));
		                System.out.println(b);
		                
		return b;


	}

	@Bean
	public LocalSessionFactoryBean sf(){
		LocalSessionFactoryBean s=new LocalSessionFactoryBean();
		                        s.setDataSource(bs());
		                        s.setHibernateProperties(p());
		                        s.setAnnotatedClasses(User.class);

		return s;


	}
	@Bean
	public Properties p(){
		Properties pp= new Properties();
		           pp.setProperty("hibernate.dialect", env.getProperty("dialect"));
		           pp.setProperty("hibernate.show_sql", env.getProperty("showsql"));
		           pp.setProperty("hibernate.formate_sql", env.getProperty("fsql"));
		           pp.setProperty("hibernate.hbm2ddl.auto", env.getProperty("ddl"));


		return pp;


	}

	@Bean
	public HibernateTemplate ht(){
		HibernateTemplate h=new HibernateTemplate();
		                  h.setSessionFactory(sf().getObject());

		return h;


	}

	@Bean
	public HibernateTransactionManager tx(){
		HibernateTransactionManager htm= new HibernateTransactionManager();
                                    htm.setSessionFactory(sf().getObject());
		return htm;


	}
	
	@Bean
	public InternalResourceViewResolver vr(){

		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		                             ir.setPrefix(env.getProperty("mvc.prefix"));
		                             ir.setSuffix(env.getProperty("mvc.suffix"));

		
		return ir;


	}
	@Bean
	public BCryptPasswordEncoder enc(){

	return new BCryptPasswordEncoder();
		                        

		
	


	}
	
}

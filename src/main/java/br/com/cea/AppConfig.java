package br.com.cea;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.mustache.MustacheTemplateLoader;
import org.springframework.web.servlet.view.mustache.MustacheViewResolver;

@EnableWebMvc
@ComponentScan
@Configuration
@EnableJpaRepositories
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * Configuracao do Datasource; TODO: Tirar a senha do banco e colocar no
	 * JNDI
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.teradata.jdbc.TeraDriver");
		dataSource.setUrl("jdbc:teradata://10.16.2.118");
		dataSource.setUsername("USRBTRDS");
		dataSource.setPassword("gnomo_2015");
		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter
				.setDatabasePlatform("org.hibernate.dialect.TeradataDialect");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("br.com.cea.entity");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		factory.setBeanName("entityManagerFactory");
		return factory.getObject();
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
	}

	@Bean
	public ViewResolver getViewResolver(ResourceLoader resourceLoader) {
		final MustacheViewResolver mustacheViewResolver = new MustacheViewResolver();
		final MustacheTemplateLoader mustacheTemplateLoader = new MustacheTemplateLoader();
		
		mustacheViewResolver.setPrefix("/WEB-INF/views/");
		mustacheViewResolver.setSuffix(".html");
		mustacheViewResolver.setCache(false);
		mustacheViewResolver.setContentType("text/html;charset=utf-8");
		mustacheViewResolver.setOrder(1);
		mustacheTemplateLoader.setResourceLoader(resourceLoader);
		mustacheViewResolver.setTemplateLoader(mustacheTemplateLoader);
		return mustacheViewResolver;
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		return resolver;
	}
	
}

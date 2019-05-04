package ru.itis.util;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.sql.DataSource;
import java.sql.DriverManager;

@EnableWebMvc
@Configuration
@ComponentScan("ru.itis")
@PropertySource("classpath:application.properties")
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Value("${db.url}")
    private String databaseUrl;

    @Value("${db.user}")
    private String databaseUser;

    @Value("${db.password}")
    private String databasePassword;

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setPassword(databasePassword);

        dataSource.setUsername(databaseUser);

        dataSource.setUrl(databaseUrl);

        dataSource.setDriverClassName("org.postgresql.Driver");

        return dataSource;

    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());

    }

    @Bean
    public ViewResolver viewResolver() {

        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();

        System.out.println("Create Bean viewResolver");

        viewResolver.setContentType("text/html; charset=windows-1251");

        viewResolver.setCache(true);

        viewResolver.setPrefix("");

        viewResolver.setSuffix(".ftl");

        return viewResolver;

    }


    @Bean

    public FreeMarkerConfigurer freemarkerConfig() {

        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();

        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/");

        return freeMarkerConfigurer;

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

    }

}

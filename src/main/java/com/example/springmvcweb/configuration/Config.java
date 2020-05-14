package com.example.springmvcweb.configuration;

import com.example.springmvcweb.util.hibernate.HBConfig;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan({"com.example.springmvcweb"})
@EnableWebMvc
public class Config implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/style/");
        registry.addResourceHandler("/javascript/**").addResourceLocations("/resources/javascript/");
        registry.addResourceHandler("/image/**").addResourceLocations("/resources/image/");
    }

    @Bean
    public SessionFactory sessionFactory() {
        return HBConfig.sessionFactory();
    }
}

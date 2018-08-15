package org.driving.school.web.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public MyInterceptor getMyInterceptor() {
        return new MyInterceptor();
    }

    /**
     * @author yangpengcheng
     * @desc 添加视图解析器
     * @date 2018-08-13
     */
    @Override
	public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("login");
    	registry.addViewController("/index.html").setViewName("login");
    	registry.addViewController("/login").setViewName("login");
	}

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");  
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/"); 
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：除了login，其他都拦截判断
        registry.addInterceptor(getMyInterceptor())
        .addPathPatterns("/**")
//        .excludePathPatterns("/login","/loginAction","/static/**","/js/**","/css/**","lib/**");
//        .excludePathPatterns("/login","/loginAction","/static/**");
       //访问index.html ,/ ,loginAction(登录请求) ,login登录页面请求 —  都不拦截
        .excludePathPatterns("/index.html","/loginAction","/","/login");
    }

    
}
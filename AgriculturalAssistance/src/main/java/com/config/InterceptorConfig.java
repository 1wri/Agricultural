package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.interceptor.AuthorizationInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport{
	
	@Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
        super.addInterceptors(registry);
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String path="D:\\扶贫助农管理系统\\AgriculturalAssistance\\src\\main\\resources\\static\\";
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/resources/")
				.addResourceLocations("classpath:/admin/")
				.addResourceLocations("classpath:/front/")
				.addResourceLocations("classpath:/public/")
				.addResourceLocations("file:"+path);
		super.addResourceHandlers(registry);
	}

}

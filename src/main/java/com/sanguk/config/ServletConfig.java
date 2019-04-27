package com.sanguk.config;

import com.sanguk.aop.HttpInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"com.sanguk"})
public class ServletConfig implements WebMvcConfigurer{
  
  @Autowired
	private HttpInterceptor httpInterceptor;



    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
  
      InternalResourceViewResolver bean = new InternalResourceViewResolver();
      bean.setViewClass(JstlView.class);
      bean.setPrefix("/WEB-INF/views/");
      bean.setSuffix(".jsp");
      registry.viewResolver(bean);
    }
  
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
  
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(httpInterceptor)
          .addPathPatterns("/**").excludePathPatterns("/resources/**","/upload/**","/user/**","/comment/**","/article/list");
    }

}

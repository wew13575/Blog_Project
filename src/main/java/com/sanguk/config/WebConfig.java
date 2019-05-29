package com.sanguk.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{


	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class, SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(
			ServletRegistration.Dynamic registration) {

		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

	}
	
	@Override
	  protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true, true);
		  
		  

	      return new Filter[] { characterEncodingFilter };
		}
		
}
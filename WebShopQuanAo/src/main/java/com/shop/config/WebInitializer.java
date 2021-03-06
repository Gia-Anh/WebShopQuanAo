package com.shop.config;


import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {ApplicationContextConfig.class, WebSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}


	@Override
	protected Filter[] getServletFilters() {

	   CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

	   encodingFilter.setForceEncoding(true);
	   encodingFilter.setEncoding("UTF-8");

	   return new Filter[]{encodingFilter};

	}
}

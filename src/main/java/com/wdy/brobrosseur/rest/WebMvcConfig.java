
/*
 * Created on 2024-09-29 ( Time 22:05:30 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdy.brobrosseur.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RestInterceptor(new WebRequestInterceptor() {
			@Override
			public void preHandle(WebRequest request) throws Exception {

			}

			@Override
			public void postHandle(WebRequest request, ModelMap model) throws Exception {

			}

			@Override
			public void afterCompletion(WebRequest request, Exception ex) throws Exception {

			}
		}));
	}
}

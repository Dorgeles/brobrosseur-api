
/*
 * Created on 2024-09-29 ( Time 22:05:30 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdy.brobrosseur.rest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;


public class RestInterceptor extends WebRequestHandlerInterceptorAdapter {

	private static String	defaultTenant	= "null";
	
	private static String defaultLanguage = "fr";

	/**
	 * Create a new WebRequestHandlerInterceptorAdapter for the given WebRequestInterceptor.
	 *
	 * @param requestInterceptor the WebRequestInterceptor to wrap
	 */
	public RestInterceptor(WebRequestInterceptor requestInterceptor) {
		super(requestInterceptor);
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

		String tenantValue = req.getHeader("tenantID");

		if (tenantValue != null) {
			req.setAttribute("CURRENT_TENANT_IDENTIFIER", tenantValue);
		} else {
			req.setAttribute("CURRENT_TENANT_IDENTIFIER", defaultTenant);
		}
		
		String langValue = req.getHeader("lang");

		if (langValue != null) {
			req.setAttribute("CURRENT_LANGUAGE_IDENTIFIER", langValue);
		} else {
			req.setAttribute("CURRENT_LANGUAGE_IDENTIFIER", defaultLanguage);
		}
		return true;
	}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmd Sa3ed
 */

public class ErrorHandleFilter implements Filter {

	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}

	@Override
	public void doFilter(ServletRequest request,
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		try {
                    HttpServletRequest request1 = (HttpServletRequest) request;
                    HttpServletResponse response1 = (HttpServletResponse) response;
                    if(request1.getRequestURI().contains("login")){
                       chain.doFilter(request, response);
                    }else if(request1.getSession().getAttribute("LoggedUser") != null){
                        chain.doFilter(request, response);
                    }else{
                       request.getRequestDispatcher("/WEB-INF/pages/login.jsp")
                               .forward(request, response); 
                    }
                     
			
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp")
                               .forward(request, response);
		}

	}
        
}
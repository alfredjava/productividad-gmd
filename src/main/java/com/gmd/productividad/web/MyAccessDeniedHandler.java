package com.gmd.productividad.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;


public class MyAccessDeniedHandler implements AccessDeniedHandler {
	private String accessDeniedUrl;
	
	
	public MyAccessDeniedHandler() {
		
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("message",
				"No tienes permiso para acceder a esta pagina");
		request.getRequestDispatcher("/"+accessDeniedUrl + ".jsp").forward(request, response);
	    

	}
	
	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}
 
	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

}

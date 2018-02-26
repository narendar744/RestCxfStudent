package com.narendar;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, javax.servlet.http.HttpServletResponse arg1)
			throws ServletException, IOException {
		
		PrintWriter writer= arg1.getWriter();
	
		writer.println("Hello Narendar");
	}
}

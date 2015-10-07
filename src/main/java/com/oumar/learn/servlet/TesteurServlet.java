package com.oumar.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TesteurServlet extends HttpServlet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(TesteurServlet.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try{
			HttpSession session = request.getSession();
			Integer ct = (Integer) session.getAttribute("ct");
			logger.info("session id: "+session.getId()+", ct: "+ct);
			if(ct == null){
				ct = new Integer(0);
			}else{
				ct++;
			}
			session.setAttribute("ct", ct);
			PrintWriter writer = response.getWriter();
			writer.write("how high number: "+ct);
			writer.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		logger.info("End of TesteurServlet");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}

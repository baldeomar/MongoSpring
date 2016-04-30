package com.oumar.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class TesteurServlet extends HttpServlet implements Serializable{

	private static final long serialVersionUID = 1L;

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try{
			HttpSession session = request.getSession();
			Integer ct = (Integer) session.getAttribute("ct");
			log.info("session id: {}, ct: {}", session.getId(), ct);
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
			log.info("error occured: {}", ioe);
		}
	}

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}

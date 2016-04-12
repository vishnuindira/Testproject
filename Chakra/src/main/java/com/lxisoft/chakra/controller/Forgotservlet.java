package com.lxisoft.chakra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.lxisoft.chakra.hibernateutils.HibernateUtil;
import com.lxisoft.chakra.services.LoginService;
import com.lxisoft.chakra.services.MailService;

/**
 * Servlet implementation class Forgotservlet
 */
public class Forgotservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgotservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String uId = request.getParameter("userId");
		String email =  request.getParameter("email");
		HibernateUtil util = new HibernateUtil();
		
		
		LoginService loginservice =  new LoginService();
		MailService mailservice = new MailService();
		String pass=  loginservice.getUserPassword(uId);
		
	
		 boolean result = loginservice.forgotauthenticateuser(uId);
		{
			if(result==true){
				out.print("yesss");
				
				MailService.send(email,pass);
				}else{
					out.print("no account belongs to that id");
				}
					
		} 
		
		
		
		
		
	}}
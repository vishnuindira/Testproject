package com.lxisoft.chakra.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.chakra.hibernateutils.HibernateUtil;
import com.lxisoft.chakra.model.User;
import com.lxisoft.chakra.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		doGet(request, response);
		 String userId = request.getParameter("userId");	
		 String password = request.getParameter("password");
		 HibernateUtil h =  new HibernateUtil();
		 LoginService loginService = new LoginService();
         if(userId.equals("admin") && password.equals("admin")){
			 
        	 request.getRequestDispatcher("WEB-INF/protected/admin.jsp").forward(request, response);;
 		
			 
		 
		}else{
			 boolean result = loginService.authenticateUser(userId, password);
			 User user = loginService.getUserByUserId(userId);
			 if(result == true){
				 request.getSession().setAttribute("user", user);		
				 response.sendRedirect("home.jsp");
			 } 
			 else{
				 response.sendRedirect("error.jsp");
			 } 
 
		 }
			 
	}
	}
		 


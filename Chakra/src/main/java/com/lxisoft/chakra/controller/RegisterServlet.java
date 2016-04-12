package com.lxisoft.chakra.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.chakra.hibernateutils.HibernateUtil;
import com.lxisoft.chakra.model.User;
import com.lxisoft.chakra.services.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		doGet(request, response);
		PrintWriter out = response.getWriter();
		 String firstName = request.getParameter("firstName");
		 String email = request.getParameter("email");
		 String userId = request.getParameter("userId");
		 String password = request.getParameter("repassword");
		 User user = new User(firstName, email,userId, password);
				
		 try {	
			 HibernateUtil ut = new HibernateUtil();
			 RegisterService registerService = new RegisterService();
			 boolean result = registerService.register(user);		
			
			 if(result){
				 request.getRequestDispatcher("successregistration.jsp").forward(request, response);
				 
			 }else{
				 out.println("<h1>Registration Failed!</h1>");
				 out.println("To try again<a href=register.jsp>Click here</a>");
			 }
			 out.println("</center>");
			 out.println("</body>");
			 out.println("</html>");
		 } finally {		
			 out.close();
		 }
	}

	}

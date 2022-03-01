package com.servlet;

import java.io.IOException;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductRegistrationServlet
 */
@WebServlet("/ProductRegistrationServlet")
public class ProductRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		
		//Validate the inputs
		if(!validID(id))
		{
			response.setContentType("text/html");
			response.getWriter().println("<h4>That ID <q>" + id + "</q> does not match the numeric format or is too big.</h4>");
			response.getWriter().println("<br><form method=\"post\" action=\"product.html\"><button type=\"submit\">Try Again</button></form>");
		}
		else if(name.equals(""))
		{
			response.setContentType("text/html");
			response.getWriter().println("<h4>That Name <q>" + name + "</q> is invalid.</h4>");
			response.getWriter().println("<br><form method=\"post\" action=\"product.html\"><button type=\"submit\">Try Again</button></form>");
		}
		
		else
		{
			HttpSession ses = request.getSession();
			ses.setAttribute("id", request.getParameter("id"));
			ses.setAttribute("name", request.getParameter("name"));
			
			response.sendRedirect("validProduct.jsp");
			
		}
	}
	
	//Makes sure the id is a valid one
	private static boolean validID(String idTest)
	{
		Pattern pattern = Pattern.compile(idTest);
		
		Matcher matcher = pattern.matcher(idTest);
		
		if(idTest.length() > 8)
			return false;
		else if (matcher.matches())
			return true;
		else
			return false;
	}

}

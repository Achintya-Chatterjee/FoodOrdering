package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Resturant;

@WebServlet(urlPatterns = "/reslogin")
public class ResLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email_id=req.getParameter("eid");
		String pass=req.getParameter("password");
		
		try
		{
			Resturant r = new Resturant();
			r.setEmail_id(email_id);
			
			r.setPassword(pass);
			
			
			ResultSet res = r.loginResturant();
			
			if(res.next())
			{
				//Create Session object
				HttpSession session = req.getSession();
				//set emailid in Session object
				session.setAttribute("email", email_id);
				
				RequestDispatcher rd1 = req.getRequestDispatcher("resturanthome.jsp");
				String name = res.getString("resturant_name");
				req.setAttribute("name", name);
				rd1.forward(req, resp);
				
			}
			else
			{
				RequestDispatcher rd2 = req.getRequestDispatcher("login.jsp");
				req.setAttribute("errmsg", "Invalid Userid or Password");
				rd2.include(req, resp);
			}
		}	
			
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	

}

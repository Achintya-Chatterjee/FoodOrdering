package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

@WebServlet(urlPatterns = "/userlog")
public class UserLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id=req.getParameter("id");
		String password=req.getParameter("userpassword");
		
		System.out.println("Password in servlet: "+password);
		
		User u = new User();
		u.setUser_id(id);
		u.setUser_password(password);
		
		try 
		{
			ResultSet rs = u.userLogin();
			if(rs.next())
			{
				HttpSession session = req.getSession();
				session.setAttribute("userid", id);
				
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
				
				System.out.println("success");
			}
			else
			{
				System.out.println("failed");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

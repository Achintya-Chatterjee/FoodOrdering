package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Resturant;
import bean.User;

@WebServlet(urlPatterns = "/userregister")
public class AddUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user_id=req.getParameter("userid");
		String user_name=req.getParameter("username");
		String user_email=req.getParameter("eid");
		String user_state=req.getParameter("state");
		String user_city=req.getParameter("city");
		String user_address=req.getParameter("address");
		String user_password=req.getParameter("password");
		
		
		try
		{
			User u= new User();
			u.setUser_id(user_id);
			u.setUser_name(user_name);
			u.setUser_email(user_email);
			u.setUser_state(user_state);
			u.setUser_city(user_city);
			u.setUser_address(user_address);
			u.setUser_password(user_password);
			
			
			int res = u.userRegister();
			
			RequestDispatcher rd = req.getRequestDispatcher("userregistration.jsp");
			
			if(res == 1)
			{
				//System.out.println("Success");
				req.setAttribute("msg", "success");
			}
			else
			{
				req.setAttribute("msg", "Failed");
			}
			rd.forward(req, resp);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}

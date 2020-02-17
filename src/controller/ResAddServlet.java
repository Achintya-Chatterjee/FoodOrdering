package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Resturant;


@WebServlet(urlPatterns = "/resregister")
public class ResAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String res_name=req.getParameter("resname");
		String owner_name=req.getParameter("ownername");
		String email_id=req.getParameter("eid");
		String res_catagory=req.getParameter("catagory");
		String state=req.getParameter("state");
		String city=req.getParameter("city");
		String address=req.getParameter("address");
		String pass=req.getParameter("password");
		
		
		try
		{
			Resturant r = new Resturant();
			r.setResturant_name(res_name);
			r.setOwner_name(owner_name);
			r.setEmail_id(email_id);
			r.setResturant_type(res_catagory);
			r.setState(state);
			r.setCity(city);
			r.setAddress(address);
			r.setPassword(pass);
			
			
			int res = r.register();
			
			RequestDispatcher rd = req.getRequestDispatcher("signupresturant.jsp");
			
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

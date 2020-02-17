package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Menu;
import bean.Resturant;

@WebServlet(urlPatterns = "/addmenu")
public class AddMenuServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
		{
			PrintWriter out = resp.getWriter();
			
			String menu=req.getParameter("menu");
			
			HttpSession session = req.getSession(false);
			String email_id = (String)session.getAttribute("email");
			
			
			
			try 
			{
				Resturant r = new Resturant();
				r.setEmail_id(email_id);
				int rest_id= r.getRestId();
				
				//out.print(rest_id +" "+menu+" "+email_id);
				
				Menu m=new Menu();
				m.setResturant_id(rest_id);
				m.setMenuname(menu);
				
			
			  int res = m.addMenu();
			  
			  RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
			  
			  if(res == 1) 
			  { 
				  //System.out.println("Success"); 
				  req.setAttribute("msg","success"); 
		      } 
			  else 
			  { 
				  req.setAttribute("msg", "Failed"); 
			  }
			  rd.forward(req,resp);
			 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}

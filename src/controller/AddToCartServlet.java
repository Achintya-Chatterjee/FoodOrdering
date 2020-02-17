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

import bean.CartBean;

@WebServlet(urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int menuitem_id=Integer.parseInt(req.getParameter("menuitem_id"));
		System.out.println("Menuitem_id: "+menuitem_id);
		
		HttpSession httpSession = req.getSession(false);
		String userid = (String) httpSession.getAttribute("userid");
		
		
		
		if(userid == null)
		{
			RequestDispatcher rd = req.getRequestDispatcher("userlogin.jsp");
			rd.forward(req, resp);
		}
		else
		{
			CartBean cb = new CartBean();
			cb.setUserid(userid);
			cb.setMenuitem_id(menuitem_id);
					
			try 
			{
				//System.out.println("Try in Addto Cart Servlet");
				boolean result = cb.checkItem();
				if(result == false)
				{
					
					int res = cb.addToCart();
					if(res == 1)
					{
						RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
						rd.forward(req, resp);
					}
					else
					{
						System.out.println("Not Added into cart");
					}
				}
				else
				{
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.forward(req, resp);
				}
				
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		
	}

}

package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CartBean;

@WebServlet(urlPatterns="/plus")
public class QuantityPlusServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int cartid = Integer.parseInt(req.getParameter("cartid"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		quantity++;
		
		CartBean cb = new CartBean();
		cb.setCartid(cartid);
		cb.setQuantity(quantity);
		
		try 
		{
			int res = cb.updateCartItemQuantity();
			if(res == 1)
			{
				RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

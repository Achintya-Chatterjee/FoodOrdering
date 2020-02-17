package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import bean.MenuItem;
import bean.Resturant;

@WebServlet(urlPatterns = "/updateitem")
public class UpdateItemServlet extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
	 MultipartRequest m=new MultipartRequest(req,"D:\\javaprogram\\Food Ordering System\\WebContent\\photos",13548776);
     File ff = m.getFile("image");
	
	int menu_id=Integer.parseInt(m.getParameter("menu_id"));
	String itemname=m.getParameter("item");
	double price=Double.parseDouble(m.getParameter("price"));
	String image=ff.getName();
	String description=m.getParameter("description");
	int menuitem_id=Integer.parseInt(m.getParameter("menuitem_id"));
	
	HttpSession session2 = req.getSession(false);
	String email_id = (String)session2.getAttribute("email");
		
	Resturant r = new Resturant();
	r.setEmail_id(email_id);
	
	int rest_id = 0;
	
	try
	{
		rest_id= r.getRestId();
	}
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	try
	{
		MenuItem m1=new MenuItem();
		m1.setResturant_id(rest_id);
		m1.setItemname(itemname);
		m1.setMenu_id(menu_id);
		m1.setPrice(price);
		m1.setDescription(description);
		m1.setImage(image);
		m1.setMenuitem_id(menuitem_id);
		
		
		int res = m1.updateMenuItem();
		
		RequestDispatcher rd = req.getRequestDispatcher("item.jsp");
		
		if(res == 1)
		{
			req.setAttribute("msg", "Success");
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

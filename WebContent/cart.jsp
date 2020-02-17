<%@page import="java.util.ArrayList"%>
<%@page import="bean.MenuItem"%>
<%@page import="bean.Resturant"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
	.table1
	{
		width:60%;
		margin-left: 20%;
		border:2px solid black;
		border-collapse: collapse;
		
	}
	td,tr
	{
		border:2px solid black;
		text-align: center;
		border-collapse: collapse;
	}
	body
	{
	     	background-image:  url("photos/407349.jpg");
	     	background-size: cover;
	}
	.gap
	{
	    	margin-top: -450px; 
	}
	.img1
	{
		width:100px;
		height:100px;
	}
</style>
</head>
<body>
		<header>
			 	<jsp:include page="homemenu.jsp"></jsp:include>
		</header>
		<div class="gap"></div>
		
		<table class="table1">
			<tr>
				<td>SNo.</td>
	 			<td>Image</td>
	 			<td>Item Name</td>
	 			<td>Price</td>
	 			<td>Quantity</td>
	 			<td>Total</td>
	 		</tr>
	 		<%
	 			HttpSession httpSession = request.getSession(false);
	 			String userid = (String) httpSession.getAttribute("userid");
	 			//System.out.print("Cart session: "+userid);
	 			
	 			int sno = 1;
	 			double total_amt = 0;
	 		 %>
	 		 
	 		<jsp:useBean id="obj1" class="bean.CartBean"></jsp:useBean>
	 		<jsp:setProperty property="userid" name="obj1" value="${userid}"/>
	 		
	 		<c:forEach items="${obj1.getCartItemByUserid()}" var="x">
	 			<tr>
					<td><%=sno %></td>
					<c:set var="menuitem_id" value="${x.menuitem_id}"></c:set>
					<%
					    
						MenuItem mi = new MenuItem();
						int menuitem_id = Integer.parseInt(pageContext.getAttribute("menuitem_id").toString());
						mi.setMenuitem_id(menuitem_id);
						MenuItem myitem = mi.showAllMenuItemByItemId();
						String item = myitem.getItemname();
						String image = myitem.getImage();
						double price = myitem.getPrice();
					 %>
		 			<td>
		 				<img class="img1" src="photos/<%=image %>" width="100px" height="100px">
		 			</td>
		 			<td>
		 				<%=item %>
		 			</td>
		 			<td>
		 				<%=price %> Rs
		 				<c:set var="price" value="<%=price %>"></c:set>
		 			</td>
		 			<td>
		 				<a href="plus?cartid=${x.cartid}&quantity=${x.quantity}"><b> + </b></a>
		 					${x.quantity}
		 					<c:set var="quantity" value="${x.quantity}"></c:set>
		 				<a href="minus?cartid=${x.cartid}&quantity=${x.quantity}"><b> - </b></a>
		 			</td>
		 			<td>
			 			<%
			 				double price1 = Double.parseDouble(pageContext.getAttribute("price").toString()); 
			 				double quantity1 =  Double.parseDouble(pageContext.getAttribute("quantity").toString()); 
			 				
			 				double total = price1*quantity1;
			 				
			 				total_amt = total_amt + total;
			 			 %>
		 				<%=total %>
		 			</td>
		 		
		 			<td><a href="removecartitem?cartid=${x.cartid}"><b> Remove </b></a></td>
		 		</tr>
		 		<%= sno++ %>
	 		</c:forEach>
	 		
	 		
	 		<tr>
	 			<td colspan="6"><hr></td>
	 		</tr>
	 		<tr>
				<td colspan="5">Total Amount</td>
	 			<td><%=total_amt %> Rs</td>
	 		</tr>
	 		<tr>
	 			<td colspan="6"><hr></td>
	 		</tr>
	 		<tr>
				<td colspan="6"><input class="btn" type="submit" name="order" value="Order Now"></td>
	 		</tr>
		</table>
		
</body>
</html>
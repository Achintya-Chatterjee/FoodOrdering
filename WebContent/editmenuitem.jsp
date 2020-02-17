<%@page import="bean.MenuItem"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="bean.Resturant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mystyle.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int menuitem_id = Integer.parseInt(request.getParameter("menuitem_id"));

	MenuItem mi = new MenuItem();
	mi.setMenuitem_id(menuitem_id);
	ResultSet rs  = mi.showAllMenuItemByItemId();
	
	int menu_id=0;
	String itemname="";
	String image="photos/";
	String description="";
	double price=0;
	
	
	if(rs.next())
	{
		menu_id = rs.getInt("menu_id");
		description=rs.getString("description");
		image=  image+rs.getString("image");
		price=rs.getDouble("price");
		itemname=rs.getString("itemname");
	}
	System.out.print("Image name "+image);
	System.out.print("description "+description);

%>
	

<form action="updateitem" method="post" enctype="multipart/form-data">
	<input type ="hidden" name = "menu_id" value="<%=menu_id %>">
	<input type ="hidden" name = "menuitem_id" value="<%=menuitem_id %>">	
	<table >
 	
	 	
	 		
	 			<tr>
	 				<th rowspan="5"><img src="<%=image %>" width="20%" height="200px"></th>
	 			
	 			</tr>
	 			<tr>
	 			<td class="inp">Item id</td>
	 				<td><%=menu_id %></td>
	 			</tr>
	 			<tr>
	 			<td class="inp">Item Name</td>
	 			<td><input type ="text" name = "item" value="<%=itemname %>"></td>
	 		</tr>
	 		<tr>
	 			<td class="inp"> Price</td>
	 			<td><input type="text" name="price" value="<%=price %>"> </td>
 			</tr>
 		
	 		<tr>
	 			<td class="inp">Item Image</td>
	 			<td><input type="file"name="image"></td>
	 		</tr>
	 		
	 		<tr>
	 			<td class="reg"><span>Description</span></td>
		 		<td>
		 			  <input name="description"  value="<%=description %>" >
		 		</td>
	 		</tr>
	 			
	 		
	 		<tr>
 		 	<td>
			<td colspan="2" align="center" ><input class ="btn" type="submit" name="update" value="Update">
				
					    	
			</td>
		</tr>
	 		
 		</table>
 </form>
</body>
</html>
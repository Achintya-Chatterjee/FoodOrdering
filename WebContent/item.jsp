<%@page import="bean.Resturant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
		.mar
		{
			margin-top: 10px;
		}
		body
		{
	     	background-image:  url("photos/back.jpg");
	     	background-size: cover;
	    }
	    .gap
	    {
	    	margin-top: -750px; 
	    }
</style>
<link rel="stylesheet" href="css/mystyle.css">
<meta charset="ISO-8859-1">
<title>Item</title>
</head>
<body>
	<jsp:include page="restmenu.jsp"></jsp:include>
	<div class="gap"></div>
	
	<%
 		HttpSession session2 = request.getSession(false);
 		String email_id = (String)session2.getAttribute("email");
 		
 		Resturant r = new Resturant();
		r.setEmail_id(email_id);
		int rest_id= r.getRestId();
 	%>
 	
 	<jsp:useBean id="obj" class="bean.Menu"></jsp:useBean>
	
	<jsp:setProperty property="resturant_id" name="obj" value="<%=rest_id %>"/>
	
	
	<h1 >Add New Item</h1>
 <form action="resitem" method="post" enctype="multipart/form-data">
 	<table class="input itemtable">
	 	<tr>
	 			<td class="reg"><span>Select Menu </span></td>
	 			<td >
	 				 <select class="type" name="menuid" size="" >
	 				 	<option value="select">Select</option>
	 				    <c:forEach items="${obj.showAllMenuById()}" var="m">
	 				    	<option value="${m.menu_id}">${m.menuname}</option>
	 				    </c:forEach>
	 				 	
					  </select>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="inp">Item Name</td>
	 			<td><input type="text" name="item" ></td>
	 		</tr>
	 		<tr>
	 			<td class="inp">Item Price</td>
	 			<td><input type="text" name="price" ></td>
 			</tr>
 		
	 		<tr>
	 			<td class="inp">Item Image</td>
	 			<td><input type="file"name="image"></td>
	 		</tr>
	 		
	 		<tr>
	 			<td class="reg"><span>Description</span></td>
		 		<td>
		 			 <textarea name="description" rows="4" cols="30"></textarea>
		 		</td>
	 		</tr>
	 		
	 		<tr>
	 		 	<td colspan="2" align="center" ><input class ="btn" type="submit" name="add" value="ADD"></td>
	 		</tr>
	 		<tr>
	 		 	<td colspan="2" align="center">${requestScope['msg']}</td>
	 		</tr>
 	</table>
 </form>
 <form>
 
 
 	<table class="mar">
 	<jsp:useBean id="ob" class="bean.MenuItem"></jsp:useBean>
	
	<jsp:setProperty property="resturant_id" name="ob" value="<%=rest_id%>"/>
	
 		<c:forEach items="${ob.showMenuByResturantId()}" var="x">
 			<tr>
 				<th rowspan="5"><img src="photos/${x.image}" width="20%" height="200px"></th>
 			
 			</tr>
 			<tr>
 				<td>${x.menu_id}</td>
 			</tr>
 			<tr>
 				<th>catagory</th>
 			</tr>
 			<tr>
 				<th></th>
 			</tr>
 			<tr>
 				<th>${x.price}</th>
 			</tr>
 			<tr>
 				<th>Quantity</th>
 			</tr>
 			
 		<tr>
 			<td class="reg"><span>Description</span></td>
	 		<td>
	 			${x.description}
	 		</td>
	 		
 		</tr>
 		<tr>
 		 	<td>
				<a href="editmenuitem.jsp?menuitem_id=${x.menuitem_id}" style="color:blue">Edit</a>
				 <a href="deleteitem?menuitem_id=${x.menuitem_id}" style="color:red">Delete</a>
					    	
			</td>
		</tr>
 		 </c:forEach>
 		</table>
 </form>
</body>
</html>
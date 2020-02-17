<%@page import="bean.Resturant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mystyle.css">
<meta charset="ISO-8859-1">
<title>Resturant Menu</title>
<style>
		body
		{
	     	background-image:  url("photos/back.jpg");
	     	background-size: cover;
	    }
	    .gap
	    {
	    	margin-top: -550px; 
	    }
	    h5,p
	    {
	    	color:white;
	    	font-size: 20px;
	    }
	    td
	    {
	    	color:white;
	    }
</style>
</head>
<body>
	<jsp:include page="restmenu.jsp"></jsp:include>
	<div class="gap"></div>
   <h3 >Add New Menu</h3>
	<form action="addmenu" method="post" >
 	<table class="input">
 		
 		<tr>
 			<td class ="inp">Enter Menu</td>
 			<td><input type="text" name="menu" ></td>
 		</tr>
 		<tr>
 		 	<td colspan="2" align="center" ><input class ="btn" type="submit" name="submit" value="Submit" style="color:black"></td>
 		</tr>
 		<tr>
 		 	<td colspan="2" align="center">${requestScope['msg']}</td>
 		</tr>
 	</table>
 	</form>
 	<form action="updatemenu" method="post" >
 	
 	<jsp:useBean id="obj" class="bean.Menu"></jsp:useBean>
 	<%
 		HttpSession session2 = request.getSession(false);
 		String email_id = (String)session2.getAttribute("email");
 		
 		Resturant r = new Resturant();
		r.setEmail_id(email_id);
		int rest_id= r.getRestId();
 	%>
 	
 	<jsp:setProperty property="resturant_id" name="obj" value="<%=rest_id %>"/>
 	
 	<table class="second">
	 	 <tr>
		    <th>Menu Id</th>
		    <th >Name</th>
		    <th >Action</th>
	     </tr>
	     <c:forEach items="${obj.showAllMenuById()}" var="x">
	     <c:choose>
					<c:when test="${x.menu_id==param.menu_id}">
						<tr>
							<td><input type="text" name="menu_id" value="${x.menu_id}" readonly="readonly"></td>
							<td><input type="text" name="menuname" value="${x.menuname}"></td>
							<td>
								<input type="submit" name="btnSave" value="Save">
								<a href="?" style="background-color: red;color:white">Cancel</a>
							</td>
						</tr>
					</c:when>
	   
				     <c:otherwise>
					  <tr>
					    <td>${x.menu_id}</td>
					    <td>${x.menuname}</td>
					    <td>
					    	<a href="?menu_id=${x.menu_id}" style="color:blue">Edit</a>
					    	<a href="deletemenu?menu_id=${x.menu_id}" style="color:red">Delete</a>
					    	<a href="" style="color:green">View</a>
					    </td>
					  </tr>
					  </c:otherwise>
		 </c:choose>
		  </c:forEach>
 	</table>
 	</form>
</body>
</html>
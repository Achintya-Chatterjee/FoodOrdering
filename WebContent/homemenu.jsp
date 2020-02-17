<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/mystyle.css">
</head>
<body>
<%
	HttpSession session2 = request.getSession(false);
	String userid = (String) session2.getAttribute("userid");
	
 %>

	<header>
			 <div class=logo1>
				<img alt="" src="photos/logo1.png">
				</div>
				<div class="log">
				
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li>
						<div class="dropdown">
						  <button class="dropbtn">Menu</button>
							  <div class="dropdown-content">
							    <a href="showAllItem.jsp">Veg</a>
							    <a href="showAllItemByMenu.jsp">Non-Veg</a>
							    <a href="#">Chinese</a>
						      </div>
						</div>
					  </li>
						
						<li>
						<div class="dropdown">
						  <button class="dropbtn">More</button>
							  <div class="dropdown-content">
							    <a href="about.jsp">About us</a>
							    <a href="contact.jsp">Contact</a>
						      </div>
						</div>
					  </li>
					  <c:choose>
					  	<c:when test="${userid != null }">
					  		<li><a href="userhistory.jsp">History</a></li>
					  		
					  		<jsp:useBean id="obj" class="bean.CartBean"></jsp:useBean>
					  		<jsp:setProperty property="userid" name="obj" value="${userid}"/>
					  		
					  		<li><a href="cart.jsp">Cart [ ${obj.getTotalCartByUserid()} ]</a></li>
					  		<li><a href="userlogout">Logout</a></li>
					  	</c:when>
					  	<c:otherwise>
					  		<li><a href="userlogin.jsp">Login</a></li>
					  	</c:otherwise>
					  </c:choose>
					  
					</ul>
				</div>
			</header>
			
			<div class="grid"></div>
			<h1> </h1>
</body>
</html>
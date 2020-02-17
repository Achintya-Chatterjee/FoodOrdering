<%
	HttpSession session2 = request.getSession(false);
    String email = (String)session.getAttribute("email");
    if(email==null)
    {
    	RequestDispatcher rd1 = request.getRequestDispatcher("resturantslogin.jsp");
		request.setAttribute("msg","Sorry invalid userid or password");
		rd1.forward(request, response);
    }
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mystyle.css">
<meta charset="ISO-8859-1">
<title>Resturant Home</title>
<style>
		body
		{
	     	background-image:  url("photos/back.jpg");
	     	background-size: cover;
	    }
	    .gap
	    {
	    	margin-top: -450px; 
	    }
	    h5,p
	    {
	    	color:white;
	    	font-size: 20px;
	    }
</style>
</head>
<body>
	<jsp:include page="restmenu.jsp"></jsp:include>

			
</body>
</html>
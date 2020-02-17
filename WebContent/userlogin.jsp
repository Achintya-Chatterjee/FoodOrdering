<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mystyle.css">
<meta charset="ISO-8859-1">
<title> User Login</title>
<style>
		body
		{
	     	background-image:  url("photos/407349.jpg");
	     	background-size: cover;
	    }
	    .gap
	    {
	    	margin-top: -550px; 
	    }
	    
</style>
</head>
<body>
	<jsp:include page="homemenu.jsp"></jsp:include>
	<div class="gap"></div>
 	<h1 > User Login</h1>
 <form action="userlog" method="post" >
 	<table class="input">
 		<tr>
 			<td class="inp">Enter Your Id</td>
 			<td><input type="text" name="id" ></td>
 		</tr>
 		<tr>
 			<td class ="inp">Enter Password</td>
 			<td><input type="password" name="userpassword" ></td>
 		</tr>
 		<tr>
 		 	<td colspan="2" align="center" ><input class ="btn" type="submit" name="login" value="Login" style="color:black"></td>
 		</tr>
 		<tr>
 		 	<td colspan="2" align="center" >Not a Member? <a href="signupresturant.jsp">Join now</a></td>
 		</tr>
 	</table>
 </form>
</body>
</html>
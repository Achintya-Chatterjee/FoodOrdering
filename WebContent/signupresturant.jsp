<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mystyle.css">
<meta charset="ISO-8859-1">
<title>Resturant Signup</title>
<style>
		body
		{
	     	background-image:  url("photos/407349.jpg");
	     	background-size: cover;
	    }
	    .gap
	    {
	    	margin-top: -650px; 
	    }
	    
	</style>
</head>
<body>
	<jsp:include page="homemenu.jsp"></jsp:include>
	<div class="gap"></div>
	<h1 >Sign Up</h1>
 <form action="resregister" method="post" >
 	<table class="input">
 		<tr>
 			<td class="inp">Enter Restaurant Name</td>
 			<td><input type="text" name="resname" ></td>
 		</tr>
 		<tr>
 			<td class="inp">Enter Owner Name</td>
 			<td><input type="text" name="ownername" ></td>
 		</tr>
 		<tr>
 			<td class="inp">Enter Email Id</td>
 			<td><input type="text" name="eid" ></td>
 		</tr>
 		<tr>
 			<td class="reg"><span>Type Of Restaurant </span></td>
 			<td >
 				 <select class="type" name="catagory" size="" >
 				 	<option value="select">Select Type </option>
				    <option value="ffood">Fast food.</option>
				    <option value="veg">Veg</option>
				    <option value="nonveg">Non-Veg</option>
				  </select>
 			</td>
 		</tr>
 		<tr>
 			<td class="reg"><span>Select State</span></td>
 			<td >
 				 <select class="inpstate" name="state" size="" >
 				 	<option value="select">Select State</option>
				    <option value="westbengal">West bengal</option>
				    <option value="bihar">Bihar</option>
				    <option value="Jharkhand">Jharkhand</option>
				    <option value="delhi">Delhi</option>
				  </select>
 			</td>
 		</tr>
 		<tr>
 			<td class="reg"><span>Select City</span></td>
 			<td >
 				 <select class="inpcity" name="city" size="" >
 				 	<option value="select">Select City</option>
				    <option value="wb">West bengal</option>
				    <option value="bihar">Bihar</option>
				    <option value="Jh">Jharkhand</option>
				    <option value="del">Delhi</option>
				  </select>
 			</td>
 		</tr>
 		<tr>
 			<td class="reg"><span>Address</span></td>
	 		<td>
	 			 <textarea name="address" rows="4" cols="30"></textarea>
	 		</td>
 		</tr>
 		<tr>
 			<td class ="inp">Enter Password</td>
 			<td><input type="Password" name="password" ></td>
 		</tr>
 		<tr>
 		 	<td colspan="2" align="center" ><input class ="btn" type="submit" name="signup" value="Sign Up" style="color:black"></td>
 		</tr>
 		<tr>
 		 	<td colspan="2" align="center">${requestScope['msg']}</td>
 		</tr>
 		</table>
 </form>
</body>
</html>
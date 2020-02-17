<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/fos.css">
<meta charset="ISO-8859-1">
<title>Resturant login</title>
</head>
<body>
		<h1 >Login</h1>
 <form action="reslogin" method="post" >
 	<table class="input">
 		<tr>
 			<td class="inp">Enter Restaurant Id</td>
 			<td><input type="text" name="eid" ></td>
 		</tr>
 		<tr>
 			<td class ="inp">Enter Password</td>
 			<td><input type="Password" name="password" ></td>
 		</tr>
 		<tr>
 		 	<td colspan="2" align="center" ><input class ="btn" type="submit" name="login" value="Login"></td>
 		</tr>
 		<tr>
 			<td colspan="2" align="center"><h4>New Restaurants ?<a href="">Click Here</a></h4></td>
 		</tr>
 		<tr>
 			<td colspan="2" align="center"><h4>${requestScope['errmsg']}</h4></td>
 		</tr>
 	</table>
 </form>
</body>
</html>
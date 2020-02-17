<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/mystyle.css">
<meta charset="ISO-8859-1">
<title>index</title>
<style>
	a
	{
		color:black;
	}
</style>
</head>
<body>
<header>
				<div class="main" >
				<div class="log">
				
				
				</div>
					<ul>
						<li><a href="resturanthome.jsp">Home</a></li>
						<li><a href="menu.jsp">Menu</a></li>
						<li><a href="item.jsp">Item</a></li>
						<li><a href="#">Order</a></li>
						<li><a href="#" style="margin-right:350px">History</a></li>
						<li><a href="" style="margin-left:350px">${requestScope['name']}</a></li>
						<li><a href="logout">Log Out</a></li>
					</ul>
					
				</div>
				
	</header>
</body>